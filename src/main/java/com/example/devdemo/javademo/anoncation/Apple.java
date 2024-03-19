package com.example.devdemo.javademo.anoncation;

/**
 * @Author: bi
 * @createTime: 2024年03月12日 21:19:24
 * @version: 1.0
 * @Description: 使用注解接口
 */
public class Apple {
    //2.使用注解:通过注解的方式定义水果供应商
    @FruitProvider(id=1,name = "陕西红富士",address = "陕西省")
    private String  appleProvoder;

    public void voidsetAppleProvider(String appleProvider){
        this.appleProvoder = appleProvider;
    }
    public String getAppleProvider(){
        return appleProvoder;
    }
}