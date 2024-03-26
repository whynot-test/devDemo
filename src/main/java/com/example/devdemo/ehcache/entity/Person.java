package com.example.devdemo.ehcache.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: bi
 * @createTime: 2024年03月20日 11:25:38
 * @version: 1.0
 * @Description: 用户测试缓存的实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    private String id;

    private String name;

    private String email;
}