package com.tb.service.sjtb.service.impl;

import com.sticker.online.core.anno.AsyncServiceHandler;
import com.sticker.online.core.model.BaseAsyncService;
import com.tb.service.sjtb.service.SUserService;
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
public class SUserServiceImpl implements SUserService, BaseAsyncService {

    @PersistenceContext
    private EntityManager entityManager;
    private String tableName = "s_user";

    @Override
    @Transactional
    public void add(JsonObject params, Handler<AsyncResult<String>> handler) {
        Future<String> future = Future.future();
        JsonArray data = params.getJsonArray("data");
        StringBuffer sqlColumn = new StringBuffer(String.format("insert into %s( ", tableName));
        StringBuffer sqlValue = new StringBuffer("values( ");
        sqlColumn.append("id,username,realname,password,salt,avatar,birthday,sex,email,phone,org_code,status,del_flag,activiti_sync,create_by,create_time,update_by,update_time");
        sqlValue.append(String.format("'%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s'",params.getValue("id"),params.getValue("username"),params.getValue("realname"),params.getValue("password"),params.getValue("salt"),params.getValue("avatar"),params.getValue("birthday"),params.getValue("sex"),params.getValue("email"),params.getValue("phone"),params.getValue("org_code"),params.getValue("status"),params.getValue("del_flag"),params.getValue("activiti_sync"),params.getValue("create_by"),params.getValue("create_time"),params.getValue("update_by"),params.getValue("update_time")));
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
        sql.append(String.format("username='%s',realname='%s',password='%s',salt='%s',avatar='%s',birthday='%s',sex='%s',email='%s',phone='%s',org_code='%s',status='%s',del_flag='%s',activiti_sync='%s',create_by='%s',create_time='%s',update_by='%s',update_time='%s'",params.getValue("username"),params.getValue("realname"),params.getValue("password"),params.getValue("salt"),params.getValue("avatar"),params.getValue("birthday"),params.getValue("sex"),params.getValue("email"),params.getValue("phone"),params.getValue("org_code"),params.getValue("status"),params.getValue("del_flag"),params.getValue("activiti_sync"),params.getValue("create_by"),params.getValue("create_time"),params.getValue("update_by"),params.getValue("update_time")));
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
