package com.example.devdemo.javademo.reflect;

import java.lang.reflect.Field;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.devdemo.excel.service.FileDownloadService;

/**
 * @Author: bi
 * @createTime: 2024年03月12日 17:58:34
 * @version: 1.0
 * @Description:
 * 运行时动态的获取类的信息，并操作类的成员（字段、方法、构造方法）的能力
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReflectDemo01 {

    @Test
    public void test01() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String testClassPath = "com.example.devdemo.excel.service.FileDownloadService";
        Class<?> aClass = Class.forName(testClassPath);
        FileDownloadService o = (FileDownloadService)aClass.newInstance();

    }
}