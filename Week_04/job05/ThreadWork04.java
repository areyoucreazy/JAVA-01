package com.hf.job05;

/**
 * wait+notify+synchronized
 * @author hfzhang
 * @date 2021/2/3
 */
public class ThreadWork04 {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Object obj = new Object();
        MyThread myThread = new MyThread(obj);
        myThread.start();
        synchronized (obj){
            obj.wait();
        }
        System.out.println("线程："+Thread.currentThread().getName()+" 使用时间："+(System.currentTimeMillis()-start)+"ms");
    }

    private static class MyThread extends Thread{
        Object obj;
        public MyThread(Object obj){
            this.obj = obj;
        }

        @Override
        public void run(){
            int result = Compute.fibo(7);
            System.out.println("线程："+Thread.currentThread().getName()+" 异步计算结果："+result);
            synchronized (obj) {
                obj.notify();
            }
        }

    }

}
