package com.lugan.juc;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

//6辆车抢三个车位
public class SemaphoreDemo {
    //创建三个车位
    private static final Semaphore semaphore= new Semaphore(3);
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            final int temp=i;

            new Thread(new Runnable() {
                public void run() {
                    try {
                        //获得资源
                        semaphore.acquire();
                        //执行逻辑
                        System.out.println("第"+temp+"辆车获得车位");
                        TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                        System.out.println("离开");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        //释放资源
                        semaphore.release();
                    }
                }
            },String.valueOf(i)).start();
        }
    }
}
