package com.dxj.Multithreading;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用ReadWriteLock 适合读多写少的场景
 *
 * ReentrantLock 保证了只有一个线程可以执行临界区代码
 *   作用：
 *      1、只允许一个线程写入，其他线程既不能写入也不能读取
 *      2、没有写入时，多个线程允许同时读（提高性能)
 *
 *
 * 把读写 操作 分别用做读锁 和写锁 来加锁，在读取时，多个线程可以同时获得读锁，这样就大大 提高 了并发读的执行效率
 */
public class Demo11 {
    public static void main(String[] args) {

    }
     class Counter2 {
        private final ReadWriteLock rwlock = new ReentrantReadWriteLock();
        private final Lock rlock = rwlock.readLock();
        private final Lock wlock = rwlock.writeLock();
        private int[] counts = new int[10];

        public void inc(int index) {
            wlock.lock(); // 加写锁
            try {
                counts[index] += 1;
            } finally {
                wlock.unlock(); // 释放写锁
            }
        }

        public int[] get() {
            rlock.lock(); // 加读锁
            try {
                return Arrays.copyOf(counts, counts.length);
            } finally {
                rlock.unlock(); // 释放读锁
            }
        }
    }
}



