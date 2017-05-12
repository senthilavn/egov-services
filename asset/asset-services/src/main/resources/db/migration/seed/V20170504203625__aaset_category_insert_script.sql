
INSERT INTO egasset_assetcategory (id, name, code, parentid, assetcategorytype, depreciationmethod, depreciationrate, assetaccount, accumulateddepreciationaccount, revaluationreserveaccount, depreciationexpenseaccount, unitofmeasurement, customfields, tenantid, createdby, createddate, lastmodifiedby, lastmodifieddate, isassetallow, version) VALUES (nextval('seq_egasset_assetcategory'), 'Land', '006', NULL, 'LAND', 'STRAIGHT_LINE_METHOD', NULL, NULL, NULL, NULL, NULL, NULL, '{"assetFieldsDefination":[{"name":"Land Register Number","type":"Text","isActive":true,"isMandatory":true,"columns":[]},{"name":"Old Land Register Number","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"Re-survey Number","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"Old Survey Number","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"Sub division Number","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"OSR Land","type":"Select","isActive":true,"isMandatory":true,"values":"Yes,No","columns":[]},{"name":"Is it Fenced","type":"Select","isActive":true,"isMandatory":true,"values":"Yes,No","columns":[]},{"name":"Land Type","type":"Select","isActive":true,"isMandatory":true,"values":"Hold,Free Hold","columns":[]},{"name":"Area of the Land","type":"Number","isActive":true,"isMandatory":false,"columns":[]},{"name":"Unit of Measurement","type":"Select","isActive":true,"isMandatory":true,"values":"sq. ft.,sq. mt.","columns":[]},{"name":"Compensation Paid","type":"Number","isActive":true,"isMandatory":false,"columns":[]},{"name":"Date of Deed Execution","type":"Date","isActive":true,"isMandatory":false,"columns":[]},{"name":"Date of Possession","type":"Date","isActive":true,"isMandatory":false,"columns":[]},{"name":"Index No.","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"Department Reference No.","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"From Whom the Deed Taken","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"Land usage","type":"Select","isActive":true,"isMandatory":false,"values":"Open Space,Burial ground,Vacant Land,Vested lands,Alienation","columns":[]},{"name":"Special Conditions attached to the Holding","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"Attach Document","type":"File","isActive":true,"isMandatory":false,"columns":[]},{"name":"Government order number","type":"Text","isActive":true,"isMandatory":true,"columns":[]},{"name":"Collector Order Number","type":"Text","isActive":true,"isMandatory":true,"columns":[]},{"name":"Council Resolution Number","type":"Text","isActive":true,"isMandatory":true,"columns":[]},{"name":"Award Number","type":"Text","isActive":true,"isMandatory":true,"columns":[]}]}', 'ap.kurnool', '1', '2017-05-04 06:31:02.58', '1', '2017-05-04 06:31:02.58', NULL, '1.0');


INSERT INTO egasset_assetcategory (id, name, code, parentid, assetcategorytype, depreciationmethod, depreciationrate, assetaccount, accumulateddepreciationaccount, revaluationreserveaccount, depreciationexpenseaccount, unitofmeasurement, customfields, tenantid, createdby, createddate, lastmodifiedby, lastmodifieddate, isassetallow, version) VALUES (nextval('seq_egasset_assetcategory'), 'Market', '007', NULL, 'IMMOVABLE', 'STRAIGHT_LINE_METHOD', NULL, NULL, NULL, NULL, NULL, NULL, '{"assetFieldsDefination":[{"name":"Market Name","type":"Text","isActive":true,"isMandatory":true,"columns":[]},{"name":"East","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"South","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"West","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"North","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"Stall Details","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"Total Square feet area","type":"Number","isActive":true,"isMandatory":false,"columns":[]}]}', 'ap.kurnool', '1', '2017-05-04 07:06:59.603', '1', '2017-05-04 07:06:59.603', NULL, '1.0');


