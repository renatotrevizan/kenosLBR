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
package org.kenos.idempiere.lbr.hr.model;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Model for LBR_HRWorkPeriod
 *  @author iDempiere (generated) 
 *  @version Release 6.2 - $Id$ */
public class X_LBR_HRWorkPeriod extends PO implements I_LBR_HRWorkPeriod, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20210202L;

    /** Standard Constructor */
    public X_LBR_HRWorkPeriod (Properties ctx, int LBR_HRWorkPeriod_ID, String trxName)
    {
      super (ctx, LBR_HRWorkPeriod_ID, trxName);
      /** if (LBR_HRWorkPeriod_ID == 0)
        {
			setLBR_HRWorkPeriod_ID (0);
        } */
    }

    /** Load Constructor */
    public X_LBR_HRWorkPeriod (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_LBR_HRWorkPeriod[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Work Period.
		@param LBR_HRWorkPeriod_ID Work Period	  */
	public void setLBR_HRWorkPeriod_ID (int LBR_HRWorkPeriod_ID)
	{
		if (LBR_HRWorkPeriod_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LBR_HRWorkPeriod_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LBR_HRWorkPeriod_ID, Integer.valueOf(LBR_HRWorkPeriod_ID));
	}

	/** Get Work Period.
		@return Work Period	  */
	public int getLBR_HRWorkPeriod_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LBR_HRWorkPeriod_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), String.valueOf(getLBR_HRWorkPeriod_ID()));
    }

	/** Default = D */
	public static final String LBR_HRWORKPERIODTYPE_Default = "D";
	/** Fixed Period = F */
	public static final String LBR_HRWORKPERIODTYPE_FixedPeriod = "F";
	/** Variable Period = V */
	public static final String LBR_HRWORKPERIODTYPE_VariablePeriod = "V";
	/** Especial Period = E */
	public static final String LBR_HRWORKPERIODTYPE_EspecialPeriod = "E";
	/** Set Work Period Type.
		@param LBR_HRWorkPeriodType Work Period Type	  */
	public void setLBR_HRWorkPeriodType (String LBR_HRWorkPeriodType)
	{

		set_Value (COLUMNNAME_LBR_HRWorkPeriodType, LBR_HRWorkPeriodType);
	}

	/** Get Work Period Type.
		@return Work Period Type	  */
	public String getLBR_HRWorkPeriodType () 
	{
		return (String)get_Value(COLUMNNAME_LBR_HRWorkPeriodType);
	}

	/** Set LBR_HRWorkPeriod_UU.
		@param LBR_HRWorkPeriod_UU LBR_HRWorkPeriod_UU	  */
	public void setLBR_HRWorkPeriod_UU (String LBR_HRWorkPeriod_UU)
	{
		set_Value (COLUMNNAME_LBR_HRWorkPeriod_UU, LBR_HRWorkPeriod_UU);
	}

	/** Get LBR_HRWorkPeriod_UU.
		@return LBR_HRWorkPeriod_UU	  */
	public String getLBR_HRWorkPeriod_UU () 
	{
		return (String)get_Value(COLUMNNAME_LBR_HRWorkPeriod_UU);
	}

	/** None = N */
	public static final String LBR_SPECIALPERIODTYPE_None = "N";
	/** 12x36 = A */
	public static final String LBR_SPECIALPERIODTYPE_12x36 = "A";
	/** 24x72 = B */
	public static final String LBR_SPECIALPERIODTYPE_24x72 = "B";
	/** Other = O */
	public static final String LBR_SPECIALPERIODTYPE_Other = "O";
	/** Set Special Period Type.
		@param LBR_SpecialPeriodType Special Period Type	  */
	public void setLBR_SpecialPeriodType (String LBR_SpecialPeriodType)
	{

		set_Value (COLUMNNAME_LBR_SpecialPeriodType, LBR_SpecialPeriodType);
	}

	/** Get Special Period Type.
		@return Special Period Type	  */
	public String getLBR_SpecialPeriodType () 
	{
		return (String)get_Value(COLUMNNAME_LBR_SpecialPeriodType);
	}

	/** Set Name.
		@param Name 
		Alphanumeric identifier of the entity
	  */
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName () 
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

	/** Set Start Date.
		@param StartDate 
		First effective day (inclusive)
	  */
	public void setStartDate (Timestamp StartDate)
	{
		set_Value (COLUMNNAME_StartDate, StartDate);
	}

	/** Get Start Date.
		@return First effective day (inclusive)
	  */
	public Timestamp getStartDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_StartDate);
	}

	/** Set Search Key.
		@param Value 
		Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue () 
	{
		return (String)get_Value(COLUMNNAME_Value);
	}
}