package com.dxj.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取classpath资源
 * 获取当前class 对象，调用getResourceAsStream()可以从classpath读取任意的资源文件
 */
public class Demo6 {
    public void getResourceStream() throws IOException {
        try (InputStream input = getClass().getResourceAsStream("/default.properties")) {
            if (input != null) {
                // TODO:
            }
        }
        //把默认的配置文件放到jar 包中，再从外部文件系统读取一个可选的配置文件
        Properties props=new Properties();
//        props.load(inputStreamFromClassPath("/default.properties"));
//        props.load(inputStreamFromFile("./conf.properties"));
    }

}
