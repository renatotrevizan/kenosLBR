/******************************************************************************
 * Copyright (C) 2011 Kenos Assessoria e Consultoria de Sistemas Ltda         *
 * Copyright (C) 2011 Ricardo Santana                                         *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 *****************************************************************************/
package org.kenos.idempiere.lbr.hr.model;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * 
 * Intervalo de Trabalho
 * 
 * @author Rogério Alves Feitosa (Kenos, www.kenos.com.br)
 * @version $Id: MLBRHRWorkInterval.java, v1.0 2021/01/03 12:13:22, rfeitosa Exp $
 *
 */
public class MLBRHRWorkInterval extends X_LBR_HRWorkInterval
{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -6517627867259820593L;

	/**
	 * Default Constructor
	 * @param ctx
	 * @param LBR_TaxStatus_ID
	 * @param trxName
	 */
	public MLBRHRWorkInterval(Properties ctx, int LBR_TaxStatus_ID, String trxName)
	{
		super(ctx, LBR_TaxStatus_ID, trxName);
	}	//MLBRHRWorkInterval
	
	/**
	 * Load Constructor
	 * @param ctx
	 * @param rs
	 * @param trxName
	 */
	public MLBRHRWorkInterval(Properties ctx, ResultSet rs, String trxName)
	{
		super(ctx, rs, trxName);
	}	//MLBRHRWorkInterval

}	//	MLBRHRWorkInterval