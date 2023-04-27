package com.zheok.pufeite.controller;

import com.alibaba.fastjson.JSONObject;

public class Entity {
    private Object formData;

    public Object getString() {
        return formData;
    }

    public void setString(JSONObject string) {
        this.formData = string;
    }
}