INSERT INTO egasset_assetcategory (id, name, code, parentid, assetcategorytype, depreciationmethod, depreciationrate, assetaccount, accumulateddepreciationaccount, revaluationreserveaccount, depreciationexpenseaccount, unitofmeasurement, customfields, tenantid, createdby, createddate, lastmodifiedby, lastmodifieddate, isassetallow, version) VALUES (nextval('seq_egasset_assetcategory'), 'Kalyana Mandapam', '008', NULL, 'IMMOVABLE', 'STRAIGHT_LINE_METHOD', NULL, NULL, NULL, NULL, NULL, NULL, '{"assetFieldsDefination":[{"name":"Kalyana Mandapam Name","type":"Text","isActive":true,"isMandatory":true,"columns":[]},{"name":"Total Square Feet Area","type":"Number","isActive":true,"isMandatory":false,"columns":[]},{"name":"Total Built up area","type":"Number","isActive":true,"isMandatory":false,"columns":[]},{"name":"Amenities","type":"Table","isActive":false,"isMandatory":false,"columns":[{"name":"Type","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"Total count","type":"Number","isActive":true,"isMandatory":false,"columns":[]}]}]}', 'ap.kurnool', '1', '2017-05-04 07:12:35.6', '1', '2017-05-04 07:12:35.6', NULL, '1.0');


INSERT INTO egasset_assetcategory (id, name, code, parentid, assetcategorytype, depreciationmethod, depreciationrate, assetaccount, accumulateddepreciationaccount, revaluationreserveaccount, depreciationexpenseaccount, unitofmeasurement, customfields, tenantid, createdby, createddate, lastmodifiedby, lastmodifieddate, isassetallow, version) VALUES (nextval('seq_egasset_assetcategory'), 'Parking Space', '010', NULL, 'IMMOVABLE', 'STRAIGHT_LINE_METHOD', NULL, NULL, NULL, NULL, NULL, NULL, '{"assetFieldsDefination":[{"name":"Parking space Name","type":"Text","isActive":true,"isMandatory":true,"columns":[]},{"name":"East","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"South","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"West","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"North","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"Remarks","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"Total Square feet area","type":"Number","isActive":true,"isMandatory":false,"columns":[]}]}', 'ap.kurnool', '1', '2017-05-04 07:23:13.854', '1', '2017-05-04 07:23:13.854', NULL, '1.0');


INSERT INTO egasset_assetcategory (id, name, code, parentid, assetcategorytype, depreciationmethod, depreciationrate, assetaccount, accumulateddepreciationaccount, revaluationreserveaccount, depreciationexpenseaccount, unitofmeasurement, customfields, tenantid, createdby, createddate, lastmodifiedby, lastmodifieddate, isassetallow, version) VALUES (nextval('seq_egasset_assetcategory'), 'Slaughter House', '011', NULL, 'IMMOVABLE', 'STRAIGHT_LINE_METHOD', NULL, NULL, NULL, NULL, NULL, NULL, '{"assetFieldsDefination":[{"name":"Slaughter House Name","type":"Text","isActive":true,"isMandatory":true,"columns":[]},{"name":"East","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"South","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"West","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"North","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"Remarks","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"Total Square feet area","type":"Number","isActive":true,"isMandatory":false,"columns":[]}]}', 'ap.kurnool', '1', '2017-05-04 07:27:09.023', '1', '2017-05-04 07:27:09.023', NULL, '1.0');


INSERT INTO egasset_assetcategory (id, name, code, parentid, assetcategorytype, depreciationmethod, depreciationrate, assetaccount, accumulateddepreciationaccount, revaluationreserveaccount, depreciationexpenseaccount, unitofmeasurement, customfields, tenantid, createdby, createddate, lastmodifiedby, lastmodifieddate, isassetallow, version) VALUES (nextval('seq_egasset_assetcategory'), 'Usufruct', '012', NULL, 'IMMOVABLE', 'STRAIGHT_LINE_METHOD', NULL, NULL, NULL, NULL, NULL, NULL, '{"assetFieldsDefination":[{"name":"Usufruct Name","type":"Text","isActive":true,"isMandatory":true,"columns":[]},{"name":"East","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"South","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"West","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"North","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"Remarks","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"Total Square feet area","type":"Number","isActive":true,"isMandatory":false,"columns":[]}]}', 'ap.kurnool', '1', '2017-05-04 07:33:28.935', '1', '2017-05-04 07:33:28.935', NULL, '1.0');


