package com.lugan.jvm;

import com.lugan.entity.Person;
//jvm的栈的理解--main方法的先进后出等
public class TransferValue {
    public void transfer1(int value){
        value=30;
    }
    public void transfer2(Person person){
        person.setName("xxxx");
    }
    public void transfer3(String s){
        s="zzzz";
    }

    public static void main(String[] args) {
        TransferValue transferValue = new TransferValue();
        int age=20;
        transferValue.transfer1(age);//基本类型传值不变
        System.out.println("age--"+age);
        Person person = new Person("abc");//栈结构： 栈（等号左边是栈指针）=堆（等号右边是堆空间）有不同的栈指针修改同一块堆空间，因此值有变化
        transferValue.transfer2(person);
        System.out.println("person---"+person.getName());
        String s="yyy";//引用类型，String的不可修改性，在堆空间创建了两块空间：“yyy”，“zzzz”,最后打印指向源；原来的空间
        transferValue.transfer3(s);
        System.out.println(s);
    }
}
