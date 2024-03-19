package com.example.devdemo.javademo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.devdemo.threaddemo.CreatedThread01;
import com.example.devdemo.threaddemo.CreatedThread02;
import com.example.devdemo.threaddemo.CreatedThread03;
import com.example.devdemo.threaddemo.CreatedThread04;

/**
 * @Author: bi
 * @createTime: 2024年03月13日 10:02:38
 * @version: 1.0
 * @Description:
 */
@SpringBootTest
public class ThreadTestDemo {

    /**
     * 实现runable接口线程测试
     */
    @Test
    public void threadTestDemo01() {
        //创建一个CreatedThread01线程对象
        CreatedThread01 createdThread01 = new CreatedThread01();
        //创键一个线程对象并为其传入已经实例化好的createdThread01
        Thread thread = new Thread(createdThread01);
        thread.start();
    }

    /**
     * 继承实现线程测试
     */
    @Test
    public void threadTest02() {
        //实例化一个线程对象
        CreatedThread02 createdThread02 = new CreatedThread02();
        createdThread02.start();
    }

    /**
     * 实现CallAble接口线程测试
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void threadTest03() throws ExecutionException, InterruptedException {
        //创建一个线程数量为5的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        List<Future> lists = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            CreatedThread03 createdThread03 = new CreatedThread03(i + "");
            Future future = threadPool.submit(createdThread03);
            System.out.println("输出：" + i);
            lists.add(future);
        }
        //关闭线程池
        threadPool.shutdown();
        //遍历所有线程的运行结果
        for (Future future : lists) {
            System.out.println("返回及结果："+future.get().toString());
        }
    }


    /**
     * 线程池创建线程测试
     * @throws InterruptedException
     */
    @Test
    public void threadTest04() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute( new Runnable(){

                @Override
                public void run() {
                    System.out.println("现成开始执行test04"+Thread.currentThread().getName());
                }
            });

        }
        executorService.shutdown();
        executorService.awaitTermination(2000, TimeUnit.MICROSECONDS);
    }
}