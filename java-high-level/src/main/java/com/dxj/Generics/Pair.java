package com.dxj.Generics;

/**
 * 编写泛型类
 * 1、按照某种类型 编写类
 * 2、标记所有特定类型的类
 * 3、把特定类型的类替换为T,并声明为<T>
 *
 * 不能将泛型用于 静态方法，可以单独改写为"泛型方法"
 *
 */
public class Pair<T> {
    private T first;
    private T last;
    public Pair(T first,T last){
        this.first=first;
        this.last=last;
    }
    public T getFirst(){
        return first;
    }

    public T getLast() {
        return last;
    }
    //静态泛型方法应该使用其他类型区分
    public static <K> Pair<K>create(K first,K last){
        return new Pair<K>(first,last);

    }
    //实例化T类型,借助额外的Class<T>参数；
    public Pair(Class<T> classPair) throws InstantiationException, IllegalAccessException {
        first=classPair.newInstance();
        last=classPair.newInstance();
    }
    //无法通过编译， 定义的equals(T t)方法 会被擦拭成equals(object t)，这个方法是继承自Object 的，编译器会阻止一个实际上会变成覆写的
    //泛型方法定义，换个方法名，避开与Object.equals(object)的冲突就可以成功编译；
//    public boolean equals(T t) {
//        return this == t;
//    }
    public boolean same(T t) {
        return this == t;
    }
}
