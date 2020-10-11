package com.tb.service.sjtb.entity;

import com.tb.service.sjtb.wsdl.ProvServiceService;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebServiceUploadWeighPicInfo extends WebServiceSuper {
    private static Logger log = LoggerFactory.getLogger(WebServiceUploadWeighPicInfo.class);

    public WebServiceUploadWeighPicInfo(){
        super();
    }

    @Override
    public void send(String count, JsonArray jsonArray){
        ProvServiceService ps = new ProvServiceService();
        String responsejson = ps.getProvServicePort().uploadWeighInfo(getSendJsonObject(count, jsonArray).toString());
        JsonObject jasonObject = new JsonObject(responsejson);
        log.info("称重检测图片视频文件信息上传接口--返回的信息是：" + jasonObject.toString());
        log.info("称重检测图片视频文件信息上传接口--返回的信息是：" + jasonObject.getValue("message"));
    }
}
