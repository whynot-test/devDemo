package com.example.devdemo.common.utils;

import java.nio.charset.Charset;
import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: bi
 * @createTime: 2024年03月11日 10:26:23
 * @version: 1.0
 * @Description:
 */
public final class Md5Util {

    /**
     * slf4j
     */
    private static final Logger logger = LoggerFactory.getLogger(Md5Util.class);

    private Md5Util() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 获取当前字符串的32位小写md5
     *
     * @param str 目标字符串
     * @return md5值
     */
    public static String getMD5(String str) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes(Charset.forName("UTF-8")));
            int i;
            StringBuilder sb = new StringBuilder();
            for (byte bt : md5.digest()) {
                i = bt;
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (Exception e) {
            logger.error("获取MD5出错", e);
            return null;
        }
    }

}