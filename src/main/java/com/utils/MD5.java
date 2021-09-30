package com.utils;

import java.security.MessageDigest;

/**
 * 
 * @Title MD5.java
 * @Description MD5工具类
 *
 */
public class MD5 {
	
	private static final String DEFAULT_CHARSET = "utf-8";
	
	/**
	 * MD5加密
	 * @param text
	 * @param key
	 * @param charset
	 * @param toUpperCase
	 * @return
	 * @throws Exception
	 */
	public static String md5(String text, String key, String charset, boolean toUpperCase) throws Exception {
		byte[] bytes = (text + key).getBytes(charset);
		
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(bytes);
		bytes = messageDigest.digest();
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < bytes.length; i ++)
		{
			if((bytes[i] & 0xff) < 0x10)
			{
				sb.append("0");
			}

			sb.append(Long.toString(bytes[i] & 0xff, 16));
		}
		
		return toUpperCase ? sb.toString().toUpperCase() : sb.toString().toLowerCase();
	}
	
	/**
	 * MD5加密
	 * @param text
	 * @param key
	 * @param charset
	 * @return
	 * @throws Exception
	 */
	public static String md5(String text, String key, String charset) throws Exception {
		return md5(text, key, charset, true);
	}
	
	/**
	 * MD5加密
	 * @param text
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String md5(String text, String key) throws Exception {
		return md5(text, key, DEFAULT_CHARSET, true);
	}
	
	/**
	 * MD5加密
	 * @param text
	 * @return
	 * @throws Exception
	 */
	public static String md5(String text) throws Exception {
		return md5(text, "", DEFAULT_CHARSET, true);
	}
	
	/**
	 * MD5验证
	 * @param text
	 * @param key
	 * @param md5
	 * @return
	 * @throws Exception
	 */
	public static boolean verify(String text, String key, String md5) throws Exception {
		return md5.equalsIgnoreCase(md5(text, key, DEFAULT_CHARSET, true));
	}
	
	/**
	 * MD5验证
	 * @param text
	 * @param key
	 * @param charset
	 * @param md5
	 * @return
	 * @throws Exception
	 */
	public static boolean verify(String text, String key, String charset, String md5) throws Exception {
		return md5.equalsIgnoreCase(md5(text, key, charset, true));
	}
}