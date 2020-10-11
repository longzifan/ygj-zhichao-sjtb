package com.tb.service.sjtb.model;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class CaseCNInfo {
    public CaseCNInfo() {
    }

    public JsonObject toJson() {
        JsonObject json =new JsonObject();
        CaseCNInfoConverter.toJson(this, json);
        return json;
    }
    public CaseCNInfo(JsonObject jsonObject) {
        CaseCNInfoConverter.fromJson(jsonObject, this);
    }

    /**
     * 案件抄告信息
     */
    private String copyCaseId;
    /**
     * 抄告省份行政
     * 区划代码
     */
    private String fromDistCode;
    /**
     * 对应路面治超
     * 案件信息的唯一
     * 标志 ID
     */
    private String anjuanId;
    /**
     * 行政处罚决定
     * 书文号
     */
    private String anjuanCode;
    /**
     * 处罚时间
     */
    private String punishmentDate;
    /**
     * 接收省份行政
     * 区划代码
     */
    private String toDistCode;
    /**
     * 抄告机构
     */
    private String copyOrgName;
    /**
     * 抄告对象
     */
    private String copyObject;
    /**
     * 抄告信息类型
     */
    private String copyType;
    /**
     * 抄告时间
     */
    private String copyTime;
    /**
     * 抄告信息状态
     * 代码
     */
    private String copyStatus;

    public String getCopyCaseId() {
        return copyCaseId;
    }

    public void setCopyCaseId(String copyCaseId) {
        this.copyCaseId = copyCaseId;
    }

    public String getFromDistCode() {
        return fromDistCode;
    }

    public void setFromDistCode(String fromDistCode) {
        this.fromDistCode = fromDistCode;
    }

    public String getAnjuanId() {
        return anjuanId;
    }

    public void setAnjuanId(String anjuanId) {
        this.anjuanId = anjuanId;
    }

    public String getAnjuanCode() {
        return anjuanCode;
    }

    public void setAnjuanCode(String anjuanCode) {
        this.anjuanCode = anjuanCode;
    }

    public String getPunishmentDate() {
        return punishmentDate;
    }

    public void setPunishmentDate(String punishmentDate) {
        this.punishmentDate = punishmentDate;
    }

    public String getToDistCode() {
        return toDistCode;
    }

    public void setToDistCode(String toDistCode) {
        this.toDistCode = toDistCode;
    }

    public String getCopyOrgName() {
        return copyOrgName;
    }

    public void setCopyOrgName(String copyOrgName) {
        this.copyOrgName = copyOrgName;
    }

    public String getCopyObject() {
        return copyObject;
    }

    public void setCopyObject(String copyObject) {
        this.copyObject = copyObject;
    }

    public String getCopyType() {
        return copyType;
    }

    public void setCopyType(String copyType) {
        this.copyType = copyType;
    }

    public String getCopyTime() {
        return copyTime;
    }

    public void setCopyTime(String copyTime) {
        this.copyTime = copyTime;
    }

    public String getCopyStatus() {
        return copyStatus;
    }

    public void setCopyStatus(String copyStatus) {
        this.copyStatus = copyStatus;
    }
}
