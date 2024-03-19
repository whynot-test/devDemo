package com.example.devdemo.javademo.serializable;

import java.io.Serializable;

/**
 * @Author: bi
 * @createTime: 2024年03月12日 23:08:21
 * @version: 1.0
 * @Description: 序列化
 */
public class SerializabeDemo implements Serializable {
    //定义序列化id
    private static final long serialVersionUID = 12345667898L;

    //name属性将会被序列化
    private String name;
    //address属性不会被序列化
    private transient String address;
    //静态变量属于类信息，不属于对象的状态，因此不会被序列化
    static int age = 3;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}