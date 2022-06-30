package com.dxj.Multithreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 使用Atomic
 * java的java.util.concurrent包除了提供底层锁，并发集合外，还提供了一组原子操作的封装类，它们位于 java.util.concurrent.atomic包
 *
 * 以AtomicInteger为例，它提供的主要操作有
 *     增加值并返回新值：int addAndGet(int delta)
 *     加一后返回新值： int incrementAndGet()
 *     获取当前值：int get()
 *     用CAS方式设置：int compareAndSet(int expect, int update)
 *
 *     Atomic类是通过无锁（lock-free）的方式实现的线程安全（thread-safe）访问。它的主要原理是利用了CAS：Compare and Set。
 */
public class Demo14 {

    public int incrementAndGet(AtomicInteger var) {
        int prev, next;
        do {
            prev = var.get();
            next = prev + 1;
        } while ( ! var.compareAndSet(prev, next));
        return next;
    }

    /**
     * 全局唯一Id 生成器
     */
    class IdGenerator {
        AtomicLong var = new AtomicLong(0);

        public long getNextId() {
            return var.incrementAndGet();
        }
    }
}
