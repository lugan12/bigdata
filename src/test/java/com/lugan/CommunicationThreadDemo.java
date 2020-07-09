package com.lugan;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//多个线程之间的通信
public class CommunicationThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 创建多个线程同时执行该对象
         */
        ShareData shareData = new ShareData();
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                try {
                    shareData.decreasement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"a").start();
            new Thread(()->{
                try {
                    shareData.increacement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"b").start();
        }
    }
}
class ShareData{
    private int signal =90;
    private Lock lock=new ReentrantLock();
    private Condition condition =lock.newCondition();
    public void increacement() throws InterruptedException {
       try {
           lock.lock();
           while (signal==0){
               condition.await();
           }
           --signal;
           System.out.println(Thread.currentThread().getName()+"\t"+"资源的值为"+signal);
           condition.signalAll();
       }catch (Exception e){e.printStackTrace();}finally {
           lock.unlock();
       }

    }
    public void decreasement() throws InterruptedException {
       try {
           lock.lock();
           while (signal!=0){
               condition.await();
           }
           ++signal;
           System.out.println(Thread.currentThread().getName()+"\t"+"资源的值为"+signal);
           condition.signalAll();
       }catch (Exception e){e.printStackTrace();}finally {
           lock.unlock();
       }
    }
}
