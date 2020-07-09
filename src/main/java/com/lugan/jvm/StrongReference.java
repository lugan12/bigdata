package com.lugan.jvm;

public class StrongReference {
    public static void main(String[] args) {
        Object o1 = new Object();//这种方法产生的对象为强引用
        Object o2=o1;//o1,o2两个对象均指向Object
        o1=null;//o1虽然不指向了Object对象，但是o2还指向Object对象，只要有有一个对象指向，gc后也不会被回收
        System.gc();
        System.out.println(o2);//gc之后o2也没有被回收
    }
}
