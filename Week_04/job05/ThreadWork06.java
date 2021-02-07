package com.hf.job05;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 方式
 * @author hfzhang
 * @date 2021/2/4
 */
public class ThreadWork06 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        long start = System.currentTimeMillis();
        //异步执行
        new Thread(() -> {
            handler();
            latch.countDown();
        }).start();

        latch.await();
        System.out.println("线程："+Thread.currentThread().getName()+" 使用时间："+(System.currentTimeMillis()-start)+"ms");
    }

    private static void handler() {
        int result = Compute.fibo(7);
        System.out.println("线程："+Thread.currentThread().getName()+" 异步计算结果："+result);
    }

}
