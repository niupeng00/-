package com.qingmei.parent;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 公用模块基础类
 *
 * @author  roy tang
 * @version 1.0
 * @since 2016-7-6 *
 */
public class ParentStaticObject {
	public static String getValue(Map<String,Object> h, String tag) {
		if(h==null)return "";
		
		return h.get(tag)==null ? "" : h.get(tag).toString();
	}
	
	
	public static String getValue(List<Object> list,int ind){
		if(list==null)return "";
		if(list.size()<ind+1)return "";
		
		return list.get(ind)==null ? "" : (String)list.get(ind);
	}
	
	public static String getValue(Object o){
		if(o ==null)return "";
		return o.toString();
	}
	public static String getValue(HttpServletRequest req, String colName) {
		String value =req.getParameter(colName);
		if(value==null)return "";
		return value;
	}
}