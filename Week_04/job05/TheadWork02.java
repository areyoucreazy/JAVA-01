package com.hf.job05;

/**
 * @author hfzhang
 * @date 2021/2/2
 */
public class TheadWork02 {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.join();
        System.out.println("使用时间："+(System.currentTimeMillis()-start)+"ms");
    }

    private static class MyThread extends Thread{

        @Override
        public void run(){
            int result = Compute.fibo(7);
            System.out.println("异步计算结果："+result);
        }
    }
}
