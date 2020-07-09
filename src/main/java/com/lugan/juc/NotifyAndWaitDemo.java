package com.lugan.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//线程之间的沟通交流
//实现两个线程之间的加减一的功能--->线程操作资源类
//***********有wait的地方要用while判断可以防止虚假唤醒，因为if只是判断一次，而while是循环判断
class ShareData{
    private int i =0;
   private Lock lock = new ReentrantLock();
   private Condition condition = lock.newCondition();
  /*  public synchronized void increment() throws InterruptedException {
        while(i!=0){//while 和if的区别。while可以打印出正常的结果，if打印的结果错乱--->while可以防止虚假唤醒
            this.wait();//有wait的地方要用while判断可以防止虚假唤醒，因为if只是判断一次，而while是循环判断
        }
        ++i;
        System.out.println(Thread.currentThread().getName()+"\t"+"资源的值为"+i);
        this.notifyAll();
            }
    public synchronized void decrement() throws InterruptedException {
        while(i==0){//while 和if的区别。while可以打印出正常的结果，if打印的结果错乱--->while可以防止虚假唤醒
            this.wait();//有wait的地方要用while判断可以防止虚假唤醒，因为if只是判断一次，而while是循环判断
        }
        --i;
        System.out.println(Thread.currentThread().getName()+"\t"+"资源的值为"+i);
        this.notifyAll();
    }*/
    public  void increment() throws InterruptedException {

        try {
            lock.lock();
            while(i!=0){//while 和if的区别。while可以打印出正常的结果，if打印的结果错乱--->while可以防止虚假唤醒
                //this.wait();//有wait的地方要用while判断可以防止虚假唤醒，因为if只是判断一次，而while是循环判断
                condition.await();
            }
            ++i;
            System.out.println(Thread.currentThread().getName()+"\t"+"资源的值为"+i);
            //this.notifyAll();
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public  void decrement() throws InterruptedException {
        try {
            lock.lock();
            while(i==0){//while 和if的区别。while可以打印出正常的结果，if打印的结果错乱--->while可以防止虚假唤醒
                //this.wait();//有wait的地方要用while判断可以防止虚假唤醒，因为if只是判断一次，而while是循环判断
                condition.await();
            }
            --i;
            System.out.println(Thread.currentThread().getName()+"\t"+"资源的值为"+i);
            //this.notifyAll();
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
public class NotifyAndWaitDemo {
    public static void main(String[] args) {
        final ShareData shareData = new ShareData();
        for (int i = 0; i <10 ; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        shareData.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"A").start();
            new Thread(new Runnable() {
                public void run() {
                    try {
                        shareData.decrement();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"B").start();

        }
    }
}
