package com.example.devdemo.common.utils;

import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.example.devdemo.common.bean.ResponseData;

/**
 * @Author: bi
 * @createTime: 2024年03月11日 09:39:17
 * @version: V1
 * @Description:
 */
public final class ResponseUtil {

    private ResponseUtil() {
        throw new IllegalStateException("Utility class");
    }

    private static SerializeConfig mapping = new SerializeConfig();

    private static final String DATAFORMAT_TIME = "yyyy-MM-dd HH:mm:ss";

    public static String toString(ResponseData responseData) {
        if (responseData == null) {
            return null;
        }
        JSON.DEFFAULT_DATE_FORMAT = DATAFORMAT_TIME;
        mapping.put(Date.class, new SimpleDateFormatSerializer(DATAFORMAT_TIME));
        return JSONObject.toJSONString(
                responseData,
                mapping,
                SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.DisableCircularReferenceDetect
        );
    }
}