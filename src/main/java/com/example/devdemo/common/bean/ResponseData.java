package com.example.devdemo.common.bean;

import com.example.devdemo.common.enums.ResponseCode;

/**
 * @Author: bi
 * @createTime: 2024年03月11日 09:42:45
 * @version: 1.0
 * @Description:
 */
public class ResponseData<T> {

    private Integer status;

    private String message;

    private T data;

    public ResponseData(String message) {
        this.message = message;
    }

    public ResponseData(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseData(ResponseCode responseCode) {
        this.status = responseCode.getStatus();
        this.message = responseCode.getData();
    }
    public ResponseData(ResponseCode responseCode, T data) {
        this.status = responseCode.getStatus();
        this.message = responseCode.getData();
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}