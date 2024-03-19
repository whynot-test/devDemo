package com.example.devdemo.javademo.innerclass;

/**
 * @Author: bi
 * @createTime: 2024年03月12日 21:53:52
 * @version: 1.0
 * @Description: 静态内部类
 */

/**
 * 静态内部类：定义在类内部的静态类
 * 成员内部类：定义在类内部非静态的类
 * 局部内部类：定义在类中方法中的类
 * 匿名内部类：通过继承一个父类或实现一个接口的方法，直接定义并使用得类
 */
public class OuterClass {

    private static final String  calssName = "staticInnerClass";

    private static int a;

    private int b;

    //定一个静态内部类
    public static class StaticInnerClass {
        public void getClassName(){
            System.out.println("ClassName:"+calssName);
        }
    }

    //定义一个成员内部内
    public class MemberInnerClass{
        public void print() {
            System.out.println("调用成员内部类...."+a);
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        //调用静态内部类
        OuterClass.StaticInnerClass staticInnerClass = new OuterClass.StaticInnerClass();
        staticInnerClass.getClassName();
        System.out.println("\n");


    }
}