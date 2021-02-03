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
package org.kenos.idempiere.lbr.hr.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for LBR_HRWorkSchedule
 *  @author iDempiere (generated) 
 *  @version Release 6.2
 */
@SuppressWarnings("all")
public interface I_LBR_HRWorkSchedule 
{

    /** TableName=LBR_HRWorkSchedule */
    public static final String Table_Name = "LBR_HRWorkSchedule";

    /** AD_Table_ID=1120712 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name EndTime */
    public static final String COLUMNNAME_EndTime = "EndTime";

	/** Set End Time.
	  * End of the time span
	  */
	public void setEndTime (Timestamp EndTime);

	/** Get End Time.
	  * End of the time span
	  */
	public Timestamp getEndTime();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name LBR_HRWorkIntervalType */
    public static final String COLUMNNAME_LBR_HRWorkIntervalType = "LBR_HRWorkIntervalType";

	/** Set Work Interval Type.
	  * Indicate Type of Interval
	  */
	public void setLBR_HRWorkIntervalType (String LBR_HRWorkIntervalType);

	/** Get Work Interval Type.
	  * Indicate Type of Interval
	  */
	public String getLBR_HRWorkIntervalType();

    /** Column name LBR_HRWorkSchedule_ID */
    public static final String COLUMNNAME_LBR_HRWorkSchedule_ID = "LBR_HRWorkSchedule_ID";

	/** Set Work Schedule	  */
	public void setLBR_HRWorkSchedule_ID (int LBR_HRWorkSchedule_ID);

	/** Get Work Schedule	  */
	public int getLBR_HRWorkSchedule_ID();

    /** Column name LBR_HRWorkScheduleType */
    public static final String COLUMNNAME_LBR_HRWorkScheduleType = "LBR_HRWorkScheduleType";

	/** Set Work Schedule Type.
	  * Indicate Type of Work Schedule
	  */
	public void setLBR_HRWorkScheduleType (String LBR_HRWorkScheduleType);

	/** Get Work Schedule Type.
	  * Indicate Type of Work Schedule
	  */
	public String getLBR_HRWorkScheduleType();

    /** Column name LBR_HRWorkSchedule_UU */
    public static final String COLUMNNAME_LBR_HRWorkSchedule_UU = "LBR_HRWorkSchedule_UU";

	/** Set LBR_HRWorkSchedule_UU	  */
	public void setLBR_HRWorkSchedule_UU (String LBR_HRWorkSchedule_UU);

	/** Get LBR_HRWorkSchedule_UU	  */
	public String getLBR_HRWorkSchedule_UU();

    /** Column name LBR_PeriodInMinutes */
    public static final String COLUMNNAME_LBR_PeriodInMinutes = "LBR_PeriodInMinutes";

	/** Set Period In Minutes	  */
	public void setLBR_PeriodInMinutes (BigDecimal LBR_PeriodInMinutes);

	/** Get Period In Minutes	  */
	public BigDecimal getLBR_PeriodInMinutes();

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

    /** Column name StartDate */
    public static final String COLUMNNAME_StartDate = "StartDate";

	/** Set Start Date.
	  * First effective day (inclusive)
	  */
	public void setStartDate (Timestamp StartDate);

	/** Get Start Date.
	  * First effective day (inclusive)
	  */
	public Timestamp getStartDate();

    /** Column name StartTime */
    public static final String COLUMNNAME_StartTime = "StartTime";

	/** Set Start Time.
	  * Time started
	  */
	public void setStartTime (Timestamp StartTime);

	/** Get Start Time.
	  * Time started
	  */
	public Timestamp getStartTime();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();

    /** Column name Value */
    public static final String COLUMNNAME_Value = "Value";

	/** Set Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value);

	/** Get Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public String getValue();
}
