package com.lugan.juc;

import java.util.concurrent.CountDownLatch;

//关门例子，等所有另外的指定线程走完后再执行最后一个固定的线程
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //先设置6个线程先跑
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i <6 ; i++) {
            final int tempInt=i;
            final CountDownLatch tempCountDownLatch=countDownLatch;
        new Thread(new Runnable() {
            public void run() {
                System.out.println("第\t"+tempInt+"个同学走出教室了");
                tempCountDownLatch.countDown();
            }
        },String.valueOf(i)).start();
        }
        countDownLatch.await();
        //最后走的线程，不一定是主线程
        System.out.println("领导关门走人");
    }
}
