package com.dxj.Generics;

/**
 * 编写泛型类
 */
public class Demo2 {
    public static void main(String[] args) {
        //使用的时候，指出两种类型
        //java标准库的Map<k,v>就是使用两种泛型的例子
        Pairs<String,Integer> p=new Pairs<>("test",1234);
    }
}
