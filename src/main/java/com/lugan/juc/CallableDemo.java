package com.lugan.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
//新的获取线程的方式：callable，！！！！！重要！！！！
//callable需要用futuretask接口来实现
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask(new MyThread());

        new Thread(futureTask).start();
        Integer integer = futureTask.get();
        System.out.println(integer);
    }
}
class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("插进来啦，好爽，啊啊啊");
        return 222;
    }
}
