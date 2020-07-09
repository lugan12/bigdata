package com.lugan.jvm;

import java.lang.ref.WeakReference;

public class WeakRefereceDemo {
    public static void main(String[] args) {
        Object o = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o);
        System.out.println("1:"+o);
        System.out.println("2:"+weakReference);
        o=null;
//        System.gc();
        try {
            byte[] bytes = new byte[100 * 1024 * 1024];
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("3:"+o);
            System.out.println("4:"+weakReference);
        }
    }
}
