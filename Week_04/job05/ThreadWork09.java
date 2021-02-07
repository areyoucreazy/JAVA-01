package com.hf.job05;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport.parkUntil 截止到某时间点释放方式
 * @author hfzhang
 * @date 2021/2/4
 */
public class ThreadWork09 {

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
        LockSupport.parkUntil(mainThread, System.currentTimeMillis()+1000);
        System.out.println("线程："+Thread.currentThread().getName()+" 使用时间："+(System.currentTimeMillis()-start)+"ms");
    }

    private static void handler() {
        int result = Compute.fibo(7);
        System.out.println("线程："+Thread.currentThread().getName()+" 异步计算结果："+result);
    }

}
