package com.dxj.Multithreading;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 使用Concurrent 集合
 * 通过 ReentrantLock和Condition 实现了一个BlockingQueue
 *
 * BlockingQueue:
 *        当一个线程调用这个TaskQueue的getTask()方法，该方法内部可能会让线程变成等待状态，直到队列条件满足不为空，
 *        线程被唤醒后，getTask()方法才会返回，因为BlockingQueue非常有用，所以我们不必自己写
 *
 *
 * 使用java.util.concurrent包提供的线程安全的并发集合可以大大简化多线程编程
 * 多线程 同时读写并发集合是安全的，尽量使用 Java标准库提供的并发集合，避免自己编写同步代码。
 */
public class Demo13 {

    public static void main(String[] args) {
        Map<String,String>map=new ConcurrentHashMap<>();
        //在不同线程读写
        map.put("A","1");
        map.put("B","2");
        map.put("A","1");
        //所有同步和加锁的逻辑都在集合内部实现，对外部调用者来说，只需要正常按接口引用
        Map<String,String> map1=new ConcurrentHashMap<>();
    }
    public class TaskQueue {
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
        public String getTask() {
            lock.lock();
            try {
                while (queue.isEmpty()) {
                    condition.await();
                }
                return queue.remove();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            return null;
        }
    }
}
