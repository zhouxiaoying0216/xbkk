package com.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class SignUtil {
	
	/**
	 * 参数签名
	 */
	public static String sign(Map<String,Object> paramMap,String secret) throws Exception {
		String signStr= null;
		List<String> keys = new ArrayList<String>(paramMap.keySet());
        Collections.sort(keys);
        String prestr = "";
        for (String key:keys) {
        	prestr += key;
            Object value = paramMap.get(key);
            if(!(value instanceof List)&&!(value instanceof Map)) {//集合类的不拼接
            	prestr += value;
            }
            else{
            	prestr += JSONObject.toJSONString(value);
            }
        }
        prestr+=secret;
        System.out.println("======="+prestr);
        signStr = MD5.md5(prestr, "", "utf-8", false);
		return signStr;

	}
	
	/**
	*参数验签
	*/
	public static boolean verifySign(Map<String,Object> paramMap,String secret) throws Exception {
		String sign = String.valueOf(paramMap.get("sign"));
		paramMap.remove("sign");
		String checkSign=sign(paramMap, secret);
		if(sign.equals(checkSign)){
			return true;
		}else{
			return false;
		}
		
	}

}
