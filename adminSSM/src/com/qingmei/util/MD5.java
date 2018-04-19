package com.qingmei.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

/**
 * MD5加密工具类
 * @author lwt
 *
 */
public final class MD5 {

    private static MessageDigest md5;
    /**
     * 将字符串进行md5加密
     * @param string:待加密字符串
     * @param encoding:字符编码(默认编码:utf-8)
     * @return
     * @throws RuntimeException
     */
    public static final String encodeString(String string,String encoding) throws RuntimeException {
    	return String.valueOf(Hex.encodeHex(digestString(string, encoding)));
    }
    /**
     * 按utf-8编码取出字符串进行加密
     * @param string
     * @return
     * @throws RuntimeException
     */
    public static final String encodeString(String string) throws RuntimeException{
    	//System.out.println(encodeString(string,null));
    	return encodeString(string,null);
    }
   
    private static byte[] digestString(String string, String encoding) throws RuntimeException {
        byte[] data;
        if (encoding == null) {
            encoding = "utf-8";
        }
        try {
            data = string.getBytes(encoding);
        } catch (UnsupportedEncodingException x) {
            throw new RuntimeException(x.toString());
        }
        return digestBytes(data);
    }

    private static final byte[] digestBytes(byte[] data)    throws RuntimeException {
        synchronized (MD5.class) {
            if (md5 == null) {
                try {
                    md5 = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e.toString());
                }
            }
            return md5.digest(data);
        }
    }
    
    public static void main(String[] args) {
//		String str1 = "12121212121212121212121212121212";
//		String pwd = MD5.encodeString(str1);
//		String enStr = "425021b8ff1039034f0058f8a9b2a7cd";
//		System.out.println(pwd);
		//System.out.println(MD5.check(str1, enStr));
	}
}