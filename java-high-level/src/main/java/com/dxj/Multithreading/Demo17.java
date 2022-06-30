package com.dxj.Multithreading;

import sun.tools.jar.Main;

import java.util.concurrent.CompletableFuture;

/**
 * java8 引入了CompletableFuture ，它针对了Future 做了改进可以传入回调对象，当异步任务完成或者发生异常时，自动调用回调对象的回调方法
 */
//public class Demo17 {
//    public static void main(String[] args) throws InterruptedException {
//        //创建异步执行任务
//        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(Main::fetchPrice);
//        // 如果执行成功:
//        cf.thenAccept((result) -> {
//            System.out.println("price: " + result);
//        });
//        // 如果执行异常:
//        cf.exceptionally((e) -> {
//            e.printStackTrace();
//            return null;
//        });
//        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
//        Thread.sleep(200);
//    }
//    static Double fetchPrice() {
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//        }
//        if (Math.random() < 0.3) {
//            throw new RuntimeException("fetch price failed!");
//        }
//        return 5 + Math.random() * 20;
//    }
//}
