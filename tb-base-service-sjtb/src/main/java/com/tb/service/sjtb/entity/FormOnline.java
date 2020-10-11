package com.tb.service.sjtb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @ClassName: FormOnline
 * @Description:
 * @Author: wangf
 * @Date: 2019/10/10 0010 23:03
 * @Version: 1.0
 **/
@Entity
@Table(name = "form_online", catalog = "")
public class FormOnline {
    private String id;
    private String tableName;
    private String formName;
    private String idField;
    private Integer isAuto;
    private Integer formType;
    private String dialogSize;
    private String dbSource;
    private String handleClass;
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    private Integer isTable;
    private String sql;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "table_name")
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Basic
    @Column(name = "form_name")
    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    @Basic
    @Column(name = "id_field")
    public String getIdField() {
        return idField;
    }

    public void setIdField(String idField) {
        this.idField = idField;
    }

    @Basic
    @Column(name = "is_auto")
    public Integer getIsAuto() {
        return isAuto;
    }

    public void setIsAuto(Integer isAuto) {
        this.isAuto = isAuto;
    }

    @Basic
    @Column(name = "form_type")
    public Integer getFormType() {
        return formType;
    }

    public void setFormType(Integer formType) {
        this.formType = formType;
    }

    @Basic
    @Column(name = "dialog_size")
    public String getDialogSize() {
        return dialogSize;
    }

    public void setDialogSize(String dialogSize) {
        this.dialogSize = dialogSize;
    }

    @Basic
    @Column(name = "db_source")
    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }

    @Basic
    @Column(name = "handle_class")
    public String getHandleClass() {
        return handleClass;
    }

    public void setHandleClass(String handleClass) {
        this.handleClass = handleClass;
    }

    @Basic
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "is_table")
    public Integer getIsTable() {
        return isTable;
    }

    public void setIsTable(Integer isTable) {
        this.isTable = isTable;
    }

    @Basic
    @Column(name = "sql_statement")
    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FormOnline that = (FormOnline) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(tableName, that.tableName) &&
                Objects.equals(formName, that.formName) &&
                Objects.equals(idField, that.idField) &&
                Objects.equals(isAuto, that.isAuto) &&
                Objects.equals(formType, that.formType) &&
                Objects.equals(dialogSize, that.dialogSize) &&
                Objects.equals(dbSource, that.dbSource) &&
                Objects.equals(handleClass, that.handleClass) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tableName, formName, idField, isAuto, formType, dialogSize, dbSource, handleClass,
                createTime);
    }
}
