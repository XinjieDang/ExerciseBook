package com.dxj.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 遍历Map 使用forearch 循环遍历Map 实例的keySet()方法返回的Set 集合，它包含不重复的key集合
 *
 * 正确使用map 必须保证
 *  1、作为key的对象必须正确覆写equqls()方法，相等的两个key 实例调用equals()必须返回true
 *  2、作为key的对象还必须正确覆写hashCode()方法，且hashCode()方法要严格遵循 以下
 *      如果两个对象相等，则两个对象的hashCode()必须相等；
 *      如果两个对象不相等，则两个对象的hashCode() 尽量不要相等
 *
 *
 * 哈希冲突：不同的key ,有相同的hashCode
 *   解决：用list 存储hashCode()相同的key-value，尽量满足(如果两个对象不相等，则两个对象的hashCode() 尽量不要相等)
 */
public class Demo5 {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        map.put("appple",123);
        map.put("pear",456);
        map.put("bannana",789);
        //遍历 key
        for (String key:map.keySet()){
            Integer value=map.get(key);
            System.out.println(key+"="+value);
        }
        //同时遍历key value 可以使用forEach 循环遍历Map对象entrySet()集合，它包含每一个key-value
        for (Map.Entry<String,Integer> entry:map.entrySet()) {
            String key=entry.getKey();
            Integer value=entry.getValue();
            System.out.println(key+"="+value);

        }
        //在Map内部，对key 做比较是通过equals()实现的，正确使用Map必须保证 作为key 的对象必须正确覆写equals()方法
        //经常使用String  作为key ,因为String 已经正确覆写了 eauals()方法，但是如果我们方法的key 是一个自己写的类，就必须保证正确覆写 了equals()方法。

    }
}
