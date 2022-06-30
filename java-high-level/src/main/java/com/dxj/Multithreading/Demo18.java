package com.dxj.Multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 引入了CompletableFuture
 *
 * 三个操作 step1,step2,step3存在依赖关系，其中step3的执行依赖step1和step2的结果
 */
public class Demo18 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行step 1");
            return "step1 result";
        }, executor);
        CompletableFuture<String> cf2=CompletableFuture.supplyAsync(()->{
            System.out.println("执行step2");
            return "step2 result";
        });
        cf1.thenCombine(cf2,(result1,result2)->{
            System.out.println(result1+","+result2);
            System.out.println("执行step3");
            return "step3 result";
        }).thenAccept(result3-> System.out.println(result3));
    }
}
