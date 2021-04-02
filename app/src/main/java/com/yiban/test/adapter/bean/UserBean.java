package com.yiban.test.adapter.bean;

import java.io.Serializable;

public class UserBean implements Serializable {

    private  String phone;
    private  String msg;
    private String name;
    private int flag;

    public UserBean(String phone, String msg) {
        this.phone = phone;
        this.msg = msg;

    }

    public void setOk(int flag) {
        this.flag = flag;
    }

    public int isOk() {
        return flag;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public String getMsg() {
        return msg;
    }

}

