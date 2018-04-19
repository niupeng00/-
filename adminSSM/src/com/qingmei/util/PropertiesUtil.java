package com.qingmei.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.Properties;
/**
 * 读取properties文件类
 * @author city
 *
 */
public class PropertiesUtil {

	private Properties properties =new Properties();
	
	public  PropertiesUtil(String fileName){
		try{
			ClassLoader classLoader =Thread.currentThread().getContextClassLoader();
			URI uri =classLoader.getResource(fileName).toURI();
			File file =new File(uri);
			InputStream in = new BufferedInputStream(new FileInputStream(file));//classLoader.getResourceAsStream("sysconfig.properties");
					
			properties.load(in);
			in.close();
			
		}
		catch(Exception e)
		{
			properties =null;
			e.printStackTrace();
		}
	}
	
	public String getValue(String key)
	{
		Object value = null;
		if(key!=null&&!key.equals(""))
		{
			value = properties.get(key);
			if(value == null)
			{
				return "";
			}
		}
		return value.toString();
	}
}
