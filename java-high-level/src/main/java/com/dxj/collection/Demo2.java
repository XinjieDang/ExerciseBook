package com.dxj.collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 使用list:list 是最基础的一种集合，它是一种 有序列表
 *
 * ArrayList 把添加和删除的操作封装起来，让操作list类似数组，却不关系内部元素如何移动，List<E>接口 几个主要方法
 *   在末尾添加一个元素：add(E e)
 *   在指定索引添加一个元素 add(int  index,E e)
 *   删除指定索引的元素remove(int index)
 *   删除某个元素remove(Object e)
 *   获取指定索引的元素get(int index)
 *   获取链表大小（包含元素的个数) int size()
 *
 *
 *
 * LinkedList通过"链表"也实现了 List 接口，在LinkedList中，它的内部每个元素都指向下一个元素
 * 需要从头开始查找元素
 * 速度很快
 * 不需要移动元素
 * 内存开销较大
 * 通常情况下 优先使用ArrayList
 */
public class Demo2 {
    public static void main(String[] args) {
        //List 接口允许添加重复的元素，即list内部的元素可以重复
        List<String> list=new ArrayList<>();
        list.add("apple");
        list.add("pear");
        list.add("apple");//允许添加重复元素
        System.out.println(list.size());
        //list 允许添加null
        list.add(null);
        //通过list 提供的of()方法，根据给定元素快速创建List
        //List<Integer> list2 = List.of(1, 2, 5);
        //遍历List 使用for 循环根据索引配和get(int)方法遍历,并不推荐，只有ArrayList的实现是高效的，换成LinkedList后,索引越大，访问越慢
        //检坚持使用Iterator来访问List,Iterator本身也是一个对象，Iterator对象有两个方法，hasNext()判断是否有下一个元素，E next 返回下一个元素
        for (int i = 0; i < list.size(); i++) {
            String s=list.get(i);
            System.out.println(s);

        }

        //使用Iterator 遍历List 代码如下,Iterator遍历List永远是最高效的方式，Java foreach 循环本身可以帮我们使用Iterator 遍历
        List<String> list3 = Arrays.asList("苹果","雪梨","香蕉");
        for(Iterator<String> it = list3.listIterator(); it.hasNext();){
            String s2=it.next();
            System.out.println(s2);
        }

        for (String slist: list3) {
            System.out.println(slist);

        }

        //list 和Array 转化 使用toArray() 方法
         List<Integer> list4=Arrays.asList(1,32,55,50);
       // Object [] array=list4.toArray();
        Object []array=list4.toArray(new Integer[4]);
       // Integer[] array = list4.toArray(Integer[]::new);
        for (Object s:array) {
            System.out.println(s);
        }
    }
}
