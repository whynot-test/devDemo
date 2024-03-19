package com.example.devdemo.threaddemo;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: bi
 * @createTime: 2024年03月13日 09:49:10
 * @version: 1.0
 * @Description: 线程池实现线程
 */
public class CreatedThread04 {
    
    public static void main(String[] args) {
        //创建大小为10的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            //提交多个线程任务并执行
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(
                            Thread.currentThread().getName() + " is Runing"
                    );
                }
            });
            
        }      
    }
    
    
  
    
}