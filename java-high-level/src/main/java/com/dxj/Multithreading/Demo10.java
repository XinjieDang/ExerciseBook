package com.dxj.Multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用 Condition
 *
 *
 * 使用ReentrantLock  比直接使用synchronized 更安全，可以替代synchronized 进行线程同步
 * synchronized 可配合 wait 和notify  实现线程在条件不满足时等待，条件满足时唤醒
 * 使用ReentrantLock 可使用Condition 对象 实现wait 和notify
 *
 * Condition提供的await()、signal()、signalAll()原理和synchronized锁对象的wait()、notify()、notifyAll()是一致的，并且其行为也是一样的：
 */
public class Demo10 {
}
class TaskQueue2 {


    /**
     * await()会释放当前锁，进入等待状态
     * Signal()会唤醒某个等待线程
     * SignalAll()会唤醒所有等待线程
     * 唤醒线程从await()返回后需要重新获得锁
     */






    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Queue<String> queue = new LinkedList<>();

    public void addTask(String s) {
        lock.lock();
        try {
            queue.add(s);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String getTask() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();
            }
            return queue.remove();
        } finally {
            lock.unlock();
        }
    }
}