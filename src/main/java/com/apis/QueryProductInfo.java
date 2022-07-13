package com.apis;

import com.alibaba.fastjson.JSON;
import com.env.Env_test;
import com.utils.RequestUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/*

产品查询接口
 */

public class QueryProductInfo {

    @Test
    public void queryProductInfo() throws IOException {

        String url = Env_test.queryp_url;

        Map<String, Object> data = new HashMap<String, Object>();

        data.put("uidkey", "2D5C02B372"); //渠道商识别码
        String requestdata = JSON.toJSONString(data);
        String response = RequestUtils.postRequest(url, requestdata);
        System.out.println("查询产品接口返回参数" + response);
    }


}
