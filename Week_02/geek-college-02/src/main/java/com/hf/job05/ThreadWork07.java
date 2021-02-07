package com.hf.job05;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport.park和unpark方式
 * @author hfzhang
 * @date 2021/2/4
 */
public class ThreadWork07 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        Thread mainThread = Thread.currentThread();
        //异步执行
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                handler(mainThread);
            }
        });
        t.start();
        LockSupport.park(mainThread);
        System.out.println("线程："+Thread.currentThread().getName()+" 使用时间："+(System.currentTimeMillis()-start)+"ms");
    }

    private static void handler(Thread mainThread) {
        int result = Compute.fibo(7);
        System.out.println("线程："+Thread.currentThread().getName()+" 异步计算结果："+result);
        LockSupport.unpark(mainThread);
    }
}
