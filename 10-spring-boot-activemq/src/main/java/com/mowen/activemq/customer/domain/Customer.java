package com.mowen.activemq.customer.domain;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @description: 顾客表
 * @author: Administrator
 * @createTime: 2020-04-29 11:40:45
 */
@Data
public class Customer implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * Id
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 注册的ip地址
     */
    private String ip;
    /**
     * 用户状态，1 正常 0 关闭
     */
    private Integer status;
    /**
     * 加入时间
     */

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新时间
     */

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}