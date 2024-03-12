/**
 * @projectName devDemo
 * @package com.example.devdemo.common.enums
 * @className com.example.devdemo.common.enums.ResponseCode
 * @copyright Copyright 2024 Thunisoft, Inc All rights reserved.
 */
package com.example.devdemo.common.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * ResponseCode
 * @description
 * @author Administrator
 * @date 2024/3/11 9:49
 * @version TODO
 */
public enum ResponseCode {

    //[GET]：服务器成功返回用户请求的数据
    RESPONSE_200_OK("200", 200, "Ok"),
    //[POST/PUT/PATCH]：用户新建或修改数据成功。
    RESPONSE_201_CREATE("201", 201, "Created"),
    RESPONSE_201_UPDATED("201", 201, "Updated"),
    //[DELETE]：用户删除数据成功。
    RESPONSE_204_NO_CONTENT("204", 204, "No Content"),
    //[GET/POST/PUT/PATCH]：语义有误，当前请求无法被服务器理解
    RESPONSE_400_INVALID_REQUEST("400", 400, "Invalid Request");
    private Integer status;

    private String code;

    private String data;

    ResponseCode(Integer status, String data) {
        this.status = status;
        this.data = data;
    }

    ResponseCode(String code, Integer status, String data) {
        this.code = code;
        this.status = status;
        this.data = data;
    }

    public static ResponseCode getRequestCode(String code) {
        for (ResponseCode rs : values()) {
            if (StringUtils.equals(rs.code, code)) {
                return rs;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + code + "]");
    }

    public String getCode() {
        return code;
    }

    public String getData() {
        return data;
    }

    public Integer getStatus() {
        return status;
    }
}