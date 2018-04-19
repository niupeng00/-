package com.qingmei.parent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.qingmei.util.PropertiesUtil;

/**
 * 系统初始化处理
 * @author 汤慧龙
 * @vertion 创建日期2017年1月3日
 */
public class InitSystem extends HttpServlet{
	
	private static final long serialVersionUID = -6286371731551805344L;

	
	public void init() throws ServletException
	{
		/*** 系统参数读取  放到application 供界面使用  ***/
		PropertiesUtil conf = new PropertiesUtil("init.properties");

		//application 全局
		this.getServletContext().setAttribute("commRoot", conf.getValue("sysInfo.commRoot"));
		this.getServletContext().setAttribute("sysTitle", conf.getValue("sysInfo.sysTitle"));
		this.getServletContext().setAttribute("mainRoot", conf.getValue("sysInfo.mainRoot"));
		this.getServletContext().setAttribute("sysType", conf.getValue("sysInfo.sysType"));
		
    }
}
