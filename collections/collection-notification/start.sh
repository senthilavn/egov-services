/Users/senthil/eGov/source/egov-services/collections/collection-notification/start.sh#!/bin/sh

if [[ -z "${JAVA_OPTS}" ]];then
    export JAVA_OPTS="-Xmx64m -Xms64m"
fi

java ${JAVA_OPTS} -jar /opt/egov/collection-notification.jar