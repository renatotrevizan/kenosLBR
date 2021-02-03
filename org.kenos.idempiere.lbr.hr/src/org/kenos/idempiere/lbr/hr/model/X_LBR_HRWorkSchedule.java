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

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;

/** Generated Model for LBR_HRWorkSchedule
 *  @author iDempiere (generated) 
 *  @version Release 6.2 - $Id$ */
public class X_LBR_HRWorkSchedule extends PO implements I_LBR_HRWorkSchedule, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20210202L;

    /** Standard Constructor */
    public X_LBR_HRWorkSchedule (Properties ctx, int LBR_HRWorkSchedule_ID, String trxName)
    {
      super (ctx, LBR_HRWorkSchedule_ID, trxName);
      /** if (LBR_HRWorkSchedule_ID == 0)
        {
			setLBR_HRWorkSchedule_ID (0);
        } */
    }

    /** Load Constructor */
    public X_LBR_HRWorkSchedule (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_LBR_HRWorkSchedule[")
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

	/** None = N */
	public static final String LBR_HRWORKINTERVALTYPE_None = "N";
	/** Variable Hours = V */
	public static final String LBR_HRWORKINTERVALTYPE_VariableHours = "V";
	/** Fixed Time = F */
	public static final String LBR_HRWORKINTERVALTYPE_FixedTime = "F";
	/** Set Work Interval Type.
		@param LBR_HRWorkIntervalType 
		Indicate Type of Interval
	  */
	public void setLBR_HRWorkIntervalType (String LBR_HRWorkIntervalType)
	{

		set_Value (COLUMNNAME_LBR_HRWorkIntervalType, LBR_HRWorkIntervalType);
	}

	/** Get Work Interval Type.
		@return Indicate Type of Interval
	  */
	public String getLBR_HRWorkIntervalType () 
	{
		return (String)get_Value(COLUMNNAME_LBR_HRWorkIntervalType);
	}

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

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), String.valueOf(getLBR_HRWorkSchedule_ID()));
    }

	/** Worked = W */
	public static final String LBR_HRWORKSCHEDULETYPE_Worked = "W";
	/** Offset = O */
	public static final String LBR_HRWORKSCHEDULETYPE_Offset = "O";
	/** Day Off = D */
	public static final String LBR_HRWORKSCHEDULETYPE_DayOff = "D";
	/** Set Work Schedule Type.
		@param LBR_HRWorkScheduleType 
		Indicate Type of Work Schedule
	  */
	public void setLBR_HRWorkScheduleType (String LBR_HRWorkScheduleType)
	{

		set_Value (COLUMNNAME_LBR_HRWorkScheduleType, LBR_HRWorkScheduleType);
	}

	/** Get Work Schedule Type.
		@return Indicate Type of Work Schedule
	  */
	public String getLBR_HRWorkScheduleType () 
	{
		return (String)get_Value(COLUMNNAME_LBR_HRWorkScheduleType);
	}

	/** Set LBR_HRWorkSchedule_UU.
		@param LBR_HRWorkSchedule_UU LBR_HRWorkSchedule_UU	  */
	public void setLBR_HRWorkSchedule_UU (String LBR_HRWorkSchedule_UU)
	{
		set_Value (COLUMNNAME_LBR_HRWorkSchedule_UU, LBR_HRWorkSchedule_UU);
	}

	/** Get LBR_HRWorkSchedule_UU.
		@return LBR_HRWorkSchedule_UU	  */
	public String getLBR_HRWorkSchedule_UU () 
	{
		return (String)get_Value(COLUMNNAME_LBR_HRWorkSchedule_UU);
	}

	/** Set Period In Minutes.
		@param LBR_PeriodInMinutes Period In Minutes	  */
	public void setLBR_PeriodInMinutes (BigDecimal LBR_PeriodInMinutes)
	{
		set_Value (COLUMNNAME_LBR_PeriodInMinutes, LBR_PeriodInMinutes);
	}

	/** Get Period In Minutes.
		@return Period In Minutes	  */
	public BigDecimal getLBR_PeriodInMinutes () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LBR_PeriodInMinutes);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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