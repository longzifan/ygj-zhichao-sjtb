package com.tb.service.sjtb.handler;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import com.tb.service.sjtb.model.CaseCNInfo;
import com.tb.service.sjtb.wsdl.ProvServiceService;

import java.net.URL;

public class TestZCInterface {

    public static void main(String[] args) throws Exception {

        System.out.println(TestZCInterface.createJSONObject());

        ProvServiceService ps=new ProvServiceService();
        String responsejson =ps.getProvServicePort().uploadCaseCNInfo(TestZCInterface.createJSONObject());

        JsonObject jasonObject = new JsonObject(responsejson);
        System.out.println(jasonObject.toString());
        System.out.println("返回的信息是："+jasonObject.getValue("message"));
    }

    // 创建JSONObject对象
    private static String createJSONObject() {

        CaseCNInfo case1 = new CaseCNInfo();
        case1.setAnjuanCode("xxx01");
        case1.setAnjuanId("12345678901234567890123456789012");
        case1.setCopyCaseId("12345678901234567890123456789012");
        case1.setCopyObject("测试1");
        case1.setCopyOrgName("测试1");
        case1.setCopyStatus("处理中");
        case1.setCopyTime("2020/9/24 14:20:34");
        case1.setCopyType("1");
        case1.setFromDistCode("610002");
        case1.setPunishmentDate("020/9/24 14:20:34");
        case1.setToDistCode("xxx01");

        CaseCNInfo case2 = new CaseCNInfo();
        case2.setAnjuanCode("xxx02");
        case2.setAnjuanId("12345678901234567890123456789013");
        case2.setCopyCaseId("12345678901234567890123456789013");
        case2.setCopyObject("测试2");
        case2.setCopyOrgName("测试2");
        case2.setCopyStatus("处理中");
        case2.setCopyTime("2020/9/24 14:21:34");
        case2.setCopyType("1");
        case2.setFromDistCode("610002");
        case2.setPunishmentDate("020/9/24 14:21:34");
        case2.setToDistCode("xxx02");

        //将javabeans转换为json对象
        JsonObject jsonObject1 = case1.toJson();
        JsonObject jsonObject2 = case2.toJson();

        //将json对象添加到json数组
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(jsonObject1);
        jsonArray.add(jsonObject2);

        //将json数组添加到json对象
        JsonObject dataJson = new JsonObject();
        dataJson.put("dataCount","2");
        dataJson.put("dataContent",jsonArray);

        return dataJson.toString();
    }
}