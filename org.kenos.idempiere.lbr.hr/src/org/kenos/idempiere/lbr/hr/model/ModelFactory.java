package org.kenos.idempiere.lbr.hr.model;

import java.sql.ResultSet;

import org.adempiere.base.IModelFactory;
import org.compiere.model.PO;
import org.compiere.util.Env;

/**
 * 		Model Factory
 * 
 * 	@author Rogério Feitosa (Kenos, www.kenos.com.br)
 *	@version $Id: ModelFactory.java, v1.0 2021/02/03 22:53:49 PM, rfeitosa Exp $
 */
public class ModelFactory implements IModelFactory
{
	@Override
	public Class<?> getClass(String tableName)
	{
		if (MLBRHRSyndicate.Table_Name.equals(tableName))
			return MLBRHRSyndicate.class;
		else if (MLBRHRWorkInterval.Table_Name.equals(tableName))
			return MLBRHRWorkInterval.class;
		else if (MLBRHRWorkPeriod.Table_Name.equals(tableName))
			return MLBRHRWorkPeriod.class;
		else if (MLBRHRWorkPeriodLine.Table_Name.equals(tableName))
			return MLBRHRWorkPeriodLine.class;
		else if (MLBRHRWorkSchedule.Table_Name.equals(tableName))
			return MLBRHRWorkSchedule.class;
		return null;
	}	//	getClass

	@Override
	public PO getPO(String tableName, int Record_ID, String trxName)
	{
		if (MLBRHRSyndicate.Table_Name.equals(tableName))
			return new MLBRHRSyndicate (Env.getCtx(), Record_ID, trxName);
		else if (MLBRHRWorkInterval.Table_Name.equals(tableName))
			return new MLBRHRWorkInterval (Env.getCtx(), Record_ID, trxName);
		else if (MLBRHRWorkPeriod.Table_Name.equals(tableName))
			return new MLBRHRWorkPeriod (Env.getCtx(), Record_ID, trxName);
		else if (MLBRHRWorkPeriodLine.Table_Name.equals(tableName))
			return new MLBRHRWorkPeriodLine (Env.getCtx(), Record_ID, trxName);
		else if (MLBRHRWorkSchedule.Table_Name.equals(tableName))
			return new MLBRHRWorkSchedule (Env.getCtx(), Record_ID, trxName);
		return null;
	}	//	getPO

	@Override
	public PO getPO(String tableName, ResultSet rs, String trxName)
	{
		if (MLBRHRSyndicate.Table_Name.equals(tableName))
			return new MLBRHRSyndicate (Env.getCtx(), rs, trxName);
		else if (MLBRHRWorkInterval.Table_Name.equals(tableName))
			return new MLBRHRWorkInterval (Env.getCtx(), rs, trxName);
		else if (MLBRHRWorkPeriod.Table_Name.equals(tableName))
			return new MLBRHRWorkPeriod (Env.getCtx(), rs, trxName);
		else if (MLBRHRWorkPeriodLine.Table_Name.equals(tableName))
			return new MLBRHRWorkPeriodLine (Env.getCtx(), rs, trxName);
		else if (MLBRHRWorkSchedule.Table_Name.equals(tableName))
			return new MLBRHRWorkSchedule (Env.getCtx(), rs, trxName);
		return null;
	}	//	getPO
}	//	ModelFactory
