var rooms = {
 "name": "Rooms",
 "version": "v1",
 "level": 2,
 "jsonPath": "rooms",
 "groups": [
  {
   "label": "Room",
   "name": "Room",
   "multiple": true,
   "children": [],
   "fields": [
		{
			"name": "FloorNumber",
			"jsonPath": "properties[0].propertyDetail.floors[0].floorNo",
			"label": "pt.create.groups.propertyAddress.fields.floorNumber",
			"pattern": "",
			"type": "singleValueList",
			"isRequired": true,
			"isDisabled": false,
			"requiredErrMsg": "",
			"url":"",
			"patternErrMsg": "",
			"defaultValue":[]
		},
		{
			"name": "UnitType",
			"jsonPath": "properties[0].propertyDetail.floors[0].units[0].units[0].unitType",
			"label": "pt.create.groups.propertyAddress.fields.unitType",
			"pattern": "",
			"type": "singleValueList",
			"isRequired": true,
			"isDisabled": false,
			"requiredErrMsg": "",
			"url":"",
			"patternErrMsg": "",
			"defaultValue":[]
		},
		{
			"name": "UnitNumber",
			"jsonPath": "properties[0].propertyDetail.floors[0].units[0].units[0].unitNo",
			"label": "pt.create.groups.propertyAddress.fields.unitNumber",
			"pattern": "",
			"type": "number",
			"isRequired": true,
			"isDisabled": false,
			"requiredErrMsg": "",
			"patternErrMsg": ""
		},
		{
			"name": "ConstructionType",
			"jsonPath": "properties[0].propertyDetail.floors[0].units[0].units[0].structure",
			"label": "pt.create.groups.propertyAddress.fields.constructionType",
			"pattern": "",
			"type": "singleValueList",
			"isRequired": true,
			"isDisabled": false,
			"requiredErrMsg": "",
			"url":"",
			"patternErrMsg": "",
			"defaultValue":[]
		},
		{
			"name": "UsageType",
			"jsonPath": "properties[0].propertyDetail.floors[0].units[0].units[0].usage",
			"label": "pt.create.groups.propertyAddress.fields.usageType",
			"pattern": "",
			"type": "singleValueList",
			"isRequired": true,
			"isDisabled": false,
			"requiredErrMsg": "",
			"url":"",
			"patternErrMsg": "",
			"defaultValue":[]
		},
		{
			"name": "UsageSubType",
			"jsonPath": "properties[0].propertyDetail.floors[0].units[0].units[0].usageSubType",
			"label": "pt.create.groups.propertyAddress.fields.usageSubType",
			"pattern": "",
			"type": "singleValueList",
			"isRequired": false,
			"isDisabled": false,
			"requiredErrMsg": "",
			"url":"",
			"patternErrMsg": "",
			"defaultValue":[]
		},
		{
			"name": "FirmName",
			"jsonPath": "properties[0].propertyDetail.floors[0].units[0].units[0].firmName",
			"label": "pt.create.groups.propertyAddress.fields.firmName",
			"pattern": "",
			"type": "text",
			"isRequired": false,
			"isDisabled": false,
			"requiredErrMsg": "",
			"patternErrMsg": "",
		},
		{
			"name": "Occupancy",
			"jsonPath": "properties[0].propertyDetail.floors[0].units[0].units[0].occupancyType",
			"label": "pt.create.groups.propertyAddress.fields.occupancy",
			"pattern": "",
			"type": "singleValueList",
			"isRequired": true,
			"isDisabled": false,
			"requiredErrMsg": "",
			"url":"",
			"patternErrMsg": "",
			"defaultValue":[]
		},
		{
			"name": "OccupantName",
			"jsonPath": "properties[0].propertyDetail.floors[0].units[0].units[0].occupierName",
			"label": "pt.create.groups.propertyAddress.fields.occupantName",
			"pattern": "",
			"type": "text",
			"isRequired": false,
			"isDisabled": false,
			"requiredErrMsg": "",
			"patternErrMsg": "",
		},
		{
			"name": "AnnualRent",
			"jsonPath": "properties[0].propertyDetail.floors[0].units[0].units[0].annualRent",
			"label": "pt.create.groups.propertyAddress.fields.AnnualRent",
			"pattern": "",
			"type": "text",
			"isRequired": false,
			"isDisabled": false,
			"requiredErrMsg": "",
			"patternErrMsg": "",
		},
		{
			"name": "ManualArv",
			"jsonPath": "properties[0].propertyDetail.floors[0].units[0].units[0].manualArv",
			"label": "pt.create.groups.propertyAddress.fields.manualArv",
			"pattern": "",
			"type": "text",
			"isRequired": false,
			"isDisabled": false,
			"requiredErrMsg": "",
			"patternErrMsg": "",
		},
		{
			"name": "ConstructionDate",
			"jsonPath": "properties[0].propertyDetail.floors[0].units[0].units[0].constCompletionDate",
			"label": "pt.create.groups.propertyAddress.fields.constructionDate",
			"pattern": "",
			"type": "datePicker",
			"isRequired": true,
			"isDisabled": false,
			"requiredErrMsg": "",
			"patternErrMsg": "",
		},
		{
			"name": "EffectiveFromDate",
			"jsonPath": "properties[0].propertyDetail.floors[0].units[0].units[0].occupancyDate",
			"label": "pt.create.groups.propertyAddress.fields.effectiveFromDate",
			"pattern": "",
			"type": "datePicker",
			"isRequired": true,
			"isDisabled": false,
			"requiredErrMsg": "",
			"patternErrMsg": "",
		},
		{
			"name": "UnstructuredLand",
			"jsonPath": "properties[0].propertyDetail.floors[0].units[0].units[0].isStructured",
			"label": "pt.create.groups.propertyAddress.fields.unstructuredLand",
			"pattern": "",
			"type": "singleValueList",
			"url":"",
			"isRequired": true,
			"isDisabled": false,
			"requiredErrMsg": "",
			"patternErrMsg": "",
			"defaultValue":[]
		},
		{
			"name": "Length",
			"jsonPath": "properties[0].propertyDetail.floors[0].units[0].units[0].length",
			"label": "pt.create.groups.propertyAddress.fields.length",
			"pattern": "",
			"type": "number",
			"isRequired": false,
			"isDisabled": false,
			"requiredErrMsg": "",
			"patternErrMsg": ""
		},
		{
			"name": "Breadth",
			"jsonPath": "properties[0].propertyDetail.floors[0].units[0].units[0].width",
			"label": "pt.create.groups.propertyAddress.fields.breadth",
			"pattern": "",
			"type": "number",
			"isRequired": false,
			"isDisabled": false,
			"requiredErrMsg": "",
			"patternErrMsg": ""
		},
		{
			"name": "PlinthArea",
			"jsonPath": "properties[0].propertyDetail.floors[0].units[0].units[0].builtupArea",
			"label": "pt.create.groups.propertyAddress.fields.plinthArea",
			"pattern": "",
			"type": "number",
			"isRequired": true,
			"isDisabled": false,
			"requiredErrMsg": "",
			"patternErrMsg": ""
		},
		{
			"name": "OccupancyCertificateNumber",
			"jsonPath": "properties[0].propertyDetail.floors[0].units[0].units[0].occupancyCertiNumber",
			"label": "pt.create.groups.propertyAddress.fields.occupancyCertificateNumber",
			"pattern": "",
			"type": "number",
			"isRequired": false,
			"isDisabled": false,
			"requiredErrMsg": "",
			"patternErrMsg": ""
		},
		{
			"name": "BuildingPermissionNumber",
			"jsonPath": "properties[0].propertyDetail.floors[0].units[0].units[0].bpaNo",
			"label": "pt.create.groups.propertyAddress.fields.buildingPermissionNumber",
			"pattern": "",
			"type": "number",
			"isRequired": false,
			"isDisabled": false,
			"requiredErrMsg": "",
			"patternErrMsg": ""
		},
		{
			"name": "BuildingPermissionDate",
			"jsonPath": "properties[0].propertyDetail.floors[0].units[0].units[0].bpaDate",
			"label": "pt.create.groups.propertyAddress.fields.buildingPermissionDate",
			"pattern": "",
			"type": "datePicker",
			"isRequired": false,
			"isDisabled": false,
			"requiredErrMsg": "",
			"patternErrMsg": ""
		},
		{
			"name": "PlinthAreaInBuildingPlan",
			"jsonPath": "properties[0].propertyDetail.floors[0].units[0].units[0].bpaBuiltupArea",
			"label": "pt.create.groups.propertyAddress.fields.plinthAreaInBuildingPlan",
			"pattern": "",
			"type": "number",
			"isRequired": false,
			"isDisabled": false,
			"requiredErrMsg": "",
			"patternErrMsg": ""
		},
   ]
  }
 ]
}

