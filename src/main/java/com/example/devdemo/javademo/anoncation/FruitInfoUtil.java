package com.example.devdemo.javademo.anoncation;

import java.lang.reflect.Field;

/**
 * @Author: bi
 * @createTime: 2024年03月12日 21:23:51
 * @version: 1.0
 * @Description: 定义一个注解处理器
 */
public class FruitInfoUtil {

    public static void getFruitInfo(Class<?> clazz){
        String strFruitProvider = "供应商信息==";
        //通过反射获取处理注解
        Field[] fileds = clazz.getDeclaredFields();
        for (Field filed:fileds){
            FruitProvider fruitProvider = filed.getAnnotation(FruitProvider.class);
            //处理注解信息
            strFruitProvider = "供应商编号："+fruitProvider.id()+"供应商名称："+fruitProvider.name() + "供应商地址："+fruitProvider.address();
            System.out.println(strFruitProvider);
        }
    }

}