package com.apis;

import com.alibaba.fastjson.JSON;
import com.env.Env_test;
import com.utils.RequestUtils;
import com.utils.SignUtil;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GetCodePicture {
    @Test
    public void getCodePicture() throws Exception {

        String url = Env_test.getCodePicture_url;
        String secret="78cafd64beeaa808eb61e2ef54eccc17";
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("uidkey", "604D5E5EAE"); //渠道商识别码
        data.put("order_no", "202202221575");//订单号
        data.put("orderid", "111137");//券码id
        String sign= SignUtil.sign(data, secret);
        System.out.println("sign:"+sign);
        data.put("sign", sign);//
        String requestdata = JSON.toJSONString(data);
        System.out.println("获取二维码图片请求参数" + requestdata);
        String response = RequestUtils.postRequest(url, requestdata);
        System.out.println("获取二维码图片接口返回参数" + response);
    }


}
