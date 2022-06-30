package com.dxj.reflex;

import java.util.function.BinaryOperator;

/**
 * 获取继承关系
 *一个类 可能实现一个或多个接口，通过class可以查询到实现的接口类型
 * 如果一个类没有实现任何interface,那么getInterfaces()返回空数组
 */
public class Demo8 {

    public static void main(String[] args) {
        Class i=Integer.class;
        //获取父类的class
        Class n=i.getSuperclass();
        System.out.println(n);
        Class o=n.getSuperclass();
        System.out.println(o);
        System.out.println(o.getSuperclass());

        //获取Interface
        Class i1=Integer.class;
        Class[] is=i1.getInterfaces();
        for(Class i2:is){
            System.out.println(i2);
        }

        //正常情况下，判断一个实例是否是某个类型时，正常情况下，使用instanceof
        //将基本类型int 转为包装类型Integer,Number 所有基本类型的包装类型都继承了该抽象
        Object n3=Integer.valueOf(123);
        boolean isDouble= n3 instanceof Double;//false
        boolean isInteger=n3 instanceof Integer;//true
        boolean isNumber=n3 instanceof Number;//true
        boolean isSerializable=n3 instanceof java.io.Serializable;

    }
}
