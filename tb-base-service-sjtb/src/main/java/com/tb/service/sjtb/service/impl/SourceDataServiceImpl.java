package com.tb.service.sjtb.service.impl;

import com.sticker.online.core.anno.AsyncServiceHandler;
import com.sticker.online.core.model.BaseAsyncService;
import com.tb.service.sjtb.entity.WebServiceSuper;
import com.tb.service.sjtb.entity.WebServiceUploadWeighInfo;
import com.tb.service.sjtb.entity.WebServiceUploadWeighPicInfo;
import com.tb.service.sjtb.repository.SourceDataRepository;
import com.tb.service.sjtb.service.SourceDataService;
import com.tb.service.sjtb.utils.SmbFileUtil;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@AsyncServiceHandler
@Component
public class SourceDataServiceImpl implements SourceDataService, BaseAsyncService {
    private static Logger log = LoggerFactory.getLogger(SourceDataServiceImpl.class);

    @Autowired
    private SourceDataRepository sourceDataRepository;

    @Override
    public void sendUploadWeighPicInfo(JsonObject param, Handler<AsyncResult<JsonArray>> handler) {
        Map<String, Date> time = getTime(param);
        List<Map<String, Object>> maps = sourceDataRepository.sendUploadWeighPicInfo(time.get("startTime"), time.get("endTime"));
        AtomicReference<JsonArray> jsonArray = new AtomicReference<>(new JsonArray());
        maps.forEach(map -> {
            String imagePath = String.valueOf(map.get("fileName"));
            if (null != imagePath) {
                String path = imagePath.substring(imagePath.indexOf("/") + 1);
                SmbFileUtil.smbGet(path, map);
            }
            JsonObject jsonObject = new JsonObject(map);
            jsonArray.get().add(jsonObject);
        });
        batchSend(jsonArray.get(), "2.5");
    }

    @Override
    public void sendUploadWeighInfo(JsonObject param, Handler<AsyncResult<JsonArray>> handler) {
        Map<String, Date> time = getTime(param);
        List<Map<String, Object>> maps = sourceDataRepository.sendUploadWeighInfo(time.get("startTime"), time.get("endTime"));
        AtomicReference<JsonArray> jsonArray = new AtomicReference<>(new JsonArray());
        maps.forEach(map -> {
            jsonArray.get().add(new JsonObject(map));
        });
        batchSend(jsonArray.get(), "2.4");
    }

    public void batchSend(JsonArray maps, String serverNum) {
        WebServiceSuper webServiceSuper;
        switch (serverNum) {
            case "2.4":
                webServiceSuper = new WebServiceUploadWeighInfo();
                break;
            case "2.5":
                webServiceSuper = new WebServiceUploadWeighPicInfo();
                break;
            default:
                log.error("没有这个服务编号");
                return;
        }
        AtomicReference<JsonArray> jsonArray = new AtomicReference<>(new JsonArray());
        AtomicInteger i = new AtomicInteger();
        int size = maps.size();
        AtomicInteger count = new AtomicInteger();
        maps.forEach(jsonObject -> {
            count.incrementAndGet();
            jsonArray.get().add(jsonObject);
            i.getAndIncrement();
            if (i.get() == 30) {
                webServiceSuper.send(String.valueOf(i.get()), jsonArray.get());
                i.set(0);
                jsonArray.set(new JsonArray());
            }
            if (i.get() <= 30 && size == count.get()) {
                webServiceSuper.send(String.valueOf(i.get()), jsonArray.get());
            }
        });
    }

    public Map<String, Date> getTime(JsonObject param) {
        String startTimeStr = param.getString("startTime");
        String endTimeStr = param.getString("endTime");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = null;
        Date endTime = null;
        try {
            startTime = sdf.parse(startTimeStr);
            endTime = sdf.parse(endTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Map<String, Date> map = new HashMap<>();
        map.put("startTime", startTime);
        map.put("endTime", endTime);
        return map;
    }
}
