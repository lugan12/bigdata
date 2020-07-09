package com.lugan.jvm;

import java.util.Random;
import java.util.UUID;

//区分jvm的三大classLaoder
public class MyObject {
    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println(processors);
        Object o = new Object();
        System.out.println(o.getClass().getClassLoader());//获取实例化对象的类加载器，Boostrap为最高级，打印为null
        //System.out.println(o.getClass().getClassLoader().getParent());//获取boostrap的父类汇报错
        MyObject myObject = new MyObject();
        System.out.println(myObject.getClass().getClassLoader());//获取appclassloader
        System.out.println(myObject.getClass().getClassLoader().getParent());//获取appclassloader的父类--extclassloader
        System.out.println(myObject.getClass().getClassLoader().getParent().getParent());//获取extclassloader的父类--boostrap--打印为null
    String s="lugan";
    while (true){
        String string = UUID.randomUUID().toString();
        s=s+string;
    }
    }

}
