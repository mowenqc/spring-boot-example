package com.mowen.common.domain;

import java.io.Serializable;

/****
 * @project: spring-boot-example
 * @author: huangkai
 * @create-time: 2020/4/29 17:48 
 * @description:
 *****/
public class ResponseEntity implements Serializable {

    private String code;
    private Object data;
    private String msg;
    public ResponseEntity(){}

    public ResponseEntity(String code, Object data, String msg){
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
