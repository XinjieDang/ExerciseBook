package com.dxj.Multithreading;

/**
 * 线程同步
 * 当多个线程同时运行时，线程的调度由操作系统决定，程序本身无法决定，因此任何一个线程都又可能在任何指令处被操作系统暂停，然后
 * 在某个时间段继续运行
 * 如果多个线程同时读写共享变量，会出现数据不一致的问题
 *
 * 多线程模式下，保证逻辑正确 对变量进行读写时，必须保证一组指令已原子方式进行，即某一个线程执行时，其他线程必须等待。
 * 通过加锁和解锁 的操作保证三条指令 总是在一个线程执行期间，不会有其他线程会进入此指令区间，只有执行线程将锁释放后，其他线程才有机会
 * 获得锁并执行，这种加锁和解锁之间 的代码块 我们称为临界区，任何时候临界区最多只有一个线程能执行。
 *
 *
 * java 程序 使用synchronized 关键字 对一个对象进行加锁。
 *
 * 使用synchronized 解决了多线程同步访问共享变量的正确性问题，但是它的缺点是带来了性能下降
 * synchronized 代码块无法并发执行，此外加 锁和释放锁需要消耗一定的时间，所以synchronized 会降低 程序执行效率
 *
 *
 *
 *
 * 概括使用 synchronized
 * 1、找出修改共享变量的线程代码块
 * 2、选择一个共享实例作为锁；
 * 3、使用synchronized(lockObject){...}
 *  使用synchronized 的时候不必担心抛出异常，无论是否有异常，都会在synchronized结束处 正确释放锁
 *
 *
 *
 *
 *  不需要synchronized的操作
 *   基本类型（long和double除外）赋值,例如 int n=m;  long和double 是64位数据，jvm 没有规定64位赋值操作是不是一个原子操做
 *   引用类型赋值 例如 list<Sting> list=anotherList
 *
 */
public class Demo5 {
    //例子 两个线程读写同一变量 出现数据不一致，是因为 对变量进行读和写操作，必须是保证是原子操作，原子操作是指不能被中断的一个或一些列操作。
    public static void main(String[] args) throws InterruptedException {
        AddThread add=new AddThread();
        DesThread desThread=new DesThread();
        add.start();
        desThread.start();
        add.join();
        desThread.join();
        System.out.println(Counter.count);

    }

}
  class  Counter{
      public static final Object lock = new Object();
    public static int count=0;
  }
  class AddThread extends Thread{
      @Override
      public void run() {
          //使用synchronized 加锁保证代码任意时刻只有一个线程能执行
          for (int i=0;i<1000;i++){
              synchronized (Counter.lock){
                  Counter.count+=1;
              }//无论是否有异常，都会在此释放锁

          }
      }
  }
class DesThread extends Thread{
    @Override
    public void run() {
        for (int i=0;i<10000;i++){
            synchronized(Counter.lock) {//获取锁
                Counter.count -= 1;
            }
        }
    }
}