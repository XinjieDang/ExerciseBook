package com.dxj.Multithreading;

import javafx.concurrent.Task;

import java.util.concurrent.*;

/**
 * 执行多个任务的时候，使用java 标准库提供的线程池 是非常方便，提供的任务只需要实现 Runnable 接口，可也有让线程池去执行
 */
//public class Demo16 {
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executor = Executors.newFixedThreadPool(4);
//          // 定义任务:
////        Callable<String> task = new Task();
//         // 提交任务并获得Future:
//        //Future<String> future = ((ExecutorService) executor).submit(task);
//        // 从Future获取异步执行返回的结果:
//        //String result = future.get(); // 可能阻塞
//
//    //需要一个返回结果，只能保存到变量Callable是一个泛型接口，可以返回指定类型的结果
//    class Task implements Callable<String> {
//        public String call() throws Exception {
//            return "hello";
//        }
//    }
//}
