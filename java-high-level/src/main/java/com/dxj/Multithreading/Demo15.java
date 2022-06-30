package com.dxj.Multithreading;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *把多个任务让一组线程来执行，而不是一个任务对应一个线程，这种能接收大量小任务并发处理 的就是线程池，
 * 线程内部维护了若干个线程，没有任务的时候，这些线程都处于等待状态，如果有新任务，就分配一个空闲线程执行，如果所有线程都处于忙碌状态，新任务要么放入队列等待
 * 要么增加一个新线程进行处理。
 * Java标准库提供了ExecutorService 接口表示线程池；
 *     FixedThreadPool：线程数固定的线程池；
 *     CachedThreadPool：线程数根据任务动态调整的线程池；
 *     SingleThreadExecutor：仅单线程执行的线程池。
 *
 *
 *
 *ScheduledThreadPool：任务本身固定，需要反复执行
 *
 */
public class Demo15 {
    public void main(String[] args) {
        // 创建固定大小的线程池:
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int i=0;i<6;i++){
            //提交6个任务
            executor.submit(new Task(""+i));
        }
        // 关闭线程池，会等待 正在执行的任务先完成，再关闭
        executor.shutdown();

        //还有一种任务，需要定期反复执行,放入ScheduledThreadPool的任务可以定期反复执行。
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);

        // 2秒后开始执行定时任务，每3秒执行:
        ses.scheduleAtFixedRate(new Task("fixed-rate"), 2, 3, TimeUnit.SECONDS);

        // 1秒后执行一次性任务:
        ses.schedule(new Task("one-time"), 1, TimeUnit.SECONDS);
    }
    class Task implements Runnable {
        private final String name;
        public Task(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            System.out.println("start task " + name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("end task " + name);
        }
    }
    /**
     * JDK 提供了 ExecutorService 实现了线程池功能
     * 线程池内部维护 一组线程，可以高效执行大量小任务
     * Executors 提供了静态方法创建不同类型的ExecutorService
     * 必须调用shutdown()关闭 ExecutorService;
     * ScheduledThreadPool 可以定期调度多个任务。
     */
}
