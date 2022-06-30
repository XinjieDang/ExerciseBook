package com.dxj.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

/**
 * 序列化
 * 把一个java对象变成二进制内容，本质上就是一个byte[]数组
 * 为什么需要序列化？
 *       序列化后可以把byte[]保存到文件中，或者把byte[] 通过网络传输到远程，这样相当于把Java对象存储到文件或者通过网络传输出去了。
 * 反序列化
 *    把一个二进制内容也就是一个byte[]数组 变成java对象
 *
 *  方式： 实现java.io.Serializable接口 这是一个空接口，没有定义任何方法，把这样的空接口称为标记接口
 *
 *  把一个java对象变成byte[]数组，需要使用ObjectOutputStream ,负责把一个Java对象写入一个字节流
 *
 *
 *
 *
 *
 *
 *  java 的序列化允许class 定义一个特殊的serialVersionUID静态变量，用于标识Java类的序列化版本，通常可以由idea生成，
 *  如果增加或修改了字段，可以改变serialVersionUID的值，这样就能自动阻止不匹配的class版本
 *  反序列化时，由jVM直接构造出对象，不调用构造方法，构造方法内步的代码，在反序列时根本不可能执行
 *
 *  安全性：
 *     因为Java的序列化机制可以导致一个实例能直接从byte[]数组创建，而不经过构造方法，因此存在一定的安全隐患，一个精心构造的byte[]数组 被
 *     反序列化后可以执行特定的代码，从而导致严重的安全漏洞
 *
 *     java 的序列化机制适用于java,如果需要与其他语言交互数据，必须使用通用的序列化方法，例如json
 *
 */
public class Demo7 implements Serializable {

    public static void main(String[] args) {
        ByteArrayOutputStream buffer=new ByteArrayOutputStream();
        try (ObjectOutputStream outputStream=new ObjectOutputStream(buffer)){
            //写入int;
            outputStream.write(12345);
            //写入String
            outputStream.writeUTF("Hello");
            //写入Object
            outputStream.writeObject(Double.valueOf(123.456));

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(buffer.toByteArray()));

    }
}
