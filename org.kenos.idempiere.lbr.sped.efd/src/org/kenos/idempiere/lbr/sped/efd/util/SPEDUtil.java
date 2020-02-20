package org.kenos.idempiere.lbr.sped.efd.util;

import org.adempierelbr.util.TextUtil;

public class SPEDUtil
{
	public static final String IND_MOV_FALSE 	= "0";
	public static final String IND_MOV_TRUE 	= "1";
	
	public static Long toLong (String text)
	{
		try
		{
			return Long.valueOf(TextUtil.toNumeric(text));
		}
		catch (Exception e) {}
		return null;
	}	//	toLong
	
	public static Integer toInteger (String text)
	{
		try
		{
			return Integer.valueOf(TextUtil.toNumeric(text));
		}
		catch (Exception e) {}
		return null;
	}	//	toLong
}
