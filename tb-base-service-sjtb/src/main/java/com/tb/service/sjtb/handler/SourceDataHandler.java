package com.tb.service.sjtb.handler;

import com.sticker.online.core.anno.RouteHandler;
import com.sticker.online.core.anno.RouteMapping;
import com.sticker.online.core.anno.RouteMethod;
import com.sticker.online.core.model.ReplyObj;
import com.sticker.online.core.utils.AsyncServiceUtil;
import com.sticker.online.core.utils.HttpUtil;
import com.sticker.online.tools.common.utils.CommonUtil;
import com.tb.service.sjtb.service.SourceDataService;
import com.tb.service.sjtb.wsdl.ProvServiceService;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.atomic.AtomicInteger;

import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_OK;

@RouteHandler("SourceData")
public class SourceDataHandler {

    @Autowired
    private SourceDataService service = AsyncServiceUtil.getAsyncServiceInstance(SourceDataService.class);


    @RouteMapping(value = "/sendUploadWeighPicInfo", method = RouteMethod.POST)
    public Handler<RoutingContext> sendUploadWeighPicInfo() {
        return ctx -> {
            JsonObject param = CommonUtil.createCondition(ctx.request(), ctx.getBody());
            service.sendUploadWeighPicInfo( param,ret -> HttpUtil.fireJsonResponse(ctx.response(), HTTP_BAD_REQUEST, ReplyObj.build().setResult("调用结束")));
        };
    }

    @RouteMapping(value = "/sendUploadWeighInfo", method = RouteMethod.POST)
    public Handler<RoutingContext> sendUploadWeighInfo() {
        return ctx -> {
            JsonObject param = CommonUtil.createCondition(ctx.request(), ctx.getBody());
            service.sendUploadWeighInfo( param,ret -> HttpUtil.fireJsonResponse(ctx.response(), HTTP_BAD_REQUEST, ReplyObj.build().setResult("调用结束")));
        };
    }





}
