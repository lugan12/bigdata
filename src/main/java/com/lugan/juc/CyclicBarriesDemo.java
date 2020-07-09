package com.lugan.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//让指定几个线程执行完成之后再集中做，某件事
/*
不对，不是这样子的
*/
public class CyclicBarriesDemo {
    private static final int number=7;
    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(number, new Runnable() {
            public void run() {
                //执行具体的业务代码
                System.out.println("人已经到齐，开会啦！！！！");
            }
        });
        for (int i = 0; i <number ; i++) {
            final int tempTheadNum=i;
            new Thread(new Runnable() {
                public void run() {
                    try {
                        //执行具体的业务代码
                        System.out.println("第"+tempTheadNum+"个小伙伴到位");
                        //cyclicBarrier.await方法先堵塞住防止执行上面的开会逻辑
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            },String.valueOf(i)).start();
        }
    }
}
