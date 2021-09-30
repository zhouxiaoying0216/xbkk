package com.apis;

import com.alibaba.fastjson.JSON;
import com.env.Env_test;
import com.utils.RequestUtils;
import com.utils.SignUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
下单接口
 */

public class CreateOrder {
    @Test
    public void createOrder() throws Exception {

        String url = Env_test.creato_url ;
        String secret="9b11f4f85f9e6cf5a7b233e5cf12951b";
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", "27");//产品id
        map.put("foodname", "燕麦拿铁（中杯）");//产品名称
        map.put("num", "1");//产品数量
        list.add(map);
//        Map<String, Object> map1 = new HashMap<String, Object>();
//        map1.put("id", "28");//产品id
//        map1.put("foodname", "馥芮白（中杯）");//产品名称
//        map1.put("num", "1");//产品数量
//        list.add(map1);

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("uidkey", "2D5C02B372");//渠道商识别码
        data.put("order_no", RandomStringUtils.randomNumeric(6));//订单号
        data.put("phone", "12000000021");//用户手机号
        data.put("openid", "123");//消费者唯一识别标识
        data.put("order_info", list);//餐品详情
        String sign= SignUtil.sign(data, secret);
        System.out.println("sgin值:"+sign);
        data.put("sign",sign );//签名串
        String requestdata = JSON.toJSONString(data);
        System.out.println("创建订单接口请求参数" + requestdata);
        String response = RequestUtils.postRequest(url, requestdata);
        System.out.println("创建订单接口返回参数" + response);
    }
}
