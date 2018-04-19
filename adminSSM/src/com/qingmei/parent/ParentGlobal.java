package com.qingmei.parent;

import com.qingmei.util.PropertiesUtil;


/**
 * 定义一些全局变量。
 * 
 * @author  roy tang 
 * @version 1.0 
 * @since 2016-7-6
 */
public class ParentGlobal extends ParentStaticObject{
	public static String systype =null;
	public static String sysTitle =null;
	public static String commRoot =null;//
	public static String mainRoot =null;//
	/**
	 * 读取系统参数
	 */
	private static void readSysConfig(){
		PropertiesUtil conf = new PropertiesUtil("init.properties");
		//System.out.println("==========xxxx");
		systype =conf.getValue("sysInfo.sysType");
		sysTitle =conf.getValue("sysInfo.sysTitle");
		commRoot =conf.getValue("sysInfo.commRoot");
		mainRoot =conf.getValue("sysInfo.mainRoot");
		//这里取配置文件的配置参数
	}



	public static String getSystype() {
		if(systype==null)readSysConfig();
		return systype;
	}
	public static String getSysTitle() {
		if(sysTitle==null)readSysConfig();
		return sysTitle;
	}
	public static String getCommRoot() {
		if(commRoot==null)readSysConfig();
		return commRoot;
	}
	public static String getMainRoot() {
		if(mainRoot==null)readSysConfig();
		return mainRoot;
	}
	
	

}
