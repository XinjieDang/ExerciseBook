package com.dxj.io;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 遍历文件和目录
 * 当File 对象表示一个目录时，可以使用list()和listFiles()列出目录下的文件和子目录名。
 *
 * 如果File 对象 表示一个目录，可以通过以下方法创建和删除目录
 * mkdir():创建当前File对象表示的目录
 * mkdirs():创建当前File对象表示的目录，并在必要时将不存在的父目录也创建出来
 * delete():删除当前File 对象表示的目录，当前目录必须为空才能删除成功
 *
 *
 * java 标准库提供了 path 对象
 */
public class Demo2 {
    public static void main(String[] args) {
        File f=new File("C:\\window\\admin\\Desktop");
        File[] fs1=f.listFiles();//列出所有文件和目录
        System.out.println(fs1);
        File[] fs2=f.listFiles(new FilenameFilter() {//仅列出.exe文件
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".exe");
            }
        });
        System.out.println(fs2);

        //java 标准库提供了 path 对象
        Path p1= Paths.get(".","project","study");
        System.out.println(p1);
        Path p2=p1.toAbsolutePath();//转化为绝对路径
        System.out.println(p2);
        Path p3=p2.normalize();//转化为规范路径
        System.out.println(p3);
        File f2=p3.toFile();//转化为file 对象
        System.out.println(f2);
        for (Path path:Paths.get("..").toAbsolutePath()) {
            System.out.println(""+path);

        }

    }
}
