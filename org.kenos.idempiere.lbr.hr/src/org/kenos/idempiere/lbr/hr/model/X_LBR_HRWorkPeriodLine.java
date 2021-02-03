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
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Model for LBR_HRWorkPeriodLine
 *  @author iDempiere (generated) 
 *  @version Release 6.2 - $Id$ */
public class X_LBR_HRWorkPeriodLine extends PO implements I_LBR_HRWorkPeriodLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20210202L;

    /** Standard Constructor */
    public X_LBR_HRWorkPeriodLine (Properties ctx, int LBR_HRWorkPeriodLine_ID, String trxName)
    {
      super (ctx, LBR_HRWorkPeriodLine_ID, trxName);
      /** if (LBR_HRWorkPeriodLine_ID == 0)
        {
			setLBR_HRWorkPeriodLine_ID (0);
        } */
    }

    /** Load Constructor */
    public X_LBR_HRWorkPeriodLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_LBR_HRWorkPeriodLine[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public I_LBR_HRWorkPeriod getLBR_HRWorkPeriod() throws RuntimeException
    {
		return (I_LBR_HRWorkPeriod)MTable.get(getCtx(), I_LBR_HRWorkPeriod.Table_Name)
			.getPO(getLBR_HRWorkPeriod_ID(), get_TrxName());	}

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

	/** Set Work Period Line.
		@param LBR_HRWorkPeriodLine_ID Work Period Line	  */
	public void setLBR_HRWorkPeriodLine_ID (int LBR_HRWorkPeriodLine_ID)
	{
		if (LBR_HRWorkPeriodLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LBR_HRWorkPeriodLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LBR_HRWorkPeriodLine_ID, Integer.valueOf(LBR_HRWorkPeriodLine_ID));
	}

	/** Get Work Period Line.
		@return Work Period Line	  */
	public int getLBR_HRWorkPeriodLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LBR_HRWorkPeriodLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), String.valueOf(getLBR_HRWorkPeriodLine_ID()));
    }

	/** Set LBR_HRWorkPeriodLine_UU.
		@param LBR_HRWorkPeriodLine_UU LBR_HRWorkPeriodLine_UU	  */
	public void setLBR_HRWorkPeriodLine_UU (String LBR_HRWorkPeriodLine_UU)
	{
		set_Value (COLUMNNAME_LBR_HRWorkPeriodLine_UU, LBR_HRWorkPeriodLine_UU);
	}

	/** Get LBR_HRWorkPeriodLine_UU.
		@return LBR_HRWorkPeriodLine_UU	  */
	public String getLBR_HRWorkPeriodLine_UU () 
	{
		return (String)get_Value(COLUMNNAME_LBR_HRWorkPeriodLine_UU);
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

	/** Set Sequence.
		@param SeqNo 
		Method of ordering records; lowest number comes first
	  */
	public void setSeqNo (int SeqNo)
	{
		set_Value (COLUMNNAME_SeqNo, Integer.valueOf(SeqNo));
	}

	/** Get Sequence.
		@return Method of ordering records; lowest number comes first
	  */
	public int getSeqNo () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SeqNo);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Monday = 1 */
	public static final String WEEKDAY_Monday = "1";
	/** Tuesday = 2 */
	public static final String WEEKDAY_Tuesday = "2";
	/** Wednesday = 3 */
	public static final String WEEKDAY_Wednesday = "3";
	/** Thursday = 4 */
	public static final String WEEKDAY_Thursday = "4";
	/** Friday = 5 */
	public static final String WEEKDAY_Friday = "5";
	/** Saturday = 6 */
	public static final String WEEKDAY_Saturday = "6";
	/** Sunday = 7 */
	public static final String WEEKDAY_Sunday = "7";
	/** Monday to Friday = 8 */
	public static final String WEEKDAY_MondayToFriday = "8";
	/** First day = 9 */
	public static final String WEEKDAY_FirstDay = "9";
	/** Second Day = 10 */
	public static final String WEEKDAY_SecondDay = "10";
	/** Third Day = 11 */
	public static final String WEEKDAY_ThirdDay = "11";
	/** Special Period = 12 */
	public static final String WEEKDAY_SpecialPeriod = "12";
	/** Set Day of the Week.
		@param WeekDay 
		Day of the Week
	  */
	public void setWeekDay (String WeekDay)
	{

		set_Value (COLUMNNAME_WeekDay, WeekDay);
	}

	/** Get Day of the Week.
		@return Day of the Week
	  */
	public String getWeekDay () 
	{
		return (String)get_Value(COLUMNNAME_WeekDay);
	}
}