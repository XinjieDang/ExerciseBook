package com.dxj.collection;

/**
 * 集合是由若干个确定的元素所构成的整体，在计算机中引入集合是为了便于处理一组类似的数据
 * 在java 中 如果一个Java对象可以在内部持有若干其他java 对象，并对外提供访问接口，把这种java 对象称为集合，java的数组可以看成一组集合。
 *
 * java集合特点：
 *       实现了接口和实现类的分类，如：有序表接口是List 具体的实现类有ArrayList,LinkedList ，支持泛型，在一个集合中 只能放入同一种数据类型
 *
 *       如：List<String> list=new Arraylist<>();\
 *       java集合访问方式：迭代器，好处在于 无需知道集合内部元素是按什么方式存储的。
 */
public class Demo1 {
    public static void main(String[] args) {
        String [] ss=new String[10];//持有10个String 对象
        ss[0]="hello";//可以放入String对象
        String first=ss[0];//可以获取String对象
        //数组缺陷，初始化后大小不可变，数组只能按索引顺序存取
        //需要：可变大小的顺序链表，保证无重复元素的集合Collection
        //java.util包含了以下三种类型的集合  list:有序列表集合
        //set: 一种保证没有重复元素的集合
        //Map：一种通过键值(key-value)查找的映射表集合
    }
}
