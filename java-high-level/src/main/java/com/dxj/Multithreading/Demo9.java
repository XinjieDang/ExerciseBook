package com.dxj.Multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
使用 ReentrantLock
从 java5开始，引入一个高级的处理并发java.util.concurrent包，它提供了大量更高级的并发功能，能大大简化多线程程序的编写
 */
public class Demo9 {
}
//public class Counter {
//
//    //ReentrantLock 是可重入锁，它和synchronized 一样，一个线程可以多次获取同一个锁。
//   // 使用ReentrantLock比直接使用synchronized更安全，线程在tryLock()失败的时候不会导致死锁。
//    private final Lock lock = new ReentrantLock();
//    private int count;
//
//    public void add(int n) {
//        lock.lock();
//        try {
//            count += n;
//        } finally {
//            lock.unlock();
//        }
//    }
//}