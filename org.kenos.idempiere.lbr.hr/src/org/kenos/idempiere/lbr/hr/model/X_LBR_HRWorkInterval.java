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

/** Generated Model for LBR_HRWorkInterval
 *  @author iDempiere (generated) 
 *  @version Release 6.2 - $Id$ */
public class X_LBR_HRWorkInterval extends PO implements I_LBR_HRWorkInterval, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20210202L;

    /** Standard Constructor */
    public X_LBR_HRWorkInterval (Properties ctx, int LBR_HRWorkInterval_ID, String trxName)
    {
      super (ctx, LBR_HRWorkInterval_ID, trxName);
      /** if (LBR_HRWorkInterval_ID == 0)
        {
			setIsDefault (false);
			setLBR_HRWorkInterval_ID (0);
        } */
    }

    /** Load Constructor */
    public X_LBR_HRWorkInterval (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_LBR_HRWorkInterval[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set End Time.
		@param EndTime 
		End of the time span
	  */
	public void setEndTime (Timestamp EndTime)
	{
		set_Value (COLUMNNAME_EndTime, EndTime);
	}

	/** Get End Time.
		@return End of the time span
	  */
	public Timestamp getEndTime () 
	{
		return (Timestamp)get_Value(COLUMNNAME_EndTime);
	}

	/** Set Default.
		@param IsDefault 
		Default value
	  */
	public void setIsDefault (boolean IsDefault)
	{
		set_Value (COLUMNNAME_IsDefault, Boolean.valueOf(IsDefault));
	}

	/** Get Default.
		@return Default value
	  */
	public boolean isDefault () 
	{
		Object oo = get_Value(COLUMNNAME_IsDefault);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Work Interval.
		@param LBR_HRWorkInterval_ID Work Interval	  */
	public void setLBR_HRWorkInterval_ID (int LBR_HRWorkInterval_ID)
	{
		if (LBR_HRWorkInterval_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LBR_HRWorkInterval_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LBR_HRWorkInterval_ID, Integer.valueOf(LBR_HRWorkInterval_ID));
	}

	/** Get Work Interval.
		@return Work Interval	  */
	public int getLBR_HRWorkInterval_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LBR_HRWorkInterval_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), String.valueOf(getLBR_HRWorkInterval_ID()));
    }

	/** Set LBR_HRWorkInterval_UU.
		@param LBR_HRWorkInterval_UU LBR_HRWorkInterval_UU	  */
	public void setLBR_HRWorkInterval_UU (String LBR_HRWorkInterval_UU)
	{
		set_Value (COLUMNNAME_LBR_HRWorkInterval_UU, LBR_HRWorkInterval_UU);
	}

	/** Get LBR_HRWorkInterval_UU.
		@return LBR_HRWorkInterval_UU	  */
	public String getLBR_HRWorkInterval_UU () 
	{
		return (String)get_Value(COLUMNNAME_LBR_HRWorkInterval_UU);
	}

	public I_LBR_HRWorkSchedule getLBR_HRWorkSchedule() throws RuntimeException
    {
		return (I_LBR_HRWorkSchedule)MTable.get(getCtx(), I_LBR_HRWorkSchedule.Table_Name)
			.getPO(getLBR_HRWorkSchedule_ID(), get_TrxName());	}

	/** Set Work Schedule.
		@param LBR_HRWorkSchedule_ID Work Schedule	  */
	public void setLBR_HRWorkSchedule_ID (int LBR_HRWorkSchedule_ID)
	{
		if (LBR_HRWorkSchedule_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LBR_HRWorkSchedule_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LBR_HRWorkSchedule_ID, Integer.valueOf(LBR_HRWorkSchedule_ID));
	}

	/** Get Work Schedule.
		@return Work Schedule	  */
	public int getLBR_HRWorkSchedule_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LBR_HRWorkSchedule_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Start Time.
		@param StartTime 
		Time started
	  */
	public void setStartTime (Timestamp StartTime)
	{
		set_Value (COLUMNNAME_StartTime, StartTime);
	}

	/** Get Start Time.
		@return Time started
	  */
	public Timestamp getStartTime () 
	{
		return (Timestamp)get_Value(COLUMNNAME_StartTime);
	}
}