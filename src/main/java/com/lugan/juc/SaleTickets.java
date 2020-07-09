package com.lugan.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket{
    private static int num=30;
    static Lock lock = new ReentrantLock();
    public static void sale(){
            lock.lock();
        try {
            if(num>0) System.out.println(Thread.currentThread().getName()+"\t剩下："+(num--)+"张票，"+"还剩下："+num+"张票");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
public class SaleTickets {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new Thread(()->{
                for (int j = 0; j <20 ; j++) {
                    Ticket.sale();
                }
            },String.valueOf(i)).start();
        }
//            new Thread(new Runnable() {
//                public void run() {
//                    for (int j = 0; j < 30; j++) {
//                        Ticket.sale();
//                    }
//                }
//            }, String.valueOf(i)).start();
//        }
    }
}
