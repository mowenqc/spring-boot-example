package com.mowen.common.domain;

import java.io.Serializable;

/****
 * @project: spring-boot-example
 * @author: huangkai
 * @create-time: 2020/4/30 9:31 
 * @description:
 *****/
public class ErrorResult implements Serializable {

    /**
     * 错误代码
     */
    private String ec;

    /**
     * 错误消息
     */
    private String em;

    public String getEc() {
        return ec;
    }

    public void setEc(String ec) {
        this.ec = ec;
    }

    public String getEm() {
        return em;
    }

    public void setEm(String em) {
        this.em = em;
    }
}
