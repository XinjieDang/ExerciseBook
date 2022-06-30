package com.dxj.Multithreading;

/**
 *使用 ThreadLocal
 * 多线程是Java 实现多任务的基础，Thread对象代表一个线程，可以在代码中调用Thread.currentThread()获取当前线程
 * 对于多任务，java 提供的线程池可以方便的执行这些任务，同时复用线程
 *
 * 如何在线程中传递状态？
 *  在一个线程中，横跨若干个方法调用，需要传递的对象，称为上下问context，它是一种状态，可以是用户身份，任务信息等
 *  java提供了一个特殊的ThreadLocal，它可以在一个线程中传递同一个对象
 *
 *  可以把ThreadLocal 看成一个全局Map<Thread.currentThread());，每个线程获取ThreadLocal变量时，总是使用Thread自身作为key\
 *
 *  Object threadLocalValue=threadLocalMap.get(Thread.currentThread());因此，ThreadLocal相当于给每个线程 都开辟了一个独立的存储空间，
 *  各个线程的ThreadLocal关联的实例互不干扰，特别注意ThreadLocal一定要在finally中清除，是因为当前线程执行完相关代码后，很可能会被重新放入线程池中，
 *  如果ThreadLocal 没有被清除，该线程执行其他代码时，会把上一次的状态带进去
 */
public class Demo19 {
    public static void main(String[] args) throws Exception {
        log("start main...");
        new Thread(() -> {
            log("run task...");
        }).start();
        new Thread(() -> {
            log("print...");
        }).start();
        log("end main.");
    }

    static void log(String s) {
        System.out.println(Thread.currentThread().getName() + ": " + s);
    }
}

