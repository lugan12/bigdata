package com.lugan.jvm;

import java.lang.ref.SoftReference;
//够用就不回收，不够用才回收
public class SoftReferenceDemo {
    public static void main(String[] args) {
        Object o = new Object();
        SoftReference<Object> reference = new SoftReference<>(o);
        System.out.println("1:"+o);
        System.out.println("2:"+reference.get());
        o=null;
        System.gc();
        try {
//            byte[] bytes = new byte[100 * 1024 * 1024];
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("3:"+o);
            System.out.println("4:"+reference.get());
        }

    }
}
