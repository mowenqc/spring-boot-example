package com.mowen.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;

import java.io.IOException;

/****
 * @project: spring-boot-example
 * @author: huangkai
 * @create-time: 2020/4/29 17:47 
 * @description:
 *****/
public class StringUtil {
    /**
     * 判定字符串source是否是空串
     *
     * @param source
     * @return true 为空
     * false 飞空
     */
    public static boolean isEmpty(String source) {
        if (source == null || source == "") {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否为飞空
     *
     * @param source 源字符串
     * @return
     */
    public static boolean isNotEmpty(String source) {
        return !isEmpty(source);
    }


    public static String toJson(Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T toObject(String json, Class<T> tClass) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, tClass);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
