package com.example.devdemo.threaddemo;

/**
 * @Author: bi
 * @createTime: 2024年03月13日 09:36:29
 * @version: 1.0
 * @Description: 线程的实现方式实现runable接口
 */
public class CreatedThread01 implements Runnable{
    @Override
    public void run() {
        System.out.println("通过实现创建了一个线程");
    }

}