package com.tb.service.sjtb.model;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

/**
 * Converter for {@link com.tb.service.sjtb.model.CaseCNInfo}.
 * NOTE: This class has been automatically generated from the {@link com.tb.service.sjtb.model.CaseCNInfo} original class using Vert.x codegen.
 */
public class CaseCNInfoConverter {

  public static void fromJson(Iterable<java.util.Map.Entry<String, Object>> json, CaseCNInfo obj) {
    for (java.util.Map.Entry<String, Object> member : json) {
      switch (member.getKey()) {
        case "anjuanCode":
          if (member.getValue() instanceof String) {
            obj.setAnjuanCode((String)member.getValue());
          }
          break;
        case "anjuanId":
          if (member.getValue() instanceof String) {
            obj.setAnjuanId((String)member.getValue());
          }
          break;
        case "copyCaseId":
          if (member.getValue() instanceof String) {
            obj.setCopyCaseId((String)member.getValue());
          }
          break;
        case "copyObject":
          if (member.getValue() instanceof String) {
            obj.setCopyObject((String)member.getValue());
          }
          break;
        case "copyOrgName":
          if (member.getValue() instanceof String) {
            obj.setCopyOrgName((String)member.getValue());
          }
          break;
        case "copyStatus":
          if (member.getValue() instanceof String) {
            obj.setCopyStatus((String)member.getValue());
          }
          break;
        case "copyTime":
          if (member.getValue() instanceof String) {
            obj.setCopyTime((String)member.getValue());
          }
          break;
        case "copyType":
          if (member.getValue() instanceof String) {
            obj.setCopyType((String)member.getValue());
          }
          break;
        case "fromDistCode":
          if (member.getValue() instanceof String) {
            obj.setFromDistCode((String)member.getValue());
          }
          break;
        case "punishmentDate":
          if (member.getValue() instanceof String) {
            obj.setPunishmentDate((String)member.getValue());
          }
          break;
        case "toDistCode":
          if (member.getValue() instanceof String) {
            obj.setToDistCode((String)member.getValue());
          }
          break;
      }
    }
  }

  public static void toJson(CaseCNInfo obj, JsonObject json) {
    toJson(obj, json.getMap());
  }

  public static void toJson(CaseCNInfo obj, java.util.Map<String, Object> json) {
    if (obj.getAnjuanCode() != null) {
      json.put("anjuanCode", obj.getAnjuanCode());
    }
    if (obj.getAnjuanId() != null) {
      json.put("anjuanId", obj.getAnjuanId());
    }
    if (obj.getCopyCaseId() != null) {
      json.put("copyCaseId", obj.getCopyCaseId());
    }
    if (obj.getCopyObject() != null) {
      json.put("copyObject", obj.getCopyObject());
    }
    if (obj.getCopyOrgName() != null) {
      json.put("copyOrgName", obj.getCopyOrgName());
    }
    if (obj.getCopyStatus() != null) {
      json.put("copyStatus", obj.getCopyStatus());
    }
    if (obj.getCopyTime() != null) {
      json.put("copyTime", obj.getCopyTime());
    }
    if (obj.getCopyType() != null) {
      json.put("copyType", obj.getCopyType());
    }
    if (obj.getFromDistCode() != null) {
      json.put("fromDistCode", obj.getFromDistCode());
    }
    if (obj.getPunishmentDate() != null) {
      json.put("punishmentDate", obj.getPunishmentDate());
    }
    if (obj.getToDistCode() != null) {
      json.put("toDistCode", obj.getToDistCode());
    }
  }
}
