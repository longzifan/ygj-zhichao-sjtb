package com.tb.service.formonline.service.impl;

import com.sticker.online.core.anno.AsyncServiceHandler;
import com.sticker.online.core.model.BaseAsyncService;
import_replace_code
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@AsyncServiceHandler
@Component
service_impl_name_replace_code

    @PersistenceContext
    private EntityManager entityManager;
    tableName_replace_code

    @Override
    @Transactional
    public void add(JsonObject params, Handler<AsyncResult<String>> handler) {
        Future<String> future = Future.future();
        StringBuffer sqlColumn = new StringBuffer(String.format("insert into %s( ", tableName));
        StringBuffer sqlValue = new StringBuffer("values( ");
        add_column_replace_code
        add_value_replace_code
        sqlColumn.append(")");
        sqlValue.append(")");
        String sql = sqlColumn.toString() + sqlValue.toString();
        Query query = entityManager.createNativeQuery(sql);
        query.executeUpdate();
        future.complete("新增成功!");
        handler.handle(future);
    }

    @Override
    @Transactional
    public void update(JsonObject params, Handler<AsyncResult<String>> handler) {
        Future<String> future = Future.future();
        StringBuffer sql = new StringBuffer(String.format("update %s set ", tableName));
        update_replace_code
        sql.append(String.format(" where id='%s'", params.getString("id")));
        Query query = entityManager.createNativeQuery(sql.toString());
        query.executeUpdate();
        future.complete("修改成功!");
        handler.handle(future);
    }

    @Override
    public void list(JsonObject params, Handler<AsyncResult<JsonObject>> handler) {
        Future<JsonObject> future = Future.future();
        Integer pageNo = Integer.parseInt(params.getString("pageNo", "1"));
        Integer pageSize = Integer.parseInt(params.getString("pageSize", "10"));
        StringBuffer sql = new StringBuffer(String.format("select * from %s", tableName));
        Query query = entityManager.createNativeQuery(sql.toString());
        if (query.getResultList().size() > 0) {
            Query queryCount = entityManager.createNativeQuery(sql.toString());
            Query queryList = entityManager.createNativeQuery(sql.toString());
            queryList.setMaxResults(10);
            queryList.setFirstResult((pageNo - 1) * pageSize);
            queryList.unwrap(org.hibernate.SQLQuery.class)
                    .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            future.complete(new JsonObject().put("totalElements", queryCount.getResultList().size()).put("content",
                    new JsonArray(Json.encode(queryList.getResultList()))));
        } else {
            future.complete(new JsonObject().put("totalElements", 0).put("content", new JsonArray()));
        }
        handler.handle(future);
    }

    @Override
    @Transactional
    public void delete(JsonObject params, Handler<AsyncResult<String>> handler) {
        Future<String> future = Future.future();
        String sql = String.format("delete from %s where id='%s'", tableName, params.getString("id"));
        Query query = entityManager.createNativeQuery(sql);
        query.executeUpdate();
        future.complete("删除成功!");
        handler.handle(future);
    }
}
