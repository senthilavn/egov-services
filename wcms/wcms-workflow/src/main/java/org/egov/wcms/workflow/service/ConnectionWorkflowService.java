package org.egov.wcms.workflow.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.request.User;
import org.egov.tracer.kafka.LogAwareKafkaTemplate;
import org.egov.wcms.workflow.config.ApplicationProperties;
import org.egov.wcms.workflow.model.contract.ProcessInstanceRequest;
import org.egov.wcms.workflow.model.contract.ProcessInstanceResponse;
import org.egov.wcms.workflow.model.contract.TaskRequest;
import org.egov.wcms.workflow.model.contract.TaskResponse;
import org.egov.wcms.workflow.model.contract.WaterConnectionReq;
import org.egov.wcms.workflow.model.contract.WorkFlowRequestInfo;
import org.egov.wcms.workflow.models.Connection;
import org.egov.wcms.workflow.models.Position;
import org.egov.wcms.workflow.models.ProcessInstance;
import org.egov.wcms.workflow.models.Task;
import org.egov.wcms.workflow.models.UserInfo;
import org.egov.wcms.workflow.models.WorkflowDetails;
import org.egov.wcms.workflow.repository.WorkflowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConnectionWorkflowService {

    private final WorkflowRepository workflowRepository;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private LogAwareKafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public ConnectionWorkflowService(final WorkflowRepository workflowRepository) {
        this.workflowRepository = workflowRepository;
    }

    public void initiateWorkFlow(final HashMap<String, Object> workflowEnrichedMap,
            final WaterConnectionReq waterConnectionReq) {
        enrichWorkflow(waterConnectionReq, waterConnectionReq.getRequestInfo(), applicationProperties.getBusinessKey());
        workflowEnrichedMap.put(applicationProperties.getInitiatedWorkFlow(), waterConnectionReq);

        kafkaTemplate.send(applicationProperties.getInitiatedWorkFlow(), applicationProperties.getInitiatedWorkFlow(),
                workflowEnrichedMap);
    }

    public void updateWorkFlow(final Map<String, Object> consumerRecord, final HashMap<String, Object> workflowEnrichedMap,
            final WaterConnectionReq waterConnectionReq) {
        enrichWorkflow(waterConnectionReq, waterConnectionReq.getRequestInfo(), applicationProperties.getBusinessKey());
        workflowEnrichedMap.put(applicationProperties.getUpdatedWorkFlow(), waterConnectionReq);

        kafkaTemplate.send(applicationProperties.getUpdatedWorkFlow(), applicationProperties.getUpdatedWorkFlow(),
                consumerRecord);
    }

    public WaterConnectionReq enrichWorkflow(final WaterConnectionReq waterConnectionReq, final RequestInfo requestInfo,
            final String bisinessKey) {

        final Connection connection = waterConnectionReq.getConnection();
        if (connection.getStateId() == null) {

            ProcessInstanceResponse processInstanceResponse = null;
            final ProcessInstanceRequest request = getProcessInstanceRequest(connection.getWorkflowDetails(),
                    connection.getTenantId(), bisinessKey);

            final WorkFlowRequestInfo req = PrepareWorkFlowRequestInfo(connection, requestInfo);

            request.setRequestInfo(req);

            processInstanceResponse = workflowRepository.start(request);

            if (processInstanceResponse != null)
                update(processInstanceResponse, connection);

        } else if (isWorkflowUpdate(connection.getWorkflowDetails())) {

            TaskResponse taskResponse = null;
            final TaskRequest taskRequest = new TaskRequest();
            final Task task = new Task();
            final WorkFlowRequestInfo req = PrepareWorkFlowRequestInfo(connection, requestInfo);
            taskRequest.setTask(task);
            taskResponse = workflowRepository.update(taskRequest);
            taskRequest.setRequestInfo(req);
            if (taskResponse != null)
                update(taskResponse, connection);

        }
        waterConnectionReq.setConnection(connection);
        return waterConnectionReq;
    }

    protected WorkFlowRequestInfo PrepareWorkFlowRequestInfo(final Connection connection, final RequestInfo requestInfo) {
        final WorkFlowRequestInfo req = new WorkFlowRequestInfo();
        req.setApiId(requestInfo.getApiId());
        req.setDid(requestInfo.getDid());
        req.setKey(requestInfo.getKey());
        req.setAuthToken(requestInfo.getAuthToken());
        req.setMsgId(requestInfo.getMsgId());
        req.setAction(requestInfo.getAction());
        req.setTenantId(connection.getTenantId());
        final User newuser = requestInfo.getUserInfo();
        final UserInfo workflowUser = new UserInfo();
        workflowUser.setId(newuser.getId());
        workflowUser.setUserName(newuser.getUserName());
        req.setUserInfo(workflowUser);
        req.setVer(requestInfo.getVer());
        req.setTs(new Date());
        return req;
    }

    private ProcessInstanceRequest getProcessInstanceRequest(final WorkflowDetails workFlowDetails, final String tenantId,
            final String bisinessKey) {

        final ProcessInstanceRequest processInstanceRequest = new ProcessInstanceRequest();
        final ProcessInstance processInstance = new ProcessInstance();
        processInstance.setBusinessKey(bisinessKey);
        processInstance.setType(bisinessKey);
        processInstance.setComments(workFlowDetails.getComments());
        processInstance.setTenantId(tenantId);
        final Position assignee = new Position();
        assignee.setId(workFlowDetails.getAssignee());
        processInstance.setInitiatorPosition(workFlowDetails.getInitiatorPosition());
        processInstance.setAssignee(assignee);
        processInstanceRequest.setProcessInstance(processInstance);

        return processInstanceRequest;
    }

    private boolean isWorkflowUpdate(final WorkflowDetails workFlowDetails) {
        return workFlowDetails != null && workFlowDetails.getAction() != null && !workFlowDetails.getAction().isEmpty();
    }

    private void update(final ProcessInstanceResponse processInstanceResponse, final Connection connection) {
        if (connection != null)
            connection.setStateId(Long.valueOf(processInstanceResponse.getProcessInstance().getId()));
    }

    private void update(final TaskResponse taskResponse, final Connection connection) {
        if (connection != null)
            connection.setStateId(Long.valueOf(taskResponse.getTask().getId()));
    }

}
