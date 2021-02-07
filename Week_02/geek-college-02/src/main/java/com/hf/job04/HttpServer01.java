package com.hf.job04;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 单线程
 * @author hfzhang
 * @date 2021/1/17
 */
public class HttpServer01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8801);
        System.out.println(Runtime.getRuntime().availableProcessors());
        while(true){
            try {
                Socket socket = serverSocket.accept();
                service(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void service(Socket socket){
        try {
            //模拟业务操作，20ms
//            Thread.sleep(20);
            lockTest();
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            printWriter.println("Connection:keep-alive");
            String body = "Hello nio hfzhang";
            printWriter.println("Content-length:"+body.getBytes().length);
            printWriter.println();
            printWriter.write(body);
            printWriter.close();
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }

    private static Lock lock = new ReentrantLock(true);
    private static int a = 0;
    private static void lockTest() {
        try {
            lock.lock();
//            System.out.println("锁住了："+Thread.currentThread().getName());
            System.out.println("结果："+a);
            for(int i=0;i<10;i++){
                a++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
