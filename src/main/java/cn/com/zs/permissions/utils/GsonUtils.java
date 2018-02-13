package cn.com.zs.permissions.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 标题: gson工具类
 * <p>
 * 描述: gson工具类
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/12-13:22
 */
public class GsonUtils {

    private static final Gson GSON = new GsonBuilder().create();

    public static String toJson(Object object){
        return GSON.toJson(object);
    }

    public static <T>T toBean(String jsonStr,Class<T> clazz){
        return GSON.fromJson(jsonStr,clazz);
    }
}
