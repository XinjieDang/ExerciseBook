package com.dxj.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * InputStream java标准库提供的最基本的输入流，位于Java.io 这个包里，Java.io包提供了 所有同步IO的功能
 * InputStream 并不是一个接口，而是一个抽象类，是所有输入流的超类，抽象类最重要的方法是int read(),这个方法读取
 * 输入流的下一个字节，并返回字节表示的int 值（0-255）,如果已读到末尾，返回-1表示不能继续读取了
 *
 * 所有与io操作相关的代码都必须正确处理IOException
 */
public class Demo3 {

    public void readFile() throws IOException {
        InputStream inputStream=new FileInputStream("src/readme.txt");
        for (;;){
            int n=inputStream.read();//反复调用read()方法，直到返回-1
            if(n==-1){
                break;
            }
            System.out.println(n);
        }
        inputStream.close();//关闭流

        //利用缓冲区一次读取多个字节的代码
        InputStream input=new FileInputStream("src/readme.txt");
        byte[]buffer=new byte[1000];
        int n;
        while ((n=input.read(buffer))!=-1){//读取到缓冲区
            System.out.println("read"+n+"bytes");
        }
        int n1;
        n=input.read();//必须等待read()方法返回才能执行下一行代码
        int m=n;
    }
}
