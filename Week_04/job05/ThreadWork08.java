package com.hf.job05;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport.parkNanos 超时时间
 * @author hfzhang
 * @date 2021/2/4
 */
public class ThreadWork08 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        Thread mainThread = Thread.currentThread();
        //异步执行
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                handler();
            }
        });
        t.start();
        LockSupport.parkNanos(mainThread, 100L);
        System.out.println("线程："+Thread.currentThread().getName()+" 使用时间："+(System.currentTimeMillis()-start)+"ms");
    }

    private static void handler() {
        int result = Compute.fibo(7);
        System.out.println("线程："+Thread.currentThread().getName()+" 异步计算结果："+result);
    }
}
