package com.example.devdemo.javademo.datastructure.stackdemo;

import java.util.Stack;

/**
 * @Author: bi
 * @createTime: 2024年03月14日 10:26:24
 * @version: 1.0
 * @Description: 栈的实现
 */
public class StackDemo<E> {

    private Object[] data = null;

    private int maxSize = 0;

    private int top = -1;

    public StackDemo(int maxSize) {
        if(maxSize>=0){
            this.maxSize = maxSize;
            data = new Object[maxSize];
            top = -1;
        }else {
            throw new RuntimeException("初始化大小不能小于0");
        }
    }

    StackDemo(){
        this(10);
    }
}