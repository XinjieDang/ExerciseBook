package com.dxj.Multithreading;

/**
 * java程序中，一个线程对象只能调用一次start()方法启动新线程，并在新线程中执行run()方法，一旦run()方法执行完毕，线程就结束了
 * java线程状态有以下几种
 *  new:新创建的线程，尚未运行。
 *  Runnable:运行中的线程，正在执行run()方法的java代码
 *  Blocked:运行中的线程，因为某些操作被阻塞而挂起。
 *  Waiting:运行中的线程，因为某些操作在等待中。
 *  Timed Waiting :运行中的线程，因为执行sleep()方法正在计时等待。
 *  Terminated:线程已终止，因为run()方法执行完毕。
 *
 *  线程终止的原因：
 *      run()方法执行到return 语句的返回。
 *      线程意外终止：run()方法因为尚未捕获的异常导致线程终止
 *      对某个线程的Thread 实例调用stop()方法强制终止。
 *      一个线程还可以等待另一个线程，直到其运行结束。
 */
public class Demo2 {

    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(()->{
            System.out.println("hello");
        });
        System.out.println("start");
        t.start();
        t.join();//join 等待t线程结束后再继续运行。
        System.out.println("end");
    }
}
