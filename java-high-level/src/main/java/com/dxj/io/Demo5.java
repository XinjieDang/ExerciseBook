package com.dxj.io;

import java.io.*;
import java.util.zip.GZIPInputStream;

/**
 * 装饰器模式
 *  无论包装多少次，得到的对象始终是InputStream
 *
 */
public class Demo5 {
    public static void main(String[] args) throws IOException {
        InputStream file=new FileInputStream("text.gz");
        InputStream buffered=new BufferedInputStream(file);
        InputStream gzip=new GZIPInputStream(buffered);
    }
}
