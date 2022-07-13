package com.nft;

import com.alibaba.fastjson.JSONObject;
import com.utils.RequestUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CrtBlockChainAccount {
    @Test
    public static void crtBlockChainAccount() throws IOException {
        Map<String ,Object> map=new HashMap<String, Object>();
        map.put("uid","74");
        map.put("type","3");
        String req= JSONObject.toJSONString(map);
            String url="http://crmeb.51vchat.com:8080/nft/acc/v1/crtBlockChainAccount";
            String response = RequestUtils.postRequest(url, req);
            System.out.println("入参为"+req);
            System.out.println("响应结果为"+response);

    }
}
