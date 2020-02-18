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
package org.kenos.idempiere.lbr.sped.efd.model;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.adempiere.model.POWrapper;
import org.adempierelbr.model.X_LBR_SPED;
import org.adempierelbr.util.TextUtil;
import org.adempierelbr.wrapper.I_W_AD_OrgInfo;
import org.adempierelbr.wrapper.I_W_C_BPartner;
import org.adempierelbr.wrapper.I_W_C_City;
import org.compiere.model.MCity;
import org.compiere.model.MOrgInfo;

/**
 * 		Model for LBR_SPED
 * 
 * 	@author Ricardo Santana
 */
public class MLBRSPED extends X_LBR_SPED
{
	/**
	 * 	Serial
	 */
	private static final long serialVersionUID = 1L;
	
	I_W_AD_OrgInfo oi;
	
	/**
	 *  Default Constructor
	 *  @param Properties ctx
	 *  @param int ID (0 create new)
	 *  @param String trx
	 */
	public MLBRSPED (Properties ctx, int LBR_SPED_ID, String trxName)
	{
		super (ctx, LBR_SPED_ID, trxName);
		init (ctx, trxName);
	}	//	MLBRSPED
	
	/**
	 *  Load Constructor
	 *  @param ctx context
	 *  @param rs result set record
	 *  @param trxName transaction
	 */
	public MLBRSPED (Properties ctx, ResultSet rs, String trxName)
	{
		super (ctx, rs, trxName);
		//
		init (ctx, trxName);
	}	//	MLBRSPED

	/**
	 * 	Initialize
	 * 	@param ctx
	 * 	@param trxName
	 */
	private void init (Properties ctx, String trxName)
	{
		oi = POWrapper.create (MOrgInfo.get(ctx, getAD_Org_ID(), trxName), I_W_AD_OrgInfo.class);
	}	//	init

	/**
	 * 	Get date from
	 * 	@return
	 */
	public Timestamp getDateFrom()
	{
		return getC_Period().getStartDate();
	}	//	getDateFrom
	
	/**
	 * 	Get date to
	 * 	@return
	 */
	public Timestamp getDateTo()
	{
		return getC_Period().getEndDate();
	}	//	getDateTo

	/**
	 * 	Get the Legal Entity name
	 * 	@return
	 */
	public String getlbr_LegalEntity()
	{
		return oi.getlbr_LegalEntity();
	}	//	getlbr_LegalEntity
	
	/**
	 * 	Get the CNPJ and converts it to Long
	 * 	@return
	 */
	public Long getCNPJ ()
	{
		try
		{
			return Long.valueOf (TextUtil.toNumeric(oi.getlbr_CNPJ()));
		}
		catch (Exception e) {}
		return null;
	}	//	getCNPJ

	public String getIE ()
	{
		return TextUtil.retiraEspecial (oi.getlbr_IE());
	}	//	getIE

	public String getIM()
	{
		return TextUtil.retiraEspecial (oi.getlbr_CCM());
	}	//	getIM

	public String getSUFRAMA()
	{
		return TextUtil.retiraEspecial (oi.getlbr_Suframa());
	}	//	getSUFRAMA

	public String getProfile()
	{
		return oi.getlbr_IndPerfil();
	}

	public Integer getActivity()
	{
		try
		{
			return Integer.valueOf (oi.getlbr_IndAtividade());
		}
		catch (Exception e) {}
		return null;
	}

	/**
	 * 	Get the UF (Region)
	 * 	@return
	 */
	public String getUF()
	{
		return oi.getC_Location().getC_Region().getName();
	}	//	getUF

	public Integer getCityCode()
	{
		if (oi.getC_Location().getC_City_ID() < 1)
			return null;
		I_W_C_City city = POWrapper.create (new MCity (getCtx(), oi.getC_Location().getC_City_ID(), get_TrxName()), I_W_C_City.class);
		return city.getlbr_CityCode();
	}	//	getCityCode

	public String getFantasia() 
	{
		return oi.getlbr_Fantasia();
	}

	public Integer getPostal() 
	{
		try
		{
			return Integer.valueOf (oi.getC_Location().getPostal());
		}
		catch (Exception e) {}
		return null;
	}

	public String getAddress1() 
	{
		return oi.getC_Location().getAddress1();
	}

	public String getAddress2() 
	{
		return oi.getC_Location().getAddress2();
	}

	public String getAddress3() 
	{
		return oi.getC_Location().getAddress3();
	}

	public String getAddress4() 
	{
		return oi.getC_Location().getAddress4();
	}

	public String getPhone() 
	{
		return oi.getPhone();
	}

	public String getEMail() 
	{
		return oi.getEMail();
	}

	public I_W_C_BPartner getBPAccountant()
	{
		return null;
	}
}	//	MLBRSPED
