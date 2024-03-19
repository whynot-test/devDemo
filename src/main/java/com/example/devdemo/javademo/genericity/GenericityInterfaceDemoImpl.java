package com.example.devdemo.javademo.genericity;

import java.util.Random;

/**
 * @Author: bi
 * @createTime: 2024年03月12日 22:47:17
 * @version: 1.0
 * @Description: 泛型接口的实现
 */
public class GenericityInterfaceDemoImpl implements GenericityIntegerDemo<Integer>{

    @Override
    public Integer getId() {
        Random random = new Random(100);
        return random.nextInt();
    }

    public static void main(String[] args) {
        //使用泛型
        GenericityInterfaceDemoImpl genericityInterface = new GenericityInterfaceDemoImpl();
        genericityInterface.getId();
    }
}