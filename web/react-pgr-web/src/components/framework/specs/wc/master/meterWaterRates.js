var dat = {
	"wc.create": {
		"numCols": 12/3,
		"url": "/wcms/masters/meterwaterrates/_create",
		"tenantIdRequired": true,
		"idJsonPath": "MeterWaterRates[0].code",
		"useTimestamp": true,
		"objectName": "MeterWaterRates",
		"groups": [
			{
				"label": "wc.create.meterWaterRates.title",
				"name": "meterWaterRateCreate",
				"fields": [
					{
						"name": "UsageType",
						"jsonPath": "MeterWaterRates[0].usageTypeCode",
						"label": "wc.create.groups.connectionDetails.usageType",
						"pattern": "",
						"type": "singleValueList",
						"url": "/wcms/masters/usagetypes/_search?&active=true|$..code|$..name",
						"isRequired": true,
						"isDisabled": false,
						"requiredErrMsg": "",
						"patternErrMsg": "",
						"depedants": [{
								"jsonPath": "MeterWaterRates[0].subUsageTypeCode",
								"type": "dropDown",
								"pattern": "/wcms/masters/usagetypes/_search?&isSubUsageType=true&parent={MeterWaterRates[0].usageTypeCode}|$..code|$..name"
							}]
					},
					{
						"name": "SubUsageType",
						"jsonPath": "MeterWaterRates[0].subUsageTypeCode",
						"label": "wc.create.groups.connectionDetails.subUsageType",
						"pattern": "",
						"type": "singleValueList",
						"isRequired": true,
						"isDisabled": false,
						"requiredErrMsg": "",
						"patternErrMsg": ""
					},
            {
							"name": "sourceTypeName",
							"jsonPath": "MeterWaterRates[0].sourceTypeName",
							"label": "wc.create.groups.fields.sourceTypeName",
							"pattern": "",
							"type": "singleValueList",
							"url": "/wcms/masters/sourcetype/_search?&active=true|$..name|$..name",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
            {
  						"name": "pipeSize",
  						"jsonPath": "MeterWaterRates[0].pipeSize",
  						"label": "wc.create.pipeSize",
  						"pattern": "",
  						"type": "singleValueList",
  						"url": "/wcms/masters/pipesize/_search?&active=true|$..sizeInMilimeter|$..sizeInInch",
  						"isRequired": true,
  						"isDisabled": false,
  						"requiredErrMsg": "",
  						"patternErrMsg": ""
  					},
            {
              "name": "fromDate",
              "jsonPath": "MeterWaterRates[0].fromDate",
              "label": "wc.create.fromDate",
              "pattern": "",
              "type": "datePicker",
              "isRequired": true,
              "isDisabled": false,
              "requiredErrMsg": "",
              "patternErrMsg": ""
            },
  					{
              "name": "toDate",
              "jsonPath": "MeterWaterRates[0].toDate",
              "label": "wc.create.toDate",
              "pattern": "",
              "type": "datePicker",
              "isRequired": true,
              "isDisabled": false,
              "requiredErrMsg": "",
              "patternErrMsg": ""
            },
            {
  						"name": "Active",
  						"jsonPath": "MeterWaterRates[0].active",
  						"label": "wc.create.active",
  						"pattern": "",
  						"type": "checkbox",
  						"isRequired": false,
  						"isDisabled": false,
  						"defaultValue":true,
  						"requiredErrMsg": "",
  						"patternErrMsg": ""
  					}
				]
			},
      {
				"label": "wc.crete.Slabs",
				"name": "Slabs",
				"multiple":true,
        "jsonPath":"MeterWaterRates[0].slab",
				"fields": [
						{
							"name": "FromUnit",
							"jsonPath": "MeterWaterRates[0].slab[0].fromUnit",
							"label": "wc.create.groups.Slabs.fields.fromUnit",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "ToUnit",
							"jsonPath": "MeterWaterRates[0].slab[0].toUnit",
							"label": "wc.create.groups.Slabs.fields.toUnit",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "UnitRate",
							"jsonPath": "MeterWaterRates[0].slab[0].unitRate",
							"label": "wc.create.groups.Slabs.fields.unitRate",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						}
				]
			}
		]
	},
	"wc.search": {
		"numCols": 12/3,
		"url": "/wcms/masters/meterwaterrates/_search",
		"tenantIdRequired": true,

		"useTimestamp": true,
		"objectName": "meterwaterrates",
		"groups": [
			{
				"label": "wc.search.meterWaterRates.title",
				"name": "searchStorageReservoir",
				"fields": [
						{
							"name": "usageTypeCode",
							"jsonPath": "MeterWaterRates[0].usageTypeCode",
							"label": "wc.create.groups.fields.usageTypeCode",
							"pattern": "",
							"type": "singleValueList",
							"url": "/wcms/masters/usagetypes/_search?&active=true|$..code|$..name",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
            {
							"name": "sourceTypeName",
							"jsonPath": "MeterWaterRates[0].sourceTypeName",
							"label": "wc.create.groups.fields.sourceTypeName",
							"pattern": "",
							"type": "singleValueList",
							"url": "/wcms/masters/sourcetypes/_search?&active=true|$..name|$..name",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
            {
  						"name": "pipeSize",
  						"jsonPath": "pipeSize",
  						"label": "wc.create.pipeSize",
  						"pattern": "",
  						"type": "singleValueList",
  						"url": "/wcms/masters/pipesizes/_search?&active=true|$..sizeInMilimeter|$..sizeInInch",
  						"isRequired": false,
  						"isDisabled": false,
  						"requiredErrMsg": "",
  						"patternErrMsg": ""
  					},
            {
							"name": "Active",
							"jsonPath": "active",
							"label": "wc.create.active",
							"pattern": "",
							"type": "checkbox",
							"isRequired": false,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						}
				]
			}
		],
		"result": {
			"header": [{label: "wc.create.groups.fields.usageTypeName"},{label: "wc.create.groups.fields.subUsageTypeName"},{label: "wc.create.groups.fields.sourceTypeName"}, {label: "wc.create.pipeSize"}],
			"values": ["usageTypeCode","subUsageTypeCode" ,"sourceTypeName","pipeSize"],
			"resultPath": "MeterWaterRates",
			"rowClickUrlUpdate": "/update/wc/meterWaterRates/{id}",
			"rowClickUrlView": "/view/wc/meterWaterRates/{id}"
			}
	},
	"wc.view": {
		"numCols": 12/3,
		"url": "/wcms/masters/meterwaterrates/_search?ids={id}",
		"tenantIdRequired": true,
		"useTimestamp": true,
		"objectName": "MeterWaterRates",
		"groups": [
			{
				"label": "wc.view.meterWaterRates.title",
				"name": "meterWaterRateCreate",
				"fields": [
					{
						"name": "UsageType",
						"jsonPath": "MeterWaterRates[0].usageTypeCode",
						"label": "wc.create.groups.connectionDetails.usageType",
						"pattern": "",
						"type": "singleValueList",
						"url": "/wcms/masters/usagetypes/_search?&active=true|$..code|$..name",
						"isRequired": true,
						"isDisabled": false,
						"requiredErrMsg": "",
						"patternErrMsg": "",
						"depedants": [{
								"jsonPath": "MeterWaterRates[0].subUsageTypeCode",
								"type": "dropDown",
								"pattern": "/wcms/masters/usagetypes/_search?&isSubUsageType=true&parent={MeterWaterRates[0].usageTypeCode}|$..code|$..name"
							}]
					},
					{
						"name": "SubUsageType",
						"jsonPath": "MeterWaterRates[0].subUsageTypeCode",
						"label": "wc.create.groups.connectionDetails.subUsageType",
						"pattern": "",
						"type": "singleValueList",
						"isRequired": true,
						"isDisabled": false,
						"requiredErrMsg": "",
						"patternErrMsg": ""
					},
            {
							"name": "sourceTypeName",
							"jsonPath": "MeterWaterRates[0].sourceTypeName",
							"label": "wc.create.groups.fields.sourceTypeName",
							"pattern": "",
							"type": "singleValueList",
							"url": "/wcms/masters/sourcetypes/_search?&active=true|$..id|$..name",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
            {
  						"name": "pipeSize",
  						"jsonPath": "MeterWaterRates[0].pipeSize",
  						"label": "wc.create.pipeSize",
  						"pattern": "",
  						"type": "singleValueList",
  						"url": "/wcms/masters/pipesizes/_search?&active=true|$..sizeInMilimeter|$..sizeInInch",
  						"isRequired": true,
  						"isDisabled": false,
  						"requiredErrMsg": "",
  						"patternErrMsg": ""
  					},
            {
              "name": "fromDate",
              "jsonPath": "MeterWaterRates[0].fromDate",
              "label": "wc.create.fromDate",
              "pattern": "",
              "type": "datePicker",
              "isRequired": true,
              "isDisabled": false,
              "requiredErrMsg": "",
              "patternErrMsg": ""
            },
  					{
              "name": "toDate",
              "jsonPath": "MeterWaterRates[0].toDate",
              "label": "wc.create.toDate",
              "pattern": "",
              "type": "datePicker",
              "isRequired": true,
              "isDisabled": false,
              "requiredErrMsg": "",
              "patternErrMsg": ""
            }
				]
			},
      {
				"label": "wc.crete.Slabs",
				"name": "Slabs",
				"multiple":true,
        "jsonPath":"MeterWaterRates[0].slab",
				"fields": [
						{
							"name": "FromUnit",
							"jsonPath": "slab[0].fromUnit",
							"label": "wc.create.groups.Slabs.fields.fromUnit",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "ToUnit",
							"jsonPath": "slab.toUnit",
							"label": "wc.create.groups.Slabs.fields.toUnit",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "UnitRate",
							"jsonPath": "slab[0].unitRate",
							"label": "wc.create.groups.Slabs.fields.unitRate",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						}
				]
			}
		]
	},
	"wc.update" : {
		"numCols": 12/3,
    "searchUrl": "/wcms/masters/meterwaterrates/_search?ids={id}",
		"url":"/wcms/masters/meterwaterrates/_update",
		"tenantIdRequired": true,
		"useTimestamp": true,
		"objectName": "MeterWaterRates",
		"groups": [
			{
				"label": "wc.create.meterWaterRates.title",
				"name": "meterWaterRateCreate",
				"fields": [
					{
						"name": "UsageType",
						"jsonPath": "MeterWaterRates[0].usageTypeCode",
						"label": "wc.create.groups.connectionDetails.usageType",
						"pattern": "",
						"type": "singleValueList",
						"url": "/wcms/masters/usagetypes/_search?&active=true|$..code|$..name",
						"isRequired": true,
						"isDisabled": false,
						"requiredErrMsg": "",
						"patternErrMsg": "",
						"depedants": [{
								"jsonPath": "MeterWaterRates[0].subUsageTypeCode",
								"type": "dropDown",
								"pattern": "/wcms/masters/usagetypes/_search?&isSubUsageType=true&parent={MeterWaterRates[0].subUsageTypeCode}|$..code|$..name"
							}]
					},
					{
						"name": "SubUsageType",
						"jsonPath": "MeterWaterRates[0].subUsageTypeCode",
						"label": "wc.create.groups.connectionDetails.subUsageType",
						"pattern": "",
						"type": "singleValueList",
						"isRequired": true,
						"isDisabled": false,
						"requiredErrMsg": "",
						"patternErrMsg": ""
					},
            {
							"name": "sourceTypeName",
							"jsonPath": "MeterWaterRates[0].sourceTypeName",
							"label": "wc.create.groups.fields.sourceTypeName",
							"pattern": "",
							"type": "singleValueList",
							"url": "/wcms/masters/sourcetypes/_search?&active=true|$..name|$..name",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
            {
  						"name": "pipeSize",
  						"jsonPath": "MeterWaterRates[0].pipeSize",
  						"label": "wc.create.pipeSize",
  						"pattern": "",
  						"type": "singleValueList",
  						"url": "/wcms/masters/pipesizes/_search?&active=true|$..sizeInMilimeter|$..sizeInInch",
  						"isRequired": true,
  						"isDisabled": false,
  						"requiredErrMsg": "",
  						"patternErrMsg": ""
  					},
            {
              "name": "fromDate",
              "jsonPath": "MeterWaterRates[0].fromDate",
              "label": "wc.create.fromDate",
              "pattern": "",
              "type": "datePicker",
              "isRequired": true,
              "isDisabled": false,
              "requiredErrMsg": "",
              "patternErrMsg": ""
            },
  					{
              "name": "toDate",
              "jsonPath": "MeterWaterRates[0].toDate",
              "label": "wc.create.toDate",
              "pattern": "",
              "type": "datePicker",
              "isRequired": true,
              "isDisabled": false,
              "requiredErrMsg": "",
              "patternErrMsg": ""
            }
				]
			},
      {
				"label": "wc.crete.Slabs",
				"name": "Slabs",
				"multiple":true,
        "jsonPath":"MeterWaterRates[0].slab",
				"fields": [
						{
							"name": "FromUnit",
							"jsonPath": "slab[0].fromUnit",
							"label": "wc.create.groups.Slabs.fields.fromUnit",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "ToUnit",
							"jsonPath": "slab[0].toUnit",
							"label": "wc.create.groups.Slabs.fields.toUnit",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"requiredErrMsg": "",
							"patternErrMsg": ""
						},
						{
							"name": "UnitRate",
							"jsonPath": "slab[0].unitRate",
							"label": "wc.create.groups.Slabs.fields.unitRate",
							"pattern": "",
							"type": "number",
							"isRequired": true,
							"isDisabled": false,
							"url": "",
							"requiredErrMsg": "",
							"patternErrMsg": ""
						}
				]
			}
		]
	}
}

export default dat;
