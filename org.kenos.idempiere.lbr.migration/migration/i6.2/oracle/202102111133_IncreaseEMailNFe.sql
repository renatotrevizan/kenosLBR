SET SQLBLANKLINES ON
SET DEFINE OFF

-- Feb 11, 2021, 11:31:40 AM BRT
UPDATE AD_Column SET FieldLength=250,Updated=TO_DATE('2021-02-11 11:31:40','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=1130428
;

-- Feb 11, 2021, 11:31:42 AM BRT
ALTER TABLE C_BPartner MODIFY LBR_EMailBilling VARCHAR2(250) DEFAULT NULL 
;

-- Feb 11, 2021, 11:31:49 AM BRT
UPDATE AD_Column SET FieldLength=250,Updated=TO_DATE('2021-02-11 11:31:49','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=1130427
;

-- Feb 11, 2021, 11:31:51 AM BRT
ALTER TABLE C_BPartner MODIFY LBR_EMailNFSe VARCHAR2(250) DEFAULT NULL 
;

-- Feb 11, 2021, 11:31:57 AM BRT
UPDATE AD_Column SET FieldLength=250,Updated=TO_DATE('2021-02-11 11:31:57','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=1126599
;

-- Feb 11, 2021, 11:31:59 AM BRT
ALTER TABLE C_BPartner MODIFY LBR_EMailNFe VARCHAR2(250) DEFAULT NULL 
;

-- Feb 11, 2021, 11:31:59 AM BRT
SELECT Register_Migration_Script ('202102111133_IncreaseEMailNFe.sql') FROM DUAL
;
