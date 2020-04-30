package com.mowen.common.domain;

import com.mowen.common.util.StringUtil;

import java.io.Serializable;

/****
 * @project: spring-boot-example
 * @author: huangkai
 * @create-time: 2020/4/29 17:48 
 * @description:
 *****/
public class ResponseEntity implements Serializable {

    /**
     * 100失败
     * 200成功
     */
    private String code;
    private Object data;
    public ResponseEntity(){}

    public ResponseEntity(String code, Object data, String msg){
        this.code = code;
        this.data = data;
    }
    public ResponseEntity(String code, Object data){
        this.code = code;
        this.data = data;
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
    @Override
    public String toString() {
        return StringUtil.toJson(this);
    }
}
