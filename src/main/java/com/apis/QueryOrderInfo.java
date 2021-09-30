package com.apis;

import com.alibaba.fastjson.JSON;
import com.env.Env_test;
import com.utils.RequestUtils;
import com.utils.SignUtil;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/*
订单查询接口
 */

public class QueryOrderInfo {
    @Test
    public void queryOrderInfo() throws Exception {

        String url = Env_test.queryo_url;
        String secret="9b11f4f85f9e6cf5a7b233e5cf12951b";
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("uidkey", "2D5C02B372"); //渠道商识别码
        data.put("order_no", "109722");//订单号
        String sign= SignUtil.sign(data, secret);
        System.out.println("sign:"+sign);
        data.put("sign", sign);//
        String requestdata = JSON.toJSONString(data);
        String response = RequestUtils.postRequest(url, requestdata);
        System.out.println("查询订单接口返回参数" + response);
    }
}
