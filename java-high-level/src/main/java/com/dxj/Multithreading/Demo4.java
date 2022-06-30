package com.dxj.Multithreading;

import java.beans.AppletInitializer;

/**
 * 守护线程
 * java 程序入口就是用jvm 启动main线程，main线程又可以启动其他线程,当所有线程都运行结束时，jvm退出进程结束，
 * 如果有一个线程没有退出，jvm进程就不会退出，所以，必须保证所有线程都能及时结束。
 * 有一个线程的目的就是无限循环：====》 一个定时触发任务的线程
 *
 * 当其他线程结束时，jvm 进程又必须要结束，怎么办？使用守护线程
 * 守护线程是为其他线程服务的线程，在JVM 中，所有非守护线程都执行完毕后，无论有没有守护线程，虚拟机都会自动退出，因此当JVM 退出时
 * 不必关心守护线程是否已结束。
 * 创建守护线程
 *      在调用start()方法前，调用setDaemon(true)把该线程标记为守护线程；
 *
 *      注意：守护线程 不能持有任何需要关闭的资源，例如打开文件 因为虚拟机退出时，守护线程没有任何机会来关闭文件，这会导致数据丢失。
 */
public class Demo4 {
    public static void main(String[] args) {
        Thread t1=new HelloThreadShouhu();
        //创建守护线程
        t1.setDaemon(true);
        t1.start();

    }
}
class HelloThreadShouhu extends Thread{
    @Override
    public void run() {
        System.out.println("守护线程");
    }
}
