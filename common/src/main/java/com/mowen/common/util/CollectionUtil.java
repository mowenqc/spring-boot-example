package com.mowen.common.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

/****
 * @project: common
 * @author: huangkai
 * @create-time: 2020/4/23 11:01 
 * @description: 集合类框架工具类
 *****/
public class CollectionUtil {

    /**
     * 判断list
     * @param list 集合是否为空
     * @param <T>
     * @return
     */
    public static <T> boolean  isEmpty(List<T> list){
        if(list == null || list.size() == 0){
            return true;
        }
        return false;
    }

    public static <T> boolean isNotEmpty(List<T> list){
        return !isEmpty(list);
    }

    public static <T> boolean isEmpty(Set<T> set){
        if(set == null || set.size() == 0){
            return true;
        }
        return false;
    }

    public static <T> boolean isNotEmpty(Set<T> set){
        return !isEmpty(set);
    }

    public static <K,V> boolean isEmpty(Map<K,V> map){
        if(map == null || map.size() == 0){
            return true;
        }
        return false;
    }

    public static <K,V> boolean isNotEmpty(Map<K,V> map){
        return !isEmpty(map);
    }
}
