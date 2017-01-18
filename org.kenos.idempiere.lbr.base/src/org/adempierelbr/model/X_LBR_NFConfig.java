/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package org.adempierelbr.model;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for LBR_NFConfig
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_LBR_NFConfig extends PO implements I_LBR_NFConfig, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20170116L;

    /** Standard Constructor */
    public X_LBR_NFConfig (Properties ctx, int LBR_NFConfig_ID, String trxName)
    {
      super (ctx, LBR_NFConfig_ID, trxName);
      /** if (LBR_NFConfig_ID == 0)
        {
			setLBR_NFConfig_ID (0);
			setLBR_ReverseInOut (false);
// N
			setLBR_ReverseInvoice (false);
// N
			setLBR_TPEmis (null);
// 1
			setlbr_DANFEFormat (null);
// 1
			setlbr_NFeEnv (null);
// 2
        } */
    }

    /** Load Constructor */
    public X_LBR_NFConfig (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuffer sb = new StringBuffer ("X_LBR_NFConfig[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set NF Configuration.
		@param LBR_NFConfig_ID NF Configuration	  */
	public void setLBR_NFConfig_ID (int LBR_NFConfig_ID)
	{
		if (LBR_NFConfig_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LBR_NFConfig_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LBR_NFConfig_ID, Integer.valueOf(LBR_NFConfig_ID));
	}

	/** Get NF Configuration.
		@return NF Configuration	  */
	public int getLBR_NFConfig_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LBR_NFConfig_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Reverse InOut.
		@param LBR_ReverseInOut 
		Allow to Reverse InOut related with the NF
	  */
	public void setLBR_ReverseInOut (boolean LBR_ReverseInOut)
	{
		set_Value (COLUMNNAME_LBR_ReverseInOut, Boolean.valueOf(LBR_ReverseInOut));
	}

	/** Get Reverse InOut.
		@return Allow to Reverse InOut related with the NF
	  */
	public boolean isLBR_ReverseInOut () 
	{
		Object oo = get_Value(COLUMNNAME_LBR_ReverseInOut);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Reverse Invoice.
		@param LBR_ReverseInvoice 
		Allow to Reverse Invoice related with the NF
	  */
	public void setLBR_ReverseInvoice (boolean LBR_ReverseInvoice)
	{
		set_Value (COLUMNNAME_LBR_ReverseInvoice, Boolean.valueOf(LBR_ReverseInvoice));
	}

	/** Get Reverse Invoice.
		@return Allow to Reverse Invoice related with the NF
	  */
	public boolean isLBR_ReverseInvoice () 
	{
		Object oo = get_Value(COLUMNNAME_LBR_ReverseInvoice);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Emissão Normal = 1 */
	public static final String LBR_TPEMIS_EmissãoNormal = "1";
	/** Contingência FS-IA = 2 */
	public static final String LBR_TPEMIS_ContingênciaFS_IA = "2";
	/** Contingência SCAN = 3 */
	public static final String LBR_TPEMIS_ContingênciaSCAN = "3";
	/** Contingência DPEC = 4 */
	public static final String LBR_TPEMIS_ContingênciaDPEC = "4";
	/** Contingência FS-DA = 5 */
	public static final String LBR_TPEMIS_ContingênciaFS_DA = "5";
	/** Contingência SVC-AN = 6 */
	public static final String LBR_TPEMIS_ContingênciaSVC_AN = "6";
	/** Contingência SVC-RS = 7 */
	public static final String LBR_TPEMIS_ContingênciaSVC_RS = "7";
	/** Contingência off-line da NFC-e = 9 */
	public static final String LBR_TPEMIS_ContingênciaOff_LineDaNFC_E = "9";
	/** Set Tipo de Emissão.
		@param LBR_TPEmis 
		Indicar o Tipo de Emissão da NF-e.
	  */
	public void setLBR_TPEmis (String LBR_TPEmis)
	{

		set_Value (COLUMNNAME_LBR_TPEmis, LBR_TPEmis);
	}

	/** Get Tipo de Emissão.
		@return Indicar o Tipo de Emissão da NF-e.
	  */
	public String getLBR_TPEmis () 
	{
		return (String)get_Value(COLUMNNAME_LBR_TPEmis);
	}

	/** 1 - Normal DANFE - Portrait = 1 */
	public static final String LBR_DANFEFORMAT_1_NormalDANFE_Portrait = "1";
	/** 2 - Normal DANFE - Landscape = 2 */
	public static final String LBR_DANFEFORMAT_2_NormalDANFE_Landscape = "2";
	/** 0 - No DANFE = 0 */
	public static final String LBR_DANFEFORMAT_0_NoDANFE = "0";
	/** 3 - Simple DANFE = 3 */
	public static final String LBR_DANFEFORMAT_3_SimpleDANFE = "3";
	/** 4 - DANFE NFC-e = 4 */
	public static final String LBR_DANFEFORMAT_4_DANFENFC_E = "4";
	/** 5 - DANFE NFC-e in Eletronic Message = 5 */
	public static final String LBR_DANFEFORMAT_5_DANFENFC_EInEletronicMessage = "5";
	/** Set DANFE Format.
		@param lbr_DANFEFormat DANFE Format	  */
	public void setlbr_DANFEFormat (String lbr_DANFEFormat)
	{

		set_Value (COLUMNNAME_lbr_DANFEFormat, lbr_DANFEFormat);
	}

	/** Get DANFE Format.
		@return DANFE Format	  */
	public String getlbr_DANFEFormat () 
	{
		return (String)get_Value(COLUMNNAME_lbr_DANFEFormat);
	}

	/** Set Data contingência.
		@param lbr_DateScan Data contingência	  */
	public void setlbr_DateScan (Timestamp lbr_DateScan)
	{
		set_Value (COLUMNNAME_lbr_DateScan, lbr_DateScan);
	}

	/** Get Data contingência.
		@return Data contingência	  */
	public Timestamp getlbr_DateScan () 
	{
		return (Timestamp)get_Value(COLUMNNAME_lbr_DateScan);
	}

	/** Set Motivo contingência.
		@param lbr_MotivoScan Motivo contingência	  */
	public void setlbr_MotivoScan (String lbr_MotivoScan)
	{
		set_Value (COLUMNNAME_lbr_MotivoScan, lbr_MotivoScan);
	}

	/** Get Motivo contingência.
		@return Motivo contingência	  */
	public String getlbr_MotivoScan () 
	{
		return (String)get_Value(COLUMNNAME_lbr_MotivoScan);
	}

	/** Production = 1 */
	public static final String LBR_NFEENV_Production = "1";
	/** Homologation = 2 */
	public static final String LBR_NFEENV_Homologation = "2";
	/** Set NFe Environment.
		@param lbr_NFeEnv NFe Environment	  */
	public void setlbr_NFeEnv (String lbr_NFeEnv)
	{

		set_Value (COLUMNNAME_lbr_NFeEnv, lbr_NFeEnv);
	}

	/** Get NFe Environment.
		@return NFe Environment	  */
	public String getlbr_NFeEnv () 
	{
		return (String)get_Value(COLUMNNAME_lbr_NFeEnv);
	}
}