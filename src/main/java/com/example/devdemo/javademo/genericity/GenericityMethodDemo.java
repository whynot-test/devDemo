package com.example.devdemo.javademo.genericity;

import com.example.devdemo.javademo.anoncation.Apple;

/**
 * @Author: bi
 * @createTime: 2024年03月12日 22:28:27
 * @version: 1.0
 * @Description: 泛型demo
 */
public class GenericityMethodDemo {

    public static void main(String[] args) {
        generateMethod("1",2,new Apple());
    }

    public static <T> void generateMethod(T ... inputArray){
        for (T arg : inputArray) {
            if (arg instanceof Integer) {
                System.out.println("处理Integer类型的数据");

            }else if (arg instanceof String ) {
                System.out.println("处理String类型的数据");
            }else  {
                System.out.println("处理其他类型的数据");
            }
        }

    }
}