package com.dxj.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Equals方法
 * list是一种有序链表，list 内部 按照放入元素的先后顺序存放，每个元素都可以通过索引 确定自己的位置
 * lis 提供了contains(object o)方法判断List 是否包含某个指定元素,int indexof(object o)方法可以返回某个元素的索引。
 * 如果不存在，就返回-1
 */
public class Demo3 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println(list.contains("A"));
        System.out.println(list.indexOf("A"));
        //如果不调用List的contains()、indexOf 方法，那么放入的元素不需要实现equals()方法。
        //传入的是new String("C") 是一定不同的实例，List 内部并不是通过==判断两个元素是否相等，而是使用equals()方法判断两个元素是相等
    }
}
