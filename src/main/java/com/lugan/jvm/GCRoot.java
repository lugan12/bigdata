package com.lugan.jvm;
//什么可以作为GcRoot对象，1.在栈空间中被引用的对象，2.方法区静态对象，3.方法区静态常量
public class GCRoot {
//静态对象，也不能被回收掉
private static GCRootDemo02 gcRootDemo02;
//静态常量，也不能被回收
private static final GCRootDemo03 gc=new GCRootDemo03();
private static void m1(){
    GCRoot gcRoot = new GCRoot();
    System.gc();
}
    public static void main(String[] args) {
//        GCRootDemo01 gcRootDemo01 = new GCRootDemo01();
m1();

    }
}
class GCRootDemo03{
    private byte[] b=new byte[1024*1024*100];
}
class GCRootDemo02{
    //方法区的静态对象
    private byte[] b=new byte[1024*1024*100];
}
class GCRootDemo01{
    private byte[] b=new byte[1024*1024*100];
}
