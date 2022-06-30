package com.dxj.Multithreading;

public class Counter2 {
    private int count = 0;

    public void add(int n) {
        //锁住的是this 实例
        synchronized(this) {
            count += n;
        }
    }

    /**
     * 实际上可用synchronized 修饰这个方法，
     * synchronized  修饰的方法就是同步方法它表示整个方法 都必须使用this 实例 加锁，对于静态方法 static 是没有this实例的，
     * 静态方法是针对类而不是实例，因此对static 方法添加synchronized 锁住的是该类的class实例
     * @param n
     */

    public synchronized  void add2(int n){//锁住
        count+=n;
    }//解锁

    public void dec(int n) {
        synchronized(this) {
            count -= n;
        }
    }

    public int get() {
        return count;
    }
}