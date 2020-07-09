package com.lugan.jvm;
//JAVa 内存模型   volatile-->可见性

class ChangeValue{
   volatile int number=10;
    public void addNumber(){
        this.number=100;
    }
}


public class JMM {
    //java 内存模型中有多个线程，当一个线程修改其中的jvm中值的时候，通过volatile通知其他线程去jvm中更新修改后的值
   /* ！！！！重要！！！  流程分析：首先两个线程 t1和main同时创建,创建ChangeValue对象之后到jvm堆中拿到number值两个线程都为10
   之后由于在t1线程中在3秒之后才调用方法addNumber()将number值改为了100，jvm内存中要通知main去jvm中修改值，而volatile关键值可以在
   一个线程修改好值之后jvm将会通知其他的线程到jvm中及时更新刚刚修改过的值。
    */


    public static void main(String[] args) {
        final ChangeValue changeValue = new ChangeValue();
        new Thread(new Runnable() {
             public void run() {
                 System.out.println("****** come in");
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 changeValue.addNumber();
                 System.out.println("修改后的值为："+changeValue.number);
             }
         },"aaa").start();
        while (changeValue.number==10){

        }
        System.out.println("另外一个线程已经拿到线程，值为："+changeValue.number);
    }
}
