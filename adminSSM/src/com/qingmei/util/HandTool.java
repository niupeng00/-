package com.qingmei.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.qingmei.parent.ParentStaticObject;


/**
 * 页面常用工具类
 * @author Administrator
 *
 */
public class HandTool extends ParentStaticObject{
	
	
	/**
	 * 取客户端ip地址（通用）
	 * @param request
	 * @return
	 */
	public static String getRemoteIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for"); 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("WL-Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_CLIENT_IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getRemoteAddr(); 
	    } 
	    return ip; 
	} 
	
	
	/**
	 * 取cookie值
	 * @param request
	 * @param cookieName
	 * @return
	 */
	public static String getCookie(HttpServletRequest request,String cookieName){
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for (int i = 0; i < cookies.length; i++){
				Cookie c = cookies[i];
				if(c.getName().equalsIgnoreCase(cookieName)){
					return c.getValue();
				}
			}
		}
		return "";
	}
	
	/**
	 * cookie赋值
	 * @param response
	 * @param cookieDomain
	 * @param cookieName
	 * @param cookieValue
	 *//*
	public static void setCookie(HttpServletResponse response, String cookieDomain, String cookieName, String cookieValue){
		Cookie myCookie=new Cookie(cookieName,cookieValue);
		myCookie.setDomain(cookieDomain==null ? SysStatic.getMainDomain() : cookieDomain);
		myCookie.setPath("/");
		myCookie.setMaxAge(60*60*24*365);
		response.addCookie(myCookie);
	}*/
	
	
	/**
	 * 
	 * @param url：两种格式，1html,2script(格式为：javascript:xxxxxxxxxxx)
	 * 如：
	 *     http://xxxx/abc.html?a=x&pn=**
	 *     javascript:query({a:"x",pn:**});
	 * @param currentPage
	 * @param totalPage
	 * @param pageSize
	 * @param rowCount
	 * @return
	 */
	/*public static String getPagesInfo(String url,PagesInfo pagesInfo){
		//if(totalPage<=1)return "";
		int currentPage =pagesInfo.getCurrentPage();
		int totalPage =pagesInfo.getPageCount();
		if(totalPage<=1)return "";
		int pageSize =pagesInfo.getPageSize();
		int rowCount =pagesInfo.getRowCount();
		
		StringBuffer ret =new StringBuffer("<label class=\"fontNote rightMar2\">共").append(rowCount).append("条</label>");
		int pages =5;//显示11个页码,左右各5
		int leftNum,rightNum;
		String replace ="**";
		int pop =url.indexOf(replace);
		
		String urlLeft =url.substring(0,pop);
		String urlRight =url.substring(pop+2);
		
		leftNum =currentPage -pages;
		rightNum =currentPage +pages;
		if(leftNum <1){
			rightNum =rightNum +(1-leftNum);
			leftNum =1;
		}
		if(rightNum >totalPage){
			leftNum =leftNum -(rightNum -totalPage);
			rightNum =totalPage;
		}
		if(leftNum<1)leftNum =1;
		
		if(currentPage>1)ret.append("<a href='").append(urlLeft).append(1).append(urlRight).append("'>首页</a>");
		for(int i=leftNum;i<=rightNum;i++){
			if(i==currentPage)ret.append("<span>").append(i).append("</span>");
			else{
				ret.append("<a href='").append(urlLeft).append(i).append(urlRight).append("'>").append(i).append("</a>");
			}
		}
		
		if(currentPage<totalPage){
			ret.append("<a href='").append(urlLeft).append(totalPage).append(urlRight).append("'>尾页</a>");
		}
		
		StringBuffer go2Page=new StringBuffer("var cpage=$(\"#targetPage\").val();");
		if(urlLeft.indexOf("javascript:")<0){
			//html情形
			go2Page.append("document.location=\"").append(urlLeft).append("\"+cpage+\"").append(urlRight).append("\";");
		}else{
			//script情形
			go2Page.append(urlLeft.substring(11)).append("cpage").append(urlRight);
		}
		
		ret.append("&nbsp;&nbsp;页次").append(currentPage).append("/").append(totalPage).append("&nbsp;每页").append(pageSize).append("总计").append(rowCount);
		ret.append("&nbsp;&nbsp;转到<input type=text id='targetPage' maxlength='10' size='3' class='text f'><input type=button value=' Go ' class='btn_2k3' onclick='").append(go2Page).append("'>");
		
		
		//System.out.println(ret);
		return ret.toString();
		
	}*/
	
	/**
	 * 转换url对应的缩略url
	 * @param objPreName
	 * @param url
	 * @return
	 */
	public static String getObjUrl(String objPreName,String url){
		if(url==null)return url;
		if(!objPreName.equals(""))objPreName=objPreName+"-";
				
		String fold =null;
		String fName =null;
		int pos=url.lastIndexOf("/");
		if(pos>0){
			fold=url.substring(0,pos+1);
			fName =url.substring(pos+1);
			pos=fName.indexOf("-");
			if(pos>=0 & pos<fName.length())fName=fName.substring(pos+1);
		}else return url;
		
		return new StringBuffer(fold).append(objPreName).append(fName).toString();
		
	}
	
	
	/***
	 * 取服务器当前日期（"yyyy-MM-dd"格式）
	 */
	public static String getDateStr(){
    	final java.text.SimpleDateFormat formatDate = new java.text.SimpleDateFormat("yyyy-MM-dd");
    	
    	return formatDate.format(((Calendar)Calendar.getInstance()).getTime());
    	
    }
    
    /***
	 * 取服务器当前时间（"yyyy-MM-dd HH:mm"格式）
	 */
    public static String getTimeStr(){
    	final java.text.SimpleDateFormat formatDate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
    	
    	return formatDate.format(((Calendar)Calendar.getInstance()).getTime());
    	
    }
    
    public static String transDateToDate(Date date)
    {
      if (date != null)
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
      else
        return null;
    }
    
    public static String transDate(Date date, String format)
    {
      if (date != null)
        return new SimpleDateFormat(format).format(date);
      else
        return null;
    }
    
    public static String transDateToDatetime(Date date)
    {
      if (date != null)
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
      else
        return null;
    }
    
    public static String getValue(Object value){
    	if(value==null)return "";
    	
    	return value.toString();
    }
}