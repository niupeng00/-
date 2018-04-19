package com.qingmei.parent;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.qingmei.entity.AdminUser;



/**
 * 所有ACTION的基类。
 * 
 * @author  roy tang
 * @version 1.0
 *  2016-7-6
 */
public class BaseAction {
	protected final transient Logger logger = Logger.getLogger(getClass());
	

	/**
	 * 取得请求参数值
	 * @param colName 请求参数名称
	 * @return
	 */
	public String getRequestValue(HttpServletRequest request,String colName) {
		return this.getRequestValue(request, colName,"");
	}
	
	/**
	 * 取得请求参数值，
	 * @param colName 请求参数名称
	 * @param defaultValue 默认值
	 * @return
	 */
	public String getRequestValue(HttpServletRequest request,String colName,String defaultValue) {
		String obj =request.getParameter(colName);
		if(obj==null)return defaultValue;
		obj =obj.trim();//  " a b c "---"a b c"
		if(obj.equals(""))return defaultValue;
		return obj;
	}
	
	/**
	 * 取得请求参数的整型值
	 * @param colName 请求参数名称
	 * @param defaultValue 默认值
	 * @return
	 */
	public Integer getRequestInteger(HttpServletRequest request,String colName,Integer defaultValue) {
		Integer value = defaultValue;
		try{
			value =Integer.valueOf(request.getParameter(colName));
		}catch(Exception e){
			
		}
		return value;
	}
	

	
	/**
	 * 取得对象的字符串表示
	 * @param obj
	 * @return
	 */
	public String getValue(Object obj) {
		if(obj==null)return "";
		else return obj.toString();
	}
	
	
	//xml json
	//给页面发送json字符串数据。
	public String  sendMessageJson(HttpServletResponse response,String text ) 
			 {
		
		String thisText=(text==null) ? "" : text;
		
		response.setCharacterEncoding("utf-8");
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires", 0);		
		response.setContentType("text/jackson");
		 
		
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print( thisText  );
		out.flush();
		out.close();
		return null;
	}
	
	/**
	 * 向响应response中写入字符串(Ajax)
	 * @param text 返回的字符串
	 * @param outType 输出类型：html,js
	 * @return String "none"：表示不返回任何视图
	 * @throws Exception
	 */
	public String sendMessage(HttpServletResponse response,
			String text,String outType) throws Exception{
		
		String thisText=(text==null) ? "" : text;
		response.setCharacterEncoding("utf-8");
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires", 0);
		if(outType.equals("js")){
			response.setContentType("text/javascript");
		}else{
			response.setContentType("text/plain");
		}
		
		PrintWriter out = response.getWriter();
		out.print( thisText  );
		out.flush();
		out.close();
		return null;
	}
	
	
	/**
	 * 向响应response中写入html语法的字符串
	 * @param html html语法
	 * @param message 消息
	 * @param javaScript
	 * @throws Exception
	 */
	public String sendMessageHtml(HttpServletResponse response,String html, String message, String javaScript) throws Exception{
		
		String htmlS=(html==null) ? "" : html;
		String mess=(message==null) ? "" : message;
		
		StringBuffer sp=new StringBuffer("");
		
		sp.append("<html><head>").append("<script language=javascript>function loadIni(){")
			.append(javaScript).append("}</script></head>")
			.append("<body onload='loadIni()'>")
			.append(htmlS).append("<span id=mess>").append(mess).append("</span></body></html>");			
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires", 0);
		
		out.println(sp);
		
		out.flush();
		out.close();
		
		return null;
	}
	
	/**
	 * 记录日志
	 * @param exception
	 */
	public void log(Exception exception) {
		logger.error(exception.getMessage(), exception);
	}
	
	
	
	public Map<String,Map<String,Object>> transListToMap(List<Map<String,Object>> queryList,String keyColumnName){
		Map<String,Map<String,Object>> ret =new HashMap<String,Map<String,Object>>();
		Iterator<Map<String,Object>> it =queryList.iterator();
		String key =null;
		Map<String,Object> row =null;
		while(it.hasNext()){
			row =it.next();
			key =row.get(keyColumnName).toString();
			ret.put(key, row);
		}
		return ret;
	}


	/**
	 * 取当前会话用户对象
	 * @return AdminUser
	 */
	public AdminUser getUserFromSession(HttpServletRequest request){
		HttpSession session =request.getSession();
		Object obj =session.getAttribute("userObj");
		if(obj==null)return null;
		else return (AdminUser)obj;
	}
	
	public int getPageSize(AdminUser user){
		if(user==null)return 20;
		return user.getPageSize();
	}
	
	public int getModulePermission(HttpServletRequest request){
		String moduleCode =request.getRequestURI();

		int pos =request.getContextPath().length();
		if(pos>1)pos ++;
		moduleCode =moduleCode.substring(pos,moduleCode.lastIndexOf("/")+1);
		
		return getModulePermission(request,moduleCode);
	}

	/**
	 * 取用户的权限
	 * @param moduleCode
	 * @return,0无权限，大于0有权限
	 */
	public int getModulePermission(HttpServletRequest request,String moduleCode){
		
		
		HttpSession session =request.getSession();
		Object obj =session.getAttribute("userObj");
		if(obj==null)return 0;
		
		AdminUser user =(AdminUser)obj;
	    if(user.getUserName().equalsIgnoreCase("ADMIN"))return 2;//超级用户
		
		obj =session.getAttribute("userModuleStr");
		
		if(obj==null)return 0;
		if((this.getValue(obj)).indexOf(","+moduleCode+",1,")>=0)return 2;
		
		if((this.getValue(obj)).indexOf(","+moduleCode+",")>=0)return 1;
		
		return 0;
	}
}
