package com.tb.service.sjtb.service;

import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

@ProxyGen
public interface SourceDataService {

    void sendUploadWeighPicInfo(JsonObject param,Handler<AsyncResult<JsonArray>> handler);
    void sendUploadWeighInfo(JsonObject param,Handler<AsyncResult<JsonArray>> handler);

}
