package com.dxj.Multithreading;

/**
 * 创建新线程
 * 当Java 程序启动的时候，实际上是启动了一个Jvm进程，然后JVM启动主线程来执行maain()方法，在main()方法中我们又可以启动其他线程。
 * 创建一个新线程
 * 实例化一个 Thread实例，然后调用start()方法
 */
public class Demo1 {
    public static void main(String[] args) {
        Thread t=new MyThread();
        //方法一
        t.start();//启动新线程 start方法会在内部自动调用实例的run()方法
        //方法二 创建Thread实例，传入一个Runnable 实例
        Thread t2=new Thread(new MyRunnable());
        t2.start();

        //java 8 lambda语法
        Thread t3=new Thread(()->{
            System.out.println("start new Thread");
        });
        t3.start();

    }
    //希望新线程执行指定的代码,从Thread 派生一个自定义类，重写run 方法
}
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("start new thread");
    }
}
class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Runaable Thread");
    }
}