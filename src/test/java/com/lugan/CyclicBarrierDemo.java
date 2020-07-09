package com.lugan;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//先设置几个线程执行完之后，在执行cyclicbarrier线程
import java.io.Serializable;
public class CyclicBarrierDemo {
    private static final int number=9;
    public static void main(String[] args) {
       //创建cyclicBarrier对象
        CyclicBarrier cyclicBarrier = new CyclicBarrier(number, new Runnable() {
            @Override
            public void run() {
                //等待下面几个线程执行完之后再来执行这个线程
                System.out.println("所有人就位，到会人数:"+number+"人。正式开会啦！！！");
            }
        });
        //创建多个线程，并用cyclicBarrier.await()卡住
        for (int i = 0; i <number ; i++) {//循环个数要与上面设置的number个数要一致
            int temp = i;
            new Thread(()->{
                try {
                    //处理业务逻辑
                    System.out.println("第"+ temp +"个人报道");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
