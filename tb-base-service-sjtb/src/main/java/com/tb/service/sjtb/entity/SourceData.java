package com.tb.service.sjtb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "SourceData", catalog = "")
public class SourceData {
    //主键
    private String Sid;
    //站点编号
    private String StCode;
    //称重时间
//    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String WeiTime;
    //车牌号码
    private String CarId;
    //图片路径
    private String ImagePath;

    @Id
    @Column(name = "Sid")
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "uuid")
    public String getSid() {
        return Sid;
    }

    public void setSid(String sid) {
        Sid = sid;
    }
    @Basic
    @Column(name = "StCode")
    public String getStCode() {
        return StCode;
    }

    public void setStCode(String stCode) {
        StCode = stCode;
    }
    @Basic
    @Column(name = "WeiTime")
    public String getWeiTime() {
        return WeiTime;
    }

    public void setWeiTime(String weiTime) {
        WeiTime = weiTime;
    }
    @Basic
    @Column(name = "CarId")
    public String getCarId() {
        return CarId;
    }

    public void setCarId(String carId) {
        CarId = carId;
    }
    @Basic
    @Column(name = "ImagePath")
    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }




}
