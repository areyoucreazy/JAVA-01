package com.hf.job05;

/**
 * * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 *  * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 *  * 写出你的方法，越多越好，提交到github。
 *  线程睡眠的方式
 * @author hfzhang
 * @date 2021/2/2
 */
public class TheadWork01 {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        //异步执行
        new Thread(() -> {
            int result = Compute.fibo(7);
            System.out.println("异步计算结果："+result);
        }).start();
        Thread.sleep(10000);
        System.out.println("使用时间："+(System.currentTimeMillis()-start)+"ms");
    }
}
