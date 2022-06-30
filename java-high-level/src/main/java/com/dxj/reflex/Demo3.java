package com.dxj.reflex;

import java.lang.reflect.Field;

/**
 * 对任意的object 实例，只要我们获取它的class 就可以获取它的一切信息
 * <p>
 * 通过class 获取字段信息
 * getField(name):根据字段名获取某个Public的field包括父类
 * getDeclaredField(name)：根据字段名获取当前类的某个field（不包括父类）
 * getFields():获取所有public的field 包括父类
 * getDeclaredFields()：获取当前类的所有field不包括父类
 */
public class Demo3 {
    public class Main {
        public  void main(String[] args) throws Exception {
//            Object p = new Person("Xiao Ming");
//            Class c = p.getClass();
//            Field f = c.getDeclaredField("name");
//            Object value = f.get(p);
//            System.out.println(value); // "Xiao Ming"
        }
    }

    class Person {
        public String name;

        public Person(String name) {
            this.name = name;
        }
    }

}