var dat = {
	"dataEntry.create": {
		"numCols": 12/3,
		"version": "v1",
		"url": "pt-property/properties/_create",
		"useTimestamp": true,
		"objectName": "properties",
		"level": 0,
		"groups": [
			{
				"label": "UPIC Details",
				"name": "UpicNumber",
				"fields": [
						{
							"name": "UpicNumber",
							"jsonPath": "UpicNumber",
							"label": "pt.create.groups.propertyAddress.fields.upicNumber",
							"pattern": "",
							"type": "text",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						}		
				]
			},
			{
				"label": "Owner Details",
				"name": "OwnerDetails",
				"multiple":true,
				"fields": [
						{
							"name": "AadhaarNumber",
							"jsonPath": "properties[0].owners[0].aadhaarNumber",
							"label": "pt.create.groups.propertyAddress.fields.aadhaarNumber",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "PhoneNumber",
							"jsonPath": "properties[0].owners[0].mobileNumber",
							"label": "pt.create.groups.propertyAddress.fields.phoneNumber",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "OwnerName",
							"jsonPath": "properties[0].owners[0].name",
							"label": "pt.create.groups.propertyAddress.fields.ownerName",
							"pattern": "",
							"type": "text",
							"isRequired": true,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "Gender",
							"jsonPath": "properties[0].owners[0].gender",
							"label": "pt.create.groups.propertyAddress.fields.gender",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": true,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": "",
							"defaultValue": [{key:"", value:null},{key:'MALE', value:'Male'}, {key:'FEMALE', value:'Female'}, {key:'OTHERS', value:'Others'}],
						},
						{
							"name": "Email",
							"jsonPath": "properties[0].owners[0].emailId",
							"label": "pt.create.groups.propertyAddress.fields.email",
							"pattern": "",
							"type": "text",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "GuardianRelation",
							"jsonPath": "properties[0].owners[0].gaurdianRelation",
							"label": "pt.create.groups.propertyAddress.fields.guardianRelation",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": true,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": "",
							"defaultValue": [{key:-1, value:'None'}, {key:'FATHER', value:'Father'}, {key:'HUSBAND', value:'Husband'}, {key:'MOTHER', value:'Mother'}, {key:'OTHERS', value:'Others'}],
						},
						{
							"name": "Guardian",
							"jsonPath": "properties[0].owners[0].fatherOrHusbandName",
							"label": "pt.create.groups.propertyAddress.fields.guardian",
							"pattern": "",
							"type": "text",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "OwnerType",
							"jsonPath": "properties[0].owners[0].ownerType",
							"label": "pt.create.groups.propertyAddress.fields.ownerType",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": "",
							"defaultValue": [{key:-1, value:'None'},{key:'Ex_Service_man', value:'Ex-Service man'}, {key:'Freedom_Fighter', value:'Freedom Fighter'}, {key:'Freedom_fighers_wife', value:"Freedom figher's wife"}],
						},
						{
							"name": "PercentageOfOwnerShip",
							"jsonPath": "properties[0].owners[0].ownerShipPercentage",
							"label": "pt.create.groups.propertyAddress.fields.percentageOfOwnerShip",
							"pattern": "",
							"type": "text",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "PrimaryOwner",
							"jsonPath": "properties[0].owners[0].isPrimaryOwner",
							"label": "",
							"pattern": "",
							"type": "radio",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
							"values": [{"label":"Primary Owner", "value":true},{"label":"Secondary Owner", "value":false}],
							"defaultValue":true
						},
						
				]
			},
			{
				"label": "Property Address",
				"name": "PropertyAddress",
				"fields": [
						{
							"name": "ReferancePropertyNumber",
							"jsonPath": "ReferancePropertyNumber",
							"label": "pt.create.groups.propertyAddress.fields.referancePropertyNumber",
							"pattern": "",
							"type": "number",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "Appartment",
							"jsonPath": "Appartment",
							"label": "pt.create.groups.propertyAddress.fields.appartment",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": "",
							"defaultValue": [],
						},
						{
							"name": "DoorNo",
							"jsonPath": "properties[0].address.addressNumber",
							"label": "pt.create.groups.propertyAddress.fields.doorNo",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "Locality",
							"jsonPath": "properties[0].address.addressLine1",
							"label": "pt.create.groups.propertyAddress.fields.locality",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": true,
							"isDisabled": false,
							"url": "/egov-location/boundarys/boundariesByBndryTypeNameAndHierarchyTypeName?&boundaryTypeName=LOCALITY&hierarchyTypeName=LOCATION",
							"requiredErrMsg": "",
							"patternErrMsg": "",
							"defaultValue": [],
						},
						{
							"name": "ElectionWard",
							"jsonPath": "properties[0].boundary.adminBoundary.id",
							"label": "pt.create.groups.propertyAddress.fields.electionWard",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": true,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": "",
							"defaultValue": [],
						},
						{
							"name": "ZoneNo",
							"jsonPath": "properties[0].boundary.revenueBoundary.id",
							"label": "pt.create.groups.propertyAddress.fields.zoneNo",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": true,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": "",
							"defaultValue": [],
						},
						{
							"name": "WardNo",
							"jsonPath": "WardNo",
							"label": "pt.create.groups.propertyAddress.fields.wardNo",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": true,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": "",
							"defaultValue": [],
						},
						{
							"name": "BlockNo",
							"jsonPath": "BlockNo",
							"label": "pt.create.groups.propertyAddress.fields.blockNo",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": "",
							"defaultValue": [],
						},
						{
							"name": "Street",
							"jsonPath": "properties[0].boundary.locationBoundary.id",
							"label": "pt.create.groups.propertyAddress.fields.street",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": "",
							"defaultValue": [],
						},
						{
							"name": "RevenueCircle",
							"jsonPath": "RevenueCircle",
							"label": "pt.create.groups.propertyAddress.fields.revenueCircle",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": "",
							"defaultValue": [],
						},
						{
							"name": "Pin",
							"jsonPath": "properties[0].address.pin",
							"label": "pt.create.groups.propertyAddress.fields.pin",
							"pattern": "",
							"type": "number",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "IsCorrespondanceAddressDifferentFromAddress",
							"jsonPath": "IsCorrespondanceAddressDifferentFromAddress",
							"label": "pt.create.groups.propertyAddress.fields.isCorrespondanceAddressDifferentFromAddress",
							"pattern": "",
							"type": "checkbox",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
							"defaultValue": false,
						},
						{
							"name": "DoorNo",
							"jsonPath": "DoorNo2",
							"label": "pt.create.groups.propertyAddress.fields.doorNo",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "Address1",
							"jsonPath": "Address1",
							"label": "pt.create.groups.propertyAddress.fields.address1",
							"pattern": "",
							"type": "text",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "Pin",
							"jsonPath": "Pin2",
							"label": "pt.create.groups.propertyAddress.fields.pin",
							"pattern": "",
							"type": "number",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
				]
			},
			{
				"label": "Assessment details",
				"name": "AssessmentDetails",
				"fields": [
						{
							"name": "CreationReason",
							"jsonPath": "properties[0].creationReason",
							"label": "pt.create.groups.propertyAddress.fields.creationReason",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": true,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": "",
							"defaultValue":[]
						},
						{
							"name": "PropertyType",
							"jsonPath": "properties[0].propertyDetail.propertyType",
							"label": "pt.create.groups.propertyAddress.fields.propertyType",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": true,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": "",
							"defaultValue":[]
						},
						{
							"name": "PropertySubType",
							"jsonPath": "properties[0].propertyDetail.propertySubType",
							"label": "pt.create.groups.propertyAddress.fields.propertySubType",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": true,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": "",
							"defaultValue":[]
						},
						{
							"name": "Department",
							"jsonPath": "properties[0].propertyDetail.department",
							"label": "pt.create.groups.propertyAddress.fields.department",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": false,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": "",
							"defaultValue":[]
						},
						{
							"name": "ExtentOfSite",
							"jsonPath": "properties[0].propertyDetail.sitalArea",
							"label": "pt.create.groups.propertyAddress.fields.extentOfSite",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
				]
			},
			{
				"label": "Amenities",
				"name": "Amenities",
				"fields": [
						{
							"name": "Lift",
							"jsonPath": "Lift",
							"label": "pt.create.groups.propertyAddress.fields.lift",
							"pattern": "",
							"type": "checkbox",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "Toilet",
							"jsonPath": "Toilet",
							"label": "pt.create.groups.propertyAddress.fields.toilet",
							"pattern": "",
							"type": "checkbox",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "WaterTap",
							"jsonPath": "WaterTap",
							"label": "pt.create.groups.propertyAddress.fields.waterTap",
							"pattern": "",
							"type": "checkbox",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "Electricity",
							"jsonPath": "Electricity",
							"label": "pt.create.groups.propertyAddress.fields.electricity",
							"pattern": "",
							"type": "checkbox",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "AttachedBathroom",
							"jsonPath": "AttachedBathroom",
							"label": "pt.create.groups.propertyAddress.fields.attachedBathroom",
							"pattern": "",
							"type": "checkbox",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "CableConnection",
							"jsonPath": "CableConnection",
							"label": "pt.create.groups.propertyAddress.fields.cableConnection",
							"pattern": "",
							"type": "checkbox",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "WaterHarvesting",
							"jsonPath": "WaterHarvesting",
							"label": "pt.create.groups.propertyAddress.fields.waterHarvesting",
							"pattern": "",
							"type": "checkbox",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						
				]
			},
			{
				"label": "Construction Type",
				"name": "ConstructionType",
				"fields": [
						{
							"name": "FloorType",
							"jsonPath": "properties[0].propertyDetail.floorType",
							"label": "pt.create.groups.propertyAddress.fields.floorType",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"url":"",
							"patternErrMsg": "",
							"defaultValue":[]
						},
						{
							"name": "RoofType",
							"jsonPath": "properties[0].propertyDetail.roofType",
							"label": "pt.create.groups.propertyAddress.fields.roofType",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"url":"",
							"patternErrMsg": "",
							"defaultValue":[]
						},
						{
							"name": "WallType",
							"jsonPath": "properties[0].propertyDetail.wallType",
							"label": "pt.create.groups.propertyAddress.fields.wallType",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"url":"",
							"patternErrMsg": "",
							"defaultValue":[]
						},	
						{
							"name": "WoodType",
							"jsonPath": "properties[0].propertyDetail.woodType",
							"label": "pt.create.groups.propertyAddress.fields.woodType",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"url":"",
							"patternErrMsg": "",
							"defaultValue":[]
						},	
						
				]
			},
			{
				"label": "Vacant Land",
				"name": "VacantLand",
				"fields": [
						{
							"name": "SurveyNumber",
							"jsonPath": "properties[0].vacantLand.surveyNumber",
							"label": "pt.create.groups.propertyAddress.fields.surveyNumber",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},	
						{
							"name": "pattaNumber",
							"jsonPath": "properties[0].vacantLand.pattaNumber",
							"label": "pt.create.groups.propertyAddress.fields.pattaNumber",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},	
						{
							"name": "VacantLandArea",
							"jsonPath": "properties[0].vacantLand.vacantLandArea",
							"label": "pt.create.groups.propertyAddress.fields.vacantLandArea",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "MarketValue",
							"jsonPath": "properties[0].vacantLand.marketValue",
							"label": "pt.create.groups.propertyAddress.fields.marketValue",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "CapitalValue",
							"jsonPath": "properties[0].vacantLand.capitalValue",
							"label": "pt.create.groups.propertyAddress.fields.capitalValue",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "EffectiveDate",
							"jsonPath": "properties[0].vacantLand.effectiveDate",
							"label": "pt.create.groups.propertyAddress.fields.effectiveDate",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "VacantLandPlotArea",
							"jsonPath": "properties[0].vacantLand.vacantLandPlotArea",
							"label": "pt.create.groups.propertyAddress.fields.vacantLandPlotArea",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "LayoutApprovalAuthority",
							"jsonPath": "properties[0].vacantLand.layoutApprovedAuth",
							"label": "pt.create.groups.propertyAddress.fields.layoutApprovalAuthority",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "LayoutPermitNumber",
							"jsonPath": "properties[0].vacantLand.layoutPermissionNo",
							"label": "pt.create.groups.propertyAddress.fields.layoutPermitNumber",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "LayoutPermitDate",
							"jsonPath": "properties[0].vacantLand.layoutPermissionDate",
							"label": "pt.create.groups.propertyAddress.fields.layoutPermitDate",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
				]
			},
			{
				"label": "Floor Details",
				"name": "FloorDetails",
				"multiple":true,
				"children":[rooms],
				"fields": [
						{
							"name": "FloorNumber",
							"jsonPath": "properties[0].propertyDetail.floors[0].floorNo",
							"label": "pt.create.groups.propertyAddress.fields.floorNumber",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"url":"",
							"patternErrMsg": "",
							"defaultValue":[]
						},
						{
							"name": "UnitType",
							"jsonPath": "properties[0].propertyDetail.floors[0].units[0].unitType",
							"label": "pt.create.groups.propertyAddress.fields.unitType",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"url":"",
							"patternErrMsg": "",
							"defaultValue":[]
						},
						{
							"name": "UnitNumber",
							"jsonPath": "properties[0].propertyDetail.floors[0].units[0].unitNo",
							"label": "pt.create.groups.propertyAddress.fields.unitNumber",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "ConstructionType",
							"jsonPath": "properties[0].propertyDetail.floors[0].units[0].structure",
							"label": "pt.create.groups.propertyAddress.fields.constructionType",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"url":"",
							"patternErrMsg": "",
							"defaultValue":[]
						},
						{
							"name": "UsageType",
							"jsonPath": "properties[0].propertyDetail.floors[0].units[0].usage",
							"label": "pt.create.groups.propertyAddress.fields.usageType",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"url":"",
							"patternErrMsg": "",
							"defaultValue":[]
						},
						{
							"name": "UsageSubType",
							"jsonPath": "properties[0].propertyDetail.floors[0].units[0].usageSubType",
							"label": "pt.create.groups.propertyAddress.fields.usageSubType",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"url":"",
							"patternErrMsg": "",
							"defaultValue":[]
						},
						{
							"name": "FirmName",
							"jsonPath": "properties[0].propertyDetail.floors[0].units[0].firmName",
							"label": "pt.create.groups.propertyAddress.fields.firmName",
							"pattern": "",
							"type": "text",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "Occupancy",
							"jsonPath": "properties[0].propertyDetail.floors[0].units[0].occupancyType",
							"label": "pt.create.groups.propertyAddress.fields.occupancy",
							"pattern": "",
							"type": "singleValueList",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"url":"",
							"patternErrMsg": "",
							"defaultValue":[]
						},
						{
							"name": "OccupantName",
							"jsonPath": "properties[0].propertyDetail.floors[0].units[0].occupierName",
							"label": "pt.create.groups.propertyAddress.fields.occupantName",
							"pattern": "",
							"type": "text",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "AnnualRent",
							"jsonPath": "properties[0].propertyDetail.floors[0].units[0].annualRent",
							"label": "pt.create.groups.propertyAddress.fields.AnnualRent",
							"pattern": "",
							"type": "text",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "ManualArv",
							"jsonPath": "properties[0].propertyDetail.floors[0].units[0].manualArv",
							"label": "pt.create.groups.propertyAddress.fields.manualArv",
							"pattern": "",
							"type": "text",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "ConstructionDate",
							"jsonPath": "properties[0].propertyDetail.floors[0].units[0].constCompletionDate",
							"label": "pt.create.groups.propertyAddress.fields.constructionDate",
							"pattern": "",
							"type": "datePicker",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "EffectiveFromDate",
							"jsonPath": "properties[0].propertyDetail.floors[0].units[0].occupancyDate",
							"label": "pt.create.groups.propertyAddress.fields.effectiveFromDate",
							"pattern": "",
							"type": "datePicker",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
						},
						{
							"name": "UnstructuredLand",
							"jsonPath": "properties[0].propertyDetail.floors[0].units[0].isStructured",
							"label": "pt.create.groups.propertyAddress.fields.unstructuredLand",
							"pattern": "",
							"type": "singleValueList",
							"url":"",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": "",
							"defaultValue":[]
						},
						{
							"name": "Length",
							"jsonPath": "properties[0].propertyDetail.floors[0].units[0].length",
							"label": "pt.create.groups.propertyAddress.fields.length",
							"pattern": "",
							"type": "number",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "Breadth",
							"jsonPath": "properties[0].propertyDetail.floors[0].units[0].width",
							"label": "pt.create.groups.propertyAddress.fields.breadth",
							"pattern": "",
							"type": "number",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "PlinthArea",
							"jsonPath": "properties[0].propertyDetail.floors[0].units[0].builtupArea",
							"label": "pt.create.groups.propertyAddress.fields.plinthArea",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "OccupancyCertificateNumber",
							"jsonPath": "properties[0].propertyDetail.floors[0].units[0].occupancyCertiNumber",
							"label": "pt.create.groups.propertyAddress.fields.occupancyCertificateNumber",
							"pattern": "",
							"type": "number",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "BuildingPermissionNumber",
							"jsonPath": "properties[0].propertyDetail.floors[0].units[0].bpaNo",
							"label": "pt.create.groups.propertyAddress.fields.buildingPermissionNumber",
							"pattern": "",
							"type": "number",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "BuildingPermissionDate",
							"jsonPath": "properties[0].propertyDetail.floors[0].units[0].bpaDate",
							"label": "pt.create.groups.propertyAddress.fields.buildingPermissionDate",
							"pattern": "",
							"type": "datePicker",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "PlinthAreaInBuildingPlan",
							"jsonPath": "properties[0].propertyDetail.floors[0].units[0].bpaBuiltupArea",
							"label": "pt.create.groups.propertyAddress.fields.plinthAreaInBuildingPlan",
							"pattern": "",
							"type": "number",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
	
				]
			},
			{
				"label": "Documents",
				"name": "Documents",
				"fields": [
						{
						  "name": "File",
						  "jsonPath": "File",
						  "type": "documentList",
						  "pathToArray": "DocumentTypeApplicationTypes",
						  "displayNameJsonPath": "documentType",
						  "url": "",
						  "autoFillFields": [{
							"name": "document",
							"jsonPath": "documentTypeId"
						  }]
						}	
				]
			}
			
			
		]
	}
}

export default dat;