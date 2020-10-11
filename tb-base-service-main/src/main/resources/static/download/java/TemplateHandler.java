package com.tb.service.formonline.handler;

import com.sticker.online.core.anno.RouteHandler;
import com.sticker.online.core.anno.RouteMapping;
import com.sticker.online.core.anno.RouteMethod;
import com.sticker.online.core.model.ReplyObj;
import com.sticker.online.core.utils.AsyncServiceUtil;
import com.sticker.online.core.utils.HttpUtil;
import com.sticker.online.tools.common.utils.CommonUtil;
import_replace_code
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import org.springframework.beans.factory.annotation.Autowired;

import static java.net.HttpURLConnection.*;

base_url_replace_code
handler_name_replace_code

    @Autowired
    service_replace_code

    url_replace_code

    @RouteMapping(value = URL, method = RouteMethod.POST)
    public Handler<RoutingContext> add() {
        return ctx -> {
            service.add(CommonUtil.createCondition(ctx.request(), ctx.getBody()), response -> {
                if (response.succeeded()) {
                    HttpUtil.fireJsonResponse(ctx.response(), HTTP_OK, ReplyObj.build().setResult(response.result()));
                } else {
                    HttpUtil.fireJsonResponse(ctx.response(), HTTP_BAD_REQUEST, ReplyObj.build().setResult(response.cause().getMessage()));
                }
            });
        };
    }

    @RouteMapping(value = URL, method = RouteMethod.PUT)
    public Handler<RoutingContext> update() {
        return ctx -> {
            service.update(CommonUtil.createCondition(ctx.request(), ctx.getBody()), response -> {
                if (response.succeeded()) {
                    HttpUtil.fireJsonResponse(ctx.response(), HTTP_OK, ReplyObj.build().setResult(response.result()));
                } else {
                    HttpUtil.fireJsonResponse(ctx.response(), HTTP_BAD_REQUEST, ReplyObj.build().setResult(response.cause().getMessage()));
                }
            });
        };
    }

    @RouteMapping(value = URL, method = RouteMethod.GET)
    public Handler<RoutingContext> list() {
        return ctx -> {
            service.list(CommonUtil.createCondition(ctx.request(), ctx.getBody()), response -> {
                if (response.succeeded()) {
                    HttpUtil.fireJsonResponse(ctx.response(), HTTP_OK, ReplyObj.build().setResult(response.result()));
                } else {
                    HttpUtil.fireJsonResponse(ctx.response(), HTTP_BAD_REQUEST, ReplyObj.build().setResult(response.cause().getMessage()));
                }
            });
        };
    }

    @RouteMapping(value = URL, method = RouteMethod.DELETE)
    public Handler<RoutingContext> delete() {
        return ctx -> {
            service.delete(CommonUtil.createCondition(ctx.request(), ctx.getBody()), response -> {
                if (response.succeeded()) {
                    HttpUtil.fireJsonResponse(ctx.response(), HTTP_OK, ReplyObj.build().setResult(response.result()));
                } else {
                    HttpUtil.fireJsonResponse(ctx.response(), HTTP_BAD_REQUEST, ReplyObj.build().setResult(response.cause().getMessage()));
                }
            });
        };
    }

}
