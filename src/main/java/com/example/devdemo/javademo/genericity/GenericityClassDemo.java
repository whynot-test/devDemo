package com.example.devdemo.javademo.genericity;

/**
 * @Author: bi
 * @createTime: 2024年03月12日 22:39:29
 * @version: 1.0
 * @Description: 泛型类demo
 */
public class GenericityClassDemo <T>{

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        //根据不同的需求初始化不同的类型
        GenericityClassDemo<Integer> genericityClassDemo = new GenericityClassDemo<Integer>();
        genericityClassDemo.setT(1);
        GenericityClassDemo<String> genericityClassDemoStr = new GenericityClassDemo<String>();
        genericityClassDemoStr.setT("2");


    }
}