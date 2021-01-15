package com.hf.job01;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author hfzhang
 * @date 2021/1/13
 */
public class HelloUrlClassLoader extends ClassLoader {

    private String path;

    public HelloUrlClassLoader(String path){
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = getDate();
        if(bytes == null){
            return null;
        }
        //调整
        byte temp;
        for(int i=0;i<bytes.length;i++){
            temp = bytes[i];
            bytes[i] = (byte)(255-temp);
        }
        System.out.println(bytes);
        return defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] getDate() {
        File file = new File(path);
        if(file.exists()){
            FileInputStream inputStream = null;
            ByteArrayOutputStream outputStream = null;

            try {
                inputStream = new FileInputStream(file);
                outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int size = 0;
                while((size = inputStream.read(buffer)) != -1){
                    outputStream.write(buffer, 0, size);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return outputStream.toByteArray();
        }else{
            return null;
        }
    }

}
