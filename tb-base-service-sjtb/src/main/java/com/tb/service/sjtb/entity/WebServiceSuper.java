package com.tb.service.sjtb.entity;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public abstract class WebServiceSuper {

    WebServiceSuper(){}

    public void send(String count, JsonArray jsonArray){}

    JsonObject getSendJsonObject(String count, JsonArray jsonArray){
        //将json数组添加到json对象
        JsonObject dataJson = new JsonObject();
        dataJson.put("dataCount", count);
        dataJson.put("dataContent", jsonArray);
        return dataJson;
    }

}
