package com.dxj.io;

import java.io.File;
import java.io.IOException;

/**
 * file 对象
 * window 平台使用\ 作为路径分隔符，在java字符串中需要使用\\ 表示一个\,linux 平台 使用/ 作为路径分隔符
 *
 * file 对象即可表示文件，也可表示目录
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
        //构造file 对象，可以传入绝对路径，也可传入相对路径。绝对路径是以根目录开头的完整路径，
        File  f=new File("C:\\Users\\admin\\Desktop\\新建文本文档.txt");
        System.out.println(f);
        //window 和Linux的路径分隔不同，File对象由一个静态变量用于表示当前平台的系统分隔符
        System.out.println(File.separator);//根据当前平台打印"\"或"/"

        //调用isFile()，判断该File对象是否是一个已存在的文件，调用isDirectory()，判断该File对象是否是一个已存在的目录
        File f1=new File("C:\\windows");
        File f2=new File("\\windows\\notepad.exe");
        File f3 = new File("C:\\Windows\\nothing");
        System.out.println(f1.isFile());
        System.out.println(f2.isDirectory());
        //临时读取文件
        File f4=File.createTempFile("tmp-",".text");//提供临时文件的前缀和后缀
        f.deleteOnExit();//jvm退出时自动删除
        System.out.println(f.isFile());
        System.out.println(f.getAbsolutePath());

    }
}
