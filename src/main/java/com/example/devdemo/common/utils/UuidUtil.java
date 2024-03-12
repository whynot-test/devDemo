package com.example.devdemo.common.utils;

import java.util.UUID;

/**
 * @Author: bi
 * @createTime: 2024年03月11日 11:07:56
 * @version: 1.0
 * @Description:
 */
public final class UuidUtil {

    public UuidUtil() {
    }
    public static String getUUID32(){
        return UUID.randomUUID().toString().replace("-","").toLowerCase();
    }
}