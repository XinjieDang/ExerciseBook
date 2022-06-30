package com.dxj.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * set：只需要存储 不重复的key,并不需要存储引映射的value ,可以使用set
 * set 存储不重复的元素集合
 * 实际上只存储key,不存储value的Map,经常用Set 用于去除重复元素
 */
public class Demo8 {
    public static void main(String[] args) {
        //输出的顺序 不是添加的顺序，也不是String排序的顺序，
        Set<String> set=new HashSet<>();
        set.add("abc");
        set.add("xyk");
        set.add("xky");
        set.add("hello");
        for (String s : set) {
            System.out.println(s);
        }
        //把HashSet 换成TreeSet，在遍历TreeSet时，输出就是有序的
        Set<String> set2 = new TreeSet<>();
        set.add("apple");
        set.add("banana");
        set.add("pear");
        set.add("orange");
        for (String s : set2) {
            System.out.println(s);
        }
    }
}
