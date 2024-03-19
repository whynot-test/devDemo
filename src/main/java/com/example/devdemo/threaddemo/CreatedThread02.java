package com.example.devdemo.threaddemo;

/**
 * @Author: bi
 * @createTime: 2024年03月13日 09:41:34
 * @version:
 * @Description: 继承实现线程
 */
public class CreatedThread02 extends Thread{
    @Override
    public void run() {
        System.out.println("通过继承实现一个线程");
    }
}