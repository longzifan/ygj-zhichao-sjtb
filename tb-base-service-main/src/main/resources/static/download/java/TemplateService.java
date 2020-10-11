package com.tb.service.formonline.service;

import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

@ProxyGen
service_name_replace_code

    void add(JsonObject params, Handler<AsyncResult<String>> handler);

    void update(JsonObject params, Handler<AsyncResult<String>> handler);

    void list(JsonObject params, Handler<AsyncResult<JsonObject>> handler);

    void delete(JsonObject params, Handler<AsyncResult<String>> handler);

}
