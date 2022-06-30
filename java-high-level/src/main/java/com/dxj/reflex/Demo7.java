package com.dxj.reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 调用构造方法
 * 通过反射来创建新的实例，可以调用Class提供的newInstance()方法
 * newInstance()局限 是只能调用该类的public 无参数构造方法
 * 为了调用任意的构造方法，java的反射API提供了Constructor对象，包含一个构造方法所有的信息，可以创建一个实例
 *
 * Constructor 总是当前类定义的构造方法，与父类无关，不存在多态问题。
 */
public class Demo7 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取构造方法 Integer类的构造方法(int)
        Constructor cons1 = Integer.class.getConstructor(int.class);
        //调用构造方法,利用反射创建新的实例 newInstance
        Integer n1=(Integer) cons1.newInstance(123);
        System.out.println(n1);
        //获取构造方法Integer(String)
        Constructor cons2=Integer.class.getConstructor(String.class);
        Integer n2=(Integer)cons2.newInstance("456");
        System.out.println(n2);
    }
}
