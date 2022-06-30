package com.dxj.Multithreading;

/**
 * 使用StampedLock 进一步提升并发效率 ，读的过程中也允许获取写锁后写入
 *
 * StampedLock 把读锁细分为乐观锁和悲观锁，能进一步提升并发效率，代价是：代码更加复杂，StampedLock是不可重入锁，不能在一个线程中反复获取同一个锁。
 *
 *
 * 乐观锁：乐观的估计读的过程中，大概率不会有写入，因此被称为乐观锁
 * 悲观锁：读的过程中拒绝有写入，也就是写入必须等待
 */
public class Demo12 {

}
