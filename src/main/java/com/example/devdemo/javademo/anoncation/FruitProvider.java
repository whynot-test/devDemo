/**
 * @projectName devDemo
 * @package com.example.devdemo.javademo.anoncation
 * @className com.example.devdemo.javademo.anoncation.FruitProvide
 * @copyright Copyright 2024 Thunisoft, Inc All rights reserved.
 */
package com.example.devdemo.javademo.anoncation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * FruitProvide
 * @description
 * @author Administrator
 * @date 2024/3/12 21:14
 * @version 定义一个注解接口
 */

/**
 * @Target：注解所修饰的对象范围
 * @Retention:注解被保留的级别：即注解在什么级别是有效的
 * @Document: 注解应该被Javadoc工具记录
 * @Inherited: 是一个标记注解：表明某个被标注的类型是被继承的
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    //供应商编号
    public int id() default -1;

    //供应商名称
    public String name() default "";

    //供应商地址
    public String address() default "";

}