package com.base.user.module;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*
 * 该实体对应数据库中表user
 * 数据库表中的列名跟实体中的属性名一致
**/
public class User {

    private  String id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