INSERT INTO egasset_assetcategory (id, name, code, parentid, assetcategorytype, depreciationmethod, depreciationrate, assetaccount, accumulateddepreciationaccount, revaluationreserveaccount, depreciationexpenseaccount, unitofmeasurement, customfields, tenantid, createdby, createddate, lastmodifiedby, lastmodifieddate, isassetallow, version) VALUES (nextval('seq_egasset_assetcategory'), 'Fish Tanks', '013', NULL, 'IMMOVABLE', 'STRAIGHT_LINE_METHOD', NULL, NULL, NULL, NULL, NULL, NULL, '{"assetFieldsDefination":[{"name":"Fish Tank Name","type":"Text","isActive":true,"isMandatory":true,"columns":[]},{"name":"East","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"South","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"West","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"North","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"Remarks","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"Total Square feet area","type":"Number","isActive":true,"isMandatory":false,"columns":[]}]}', 'ap.kurnool', '1', '2017-05-04 07:40:21.545', '1', '2017-05-04 07:40:21.545', NULL, '1.0');


INSERT INTO egasset_assetcategory (id, name, code, parentid, assetcategorytype, depreciationmethod, depreciationrate, assetaccount, accumulateddepreciationaccount, revaluationreserveaccount, depreciationexpenseaccount, unitofmeasurement, customfields, tenantid, createdby, createddate, lastmodifiedby, lastmodifieddate, isassetallow, version) VALUES (nextval('seq_egasset_assetcategory'), 'Parks', '014', NULL, 'IMMOVABLE', 'STRAIGHT_LINE_METHOD', NULL, NULL, NULL, NULL, NULL, NULL, '{"assetFieldsDefination":[{"name":"Park Name","type":"Text","isActive":true,"isMandatory":true,"columns":[]},{"name":"East","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"South","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"West","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"North","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"Remarks","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"Total Square feet area","type":"Number","isActive":true,"isMandatory":false,"columns":[]}]}', 'ap.kurnool', '1', '2017-05-04 07:44:51.365', '1', '2017-05-04 07:44:51.365', NULL, '1.0');


INSERT INTO egasset_assetcategory (id, name, code, parentid, assetcategorytype, depreciationmethod, depreciationrate, assetaccount, accumulateddepreciationaccount, revaluationreserveaccount, depreciationexpenseaccount, unitofmeasurement, customfields, tenantid, createdby, createddate, lastmodifiedby, lastmodifieddate, isassetallow, version) VALUES (nextval('seq_egasset_assetcategory'), 'Shopping Complex', '015', NULL, 'IMMOVABLE', 'STRAIGHT_LINE_METHOD', NULL, NULL, NULL, NULL, NULL, NULL, '{"assetFieldsDefination":[{"name":"Shopping Complex Name","type":"Text","isActive":true,"isMandatory":true,"columns":[]},{"name":"Door No.","type":"Text","isActive":true,"isMandatory":false,"columns":[]},{"name":"Shopping Complex No.","type":"Text","isActive":true,"isMandatory":true,"columns":[]},{"name":"No. of Floors","type":"Number","isActive":true,"isMandatory":true,"columns":[]},{"name":"Total No. of Shops","type":"Number","isActive":true,"isMandatory":true,"columns":[]},{"name":"Floor Details","type":"Table","isActive":false,"isMandatory":false,"columns":[{"name":"Floor No.","type":"Text","isActive":true,"isMandatory":true,"columns":[]},{"name":"No. of Shops","type":"Text","isActive":true,"isMandatory":true,"columns":[]}]}]}', 'ap.kurnool', '1', '2017-05-04 11:47:21.451', '1', '2017-05-04 11:47:21.451', NULL, '1.0');

ALTER SEQUENCE seq_egasset_categorycode RESTART WITH 16;



