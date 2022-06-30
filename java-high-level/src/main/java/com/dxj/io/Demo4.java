package com.dxj.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * OutputStream是java 标准库提供最基本的输出流
 * 也是抽象类，是所有输出流的超类，这个抽象类定义的一个最重要方法是void write(int b)
 * 提供了一个flush()方法，将缓存流中的内容真正输出到目的地，通常情况下，不需要调用flush()方法，缓冲区写满 了会自动调用
 * 在某些情况下，需要手动调用
 */
public class Demo4 {

    public static void main(String[] args) throws IOException {
        //FileOutputStream 可以从文件获取输出流，这是OutputStream 常用的一个实现类，此外ByteArrayOutputStream可以在内存中模拟
       // 一个OutputStream
        byte[]data;
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            output.write("Hello ".getBytes("UTF-8"));
            output.write("world!".getBytes("UTF-8"));
            data = output.toByteArray();
        }
        System.out.println(new String(data, "UTF-8"));
    }
    /**
     * 一次性写入若干字节
     */
    public void writeFile() throws IOException {
        OutputStream outputStream=new FileOutputStream("out/readme.txt");
        outputStream.write("hello".getBytes("UTF8"));
        outputStream.close();

    }
}
