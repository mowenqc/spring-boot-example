package com.mowen.common.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/****
 * @project: common
 * @author: huangkai
 * @create-time: 2020/4/23 14:27 
 * @description: 日期处理器
 *****/
public class DateUtil {

    public static String DATE = "yyyy-MM-dd";

    public static String DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    public static Date parse(String date){
        return parse(date, null);
    }

    public static Date parse(String date, String pattern){
        try {
            if(StringUtil.isEmpty(pattern)){
                pattern = DATE_TIME;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String format(Date date, String pattern){
        if(StringUtil.isEmpty(pattern)){
            pattern = DATE_TIME;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public static String format(Date date){
        return format(date, null);
    }
}
