package com.dxj.Multithreading;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用 wait 和 notify
 *
 * java程序中，synchronized 解决了 多线程竞争的问题，对于同一个任务管理器，多个线程同时往队列中添加任务，可用 synchronized 加锁,synchronized没有解决多线程协调问题。
 *
 * 多线程协调：
 * 当条件 不满足时，线程进入等待状态，当条件满足时，线程被唤醒，继续执行任务。
 *  当一个线程在this.wait 等待时，它就会释放this锁，从而使得其他线程能够在addTash()方法获得this 锁，
 *  让等待的线程被唤醒在相同的锁对象上调用 notify()方法
 */
public class Demo8 {
    public static void main(String[] args) {

//        var q = new TaskQueue();
//        var ts = new ArrayList<Thread>();
//        for (int i=0; i<5; i++) {
//            var t = new Thread() {
//                public void run() {
//                    // 执行task:
//                    while (true) {
//                        try {
//                            String s = q.getTask();
//                            System.out.println("execute task: " + s);
//                        } catch (InterruptedException e) {
//                            return;
//                        }
//                    }
//                }
//            };
//            t.start();
//            ts.add(t);
//        }
//        var add = new Thread(() -> {
//            for (int i=0; i<10; i++) {
//                // 放入task:
//                String s = "t-" + Math.random();
//                System.out.println("add task: " + s);
//                q.addTask(s);
//                try { Thread.sleep(100); } catch(InterruptedException e) {}
//            }
//        });
//        add.start();
//        add.join();
//        Thread.sleep(100);
//        for (var t : ts) {
//            t.interrupt();
//        }

    }
}
class TaskQueue{
    Queue<String> queue=new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
        this.notify();//唤醒在this锁等待的线程

       // this.notifyAll(); 一次性唤醒全部等待的线程
    }
    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            //在条件不慢时，线程进入等待状态,释放this 锁
            this.wait();
            //重新获取this 锁
        }
        return queue.remove();
    }
}