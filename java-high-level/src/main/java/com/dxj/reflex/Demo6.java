package com.dxj.reflex;

import java.lang.reflect.Method;

/**
 * 使用反射时，仍然遵循多态原则 ，即总是调用实际类型的覆盖方法（如果存在）
 */
public class Demo6 {
    public static void main(String[] args) throws Exception {
        // 获取Person的hello方法:
        Method h = Person.class.getMethod("hello");
        // 对Student实例调用hello方法:
      //  h.invoke(new Student());
    }
    class Person {
        public void hello() {
            System.out.println("Person:hello");
        }
    }

    class Student extends Person {
        public void hello() {
            System.out.println("Student:hello");
        }
    }
}



