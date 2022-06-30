package com.dxj.Multithreading;

/**
 * 中断线程
 * 如果线程需要执行一个长时间任务，就可能需要能中断线程，中断线程就是其他线程给该线程一个信号。该线程收到信号后结束执行run()方法，
 * 使得自身线程能立刻结束运行。
 * 例子： 假设中网络上 下载一个 100m的文件，如果网速很慢，用户等得不耐烦，可能在下载过程中点取消，这时就需要中断下载线程的执行。
 * 中断线程方法：
 *         只需要在其他线程中对目标线程调用interrupt()方法,目标线程需要反复监测自身状态是否是interrupted状态，如果是立即执行。
 *
 *         方法二：
 *             设置标志位 使用running 标志位来标识 线程是否应该继续运行，在外部线程中，通过把HelloThread.running 置为false就可以让线程结束。
 *
 */
public class Demo3 {
    //中断线程
    public static void main(String[] args) throws InterruptedException {
        Thread t=new MyThread2();
        t.start();
        Thread.sleep(1);//暂停1毫秒
        t.interrupt();//中断t线程。
        t.join();//等待t线程结束
        System.out.println("end");

        //中断线程，使用标志位
        HelloThread ht=new HelloThread();
        ht.start();
        Thread.sleep(1);
        ht.running=false;//标致 false

    }
}
class MyThread2 extends Thread{
    @Override
    public void run() {
       int n=0;
       while (!isInterrupted()){
           n++;
           System.out.println(n+"hello");
       }

    }
}

class HelloThread extends Thread{
    //标致位， 是一个线程间共享的变量，线程间共享变量需要使用volatile 关键字标记，确保每个线程都能读取到更新后的变量值

    //volatile 作用:每次访问变量时，总是获取主内存的最新值，每次修改变量后，立刻回写主内存。
    public volatile boolean running = true;
    @Override
    public void run() {
        int n=0;
        while (running){
            n++;
            System.out.println(n+"hello！");
        }
        System.out.println("end!");
    }
}
