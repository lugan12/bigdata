package com.lugan;

import java.util.concurrent.CountDownLatch;

//关门打狗例子，即先让屋内的其他6个人先走，自己最后一个走
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        //先设置6个线程跑
        for (int i = 0; i <6 ; i++) {
            int tempInt = i;
            new Thread(()->{countDownLatch.countDown();
                System.out.println("第"+ tempInt +"个人走");
            },String.valueOf(i)).start();
        }
        //设置领导关门走人
        countDownLatch.await();
        System.out.println("！！！note:--->>>>>领导最后走人");
    }
}
