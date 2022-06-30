package com.dxj.Multithreading;

/**
 * 死锁
 *
 * java 的线程锁是可重入的锁，对同一个线程，能否在获取到锁以后继续获取同一个锁？
 * JVM 允许同一个线程重复获取同一个锁，这种能被同一个线程反复获取的锁，就叫做可重入锁。
 *
 * 描述：
 *    两个线程各自持有不同的锁，然后各自试图获取对方手里的锁，造成了双方无限等待下去
 * 避免死锁：
 *     线程获取锁的顺序要一致
 */
public class Demo7 {
    public static void main(String[] args) {

    }
}

/**
 * 对于同一个线程，能否在获取到锁以后继续获取同一个锁？
 * JVM 允许同一个线程重复获取同一个锁，这种能被同一个线程反复获取的锁，就叫做可重入锁
 *  获取锁的时候，不但要判断是否是第一次获取，还要记录这是第几次获取，每获取一次锁，记录加一，每退出synchronized块，记录-1,减到0的时候才
 *  会真正释放锁。
 */
 class Counter3 {
    private int count = 0;
    private int value=0;
    private int another=0;
    public static final Object lockA = new Object();
    public static final Object lockB = new Object();

//    public synchronized void add(int n) {
//        if (n < 0) {
//            dec(-n);
//        } else {
//            count += n;
//        }
//    }

    public synchronized void dec(int n) {
        count += n;
    }

    public void add(int m) {
        synchronized(lockA) { // 获得lockA的锁
            this.value += m;
            synchronized(lockB) { // 获得lockB的锁
                this.another += m;
            } // 释放lockB的锁
        } // 释放lockA的锁
    }
}
