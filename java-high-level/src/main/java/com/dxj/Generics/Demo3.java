package com.dxj.Generics;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 泛型是一种 类似"模板代码"的技术
 * java 语言 的泛型 实现方式是 擦拭法
 * 擦拭法：虚拟机对泛型其实一无所知，所有的工作都是编译器做的
 * java 使用擦拭法实现泛型，导致了
 *    编译器把类型<T>视为 object
 *    编译器根据<T> 实现安全的强制转型
 *    编译器内容永远把所有类型T 视为object 处理，在需要转型的时候，编译器会根据T 的类型自动为我们实行安全的强制转型。
 *    java 泛型的局限
 *  缺点1  <T>不能是基本类型 例如 int ,因为实际类型是object ,object 无法持有基本类型。
 *  缺点2  无法取得带泛型的class
 *  缺点3   所有泛型类型，无论T 的类型是什么，getClass()返回同一个Class实例，因为编译后全部都是Pair<Object>
 *  缺点4  无法判断泛型的类型
 *  缺点5   不能实例化T 实例,实例化T 必须借助额外的Class<T>参数；
 *
 *
 *使用Pair<? extends Number> 使得方法接收所有泛型类型为Number或Number子类的Pair类型，
 * 这种 使用<? extends Number> 的泛型定义称之为上界通配符，即把泛型类型T的上界限定在Number 了
 *
 *
 *
 */
public class Demo3 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //泛型<T>不能是基本类型，例如int,因为实际类型是object,object 无法持有基本类型。
        //Pair<int> p=new Pair<int>(1,2);//compile error
        //使用的时候，正常使用，子类没有泛型类型
        IntPair ip=new IntPair(1,2);



        //Java 部分反射API也是泛型，例如Class<T>就是泛型
        //编译错误
//        Class clazz=String.class;
//        String str=(String) clazz.newInstance();
        //no warning
//        Class<String> clazz=String.class;
//        String str=clazz.newInstance();

        Class<? super String> sup=String.class.getSuperclass();
        //构造方法也是泛型
        Class <Integer> clazz=Integer.class;
        Constructor<Integer>cons=clazz.getConstructor(int.class);
        Integer i=cons.newInstance(123);
        //可以声明带泛型的数组，不能用new 操作符 创建带泛型的数组
        Pair<String>[] ps=null;
        //Pair<String>[] ps=new Pair<String>[2];编译错误


    }
}
