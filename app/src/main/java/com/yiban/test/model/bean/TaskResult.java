package com.yiban.test.model.bean;

import com.google.gson.annotations.SerializedName;

public class TaskResult {
    /**
     * code : 0
     * msg :
     * data : 490ccf5e7cff278305fab1f19d93813e
     */

    @SerializedName("code")
    private Integer code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private String data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
