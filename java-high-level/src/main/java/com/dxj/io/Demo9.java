package com.dxj.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

/**
 * Reader 是java的Io库提供的另一个输入流接口，和InputStream的区别是，InputStream是一个字节流，即以byte为单位读取，而Reader
 * 是一个字符流，即以char 为单位读取
 *
 * FileReader 是Reader的一个子类，它可以打开文件并获取Reader，下面的代码演示了如何完整的读取一个FileReader的所有字符
 */
//public class Demo9 {
//    public void readFile() throws IOException {
//       // Reader reader=new FileReader("src/readme.txt");
//        //避免乱码 创建FileResder时指定编码
//      //  Reader reader = new FileReader("src/readme.txt", StandardCharsets.UTF_8);
////        for (;;){
////            int n=reader.read();//反复调用read 方法，直到返回-1
////            if(n==-1){
////                break;
////            }
////            System.out.println((char) n);//打印char
////        }
////        reader.close();//关闭流
////    }
//}
