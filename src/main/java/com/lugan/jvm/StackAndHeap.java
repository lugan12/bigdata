package com.lugan.jvm;
//八种基本变量类型+对象的引用类型+实例方法都是在函数的栈内存中分配
/*
栈管运行，堆管存贮
栈保存的东西：八种基本变量类型+对象的引用类型+实例方法都是在函数的栈内存中分配
java的方法叫栈祯
Exception in thread "main" java.lang.StackOverflowError  ---SOF
 */
public class StackAndHeap {
    public int add(int i,int y){//方法在栈中分配
        int result=-1;//八种基本变量在栈中分配
        result= i+y;//对象引用类型在栈中分配
        Object o = new Object();//实例对象在栈中分配
        return result;
    }
     //递归引用
    public static void m1(){
        m1();
    }
    public static void main(String[] args) {
        System.out.println("11111");
        m1();
        System.out.println("33333");
    }
}
