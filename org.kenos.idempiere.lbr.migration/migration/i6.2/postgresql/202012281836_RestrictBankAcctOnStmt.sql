-- 28 de dez de 2020 19:35:17 BRT
UPDATE AD_Column SET AD_Val_Rule_ID=1120118,Updated=TO_TIMESTAMP('2020-12-28 19:35:17','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=4917
;

-- 28 de dez de 2020 19:35:17 BRT
SELECT Register_Migration_Script ('202012281836_RestrictBankAcctOnStmt.sql') FROM DUAL
;