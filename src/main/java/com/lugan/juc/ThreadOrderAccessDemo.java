package com.lugan.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//按顺序执行线程
/**
傻逼吧你，草
 */
class ShareResource {
    private int number = 1;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void print5(int loop) {
        try {
            lock.lock();
            //判断
            while (number != 1) {
                condition1.await();
            }
            //执行逻辑
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + "loop:" + loop + "\tprint:" + i);
                //vdsfe
                //njnrje
                //nd
                //System.out.println
            }
            number = 2;
            //通知其他线程
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10(int loop) {
        try {
            lock.lock();
            //判断
            while (number != 2) {
                condition2.await();
            }
            for (int i = 0; i < 10; i++) {
                //执行逻辑
                System.out.println(Thread.currentThread().getName() + "\t" + "loop:" + loop + "\tprint:" + i);
            }
            number = 3;
            //通知其他线程
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15(int loop) {
        try {
            lock.lock();
            //判断
            while (number!=3){
                condition3.await();
            }
            //执行逻辑
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+"loop:"+loop+"\tprint:"+i);
            }
            //通知其他线程
            number=1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ThreadOrderAccessDemo {
    public static void main(String[] args) {
        final ShareResource shareResource = new ShareResource();
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i <5 ; i++) {
                    shareResource.print5(i);
                }
            }
        },"A").start();
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i <5 ; i++) {
                    shareResource.print10(i);
                }
            }
        },"B").start();
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i <5 ; i++) {
                    shareResource.print15(i);
                }
            }
        }, "C").start();
    }
}
