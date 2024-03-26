package com.example.devdemo.ehcache.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.devdemo.ehcache.entity.Person;

/**
 * @Author: bi
 * @createTime: 2024年03月20日 11:28:48
 * @version: 1.0
 * @Description:
 */
@Service
public class PersonService {

    @Cacheable(cacheNames = "person",key = "#id")
    public Person getPerson(String id){
        Person person = new Person(id,"zhandan","zhandan@qq.com");
        return person;
    }
}