package com.dxj.reflex;

import java.lang.reflect.Field;

/**
 * 修改字段的值
 * 设置字段值通过Field.set(object，object)实现的，其中第一object参数是指定的实例，第二个object参数是待修改的值
 * 反射读写字段是一种非常规方法，会破坏对象的封装。
 */
public class Demo4 {
    public static void main(String[] args) throws Exception {
        Person p = new Person("Xiao Ming");
        System.out.println(p.getName()); // "Xiao Ming"
        Class c = p.getClass();
        Field f = c.getDeclaredField("name");
        //setAccessible 访问非public 字段
        f.setAccessible(true);
        f.set(p, "Xiao Hong");
        System.out.println(p.getName()); // "Xiao Hong"
    }
    static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }
}


