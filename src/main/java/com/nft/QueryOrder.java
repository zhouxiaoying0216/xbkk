package com.nft;


import com.utils.RequestUtils;

import org.testng.annotations.Test;

import java.io.IOException;

public class QueryOrder {
//    前端查询财务订单信息
   @Test
    public void test() throws IOException {
        String josn="{\n" +
                "    \"detailOrderNo\":\"\"\n" +
                "}";
        String url="http://crmeb.51vchat.com:8080/nft/finance/pay/detail";
        String response = RequestUtils.postRequest(url, josn);
       System.out.println("入参为"+response);
        System.out.println("响应结果为"+response);
    }
}
