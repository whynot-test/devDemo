package com.example.devdemo.threaddemo;

import java.util.concurrent.Callable;

/**
 * @Author: bi
 * @createTime: 2024年03月13日 09:44:26
 * @version: 1.0
 * @Description: 实现 有返回值的线程
 */
public class CreatedThread03 implements Callable<String> {

    private String name;

    public CreatedThread03(String name){
        this.name = name;
    }
    @Override
    public String call() throws Exception {
        return name;
    }
}