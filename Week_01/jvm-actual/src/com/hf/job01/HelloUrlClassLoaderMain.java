package com.hf.job01;

import java.lang.reflect.Method;

/**
 * @author hfzhang
 * @date 2021/1/13
 */
public class HelloUrlClassLoaderMain {
    public static void main(String[] args) throws Exception {
        String path = System.getProperty("user.dir");
        String appPath = path + "\\jvm-actual\\src\\Hello.xlass";
        HelloUrlClassLoader helloUrlClassLoader = new HelloUrlClassLoader(appPath);
        Class<?> srcClass = helloUrlClassLoader.loadClass("Hello");
        Method hello = srcClass.getDeclaredMethod("hello");
        hello.invoke(srcClass.newInstance());
    }
}
