package com.tb.service.sjtb.handler;

import com.sticker.online.core.anno.RouteHandler;
import com.sticker.online.core.anno.RouteMapping;
import com.sticker.online.core.anno.RouteMethod;
import com.sticker.online.core.model.ReplyObj;
import com.sticker.online.core.utils.AsyncServiceUtil;
import com.sticker.online.core.utils.HttpUtil;
import com.sticker.online.tools.common.utils.CommonUtil;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonArray;
import io.vertx.ext.web.RoutingContext;
import org.springframework.beans.factory.annotation.Autowired;

import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_OK;

@RouteHandler("SUser")
public class SUserHandler {

//    @Autowired
//    private SUserService service = AsyncServiceUtil.getAsyncServiceInstance(SUserService.class);

    private final String URL = "/SUser";

    @RouteMapping(value = URL, method = RouteMethod.POST)
    public Handler<RoutingContext> add() {
        return ctx -> {
            HttpUtil.fireJsonResponse(ctx.response(), HTTP_OK, ReplyObj.build().setResult(new JsonArray()));
//            service.add(CommonUtil.createCondition(ctx.request(), ctx.getBody()), response -> {
//                if (response.succeeded()) {
//                    HttpUtil.fireJsonResponse(ctx.response(), HTTP_OK, ReplyObj.build().setResult(response.result()));
//                } else {
//                    HttpUtil.fireJsonResponse(ctx.response(), HTTP_BAD_REQUEST, ReplyObj.build().setResult(response.cause().getMessage()));
//                }
//            });
        };
    }





}
