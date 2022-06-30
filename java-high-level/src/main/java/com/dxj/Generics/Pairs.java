package com.dxj.Generics;


/**
 * 多个泛型类型，希望Pair不总是存储两个类型一样的对象，可以使用类型<T,K>
 *
 *    例如 map<k,v>
 */
public class Pairs<T,K> {
    private T first;
    private K last;
    public Pairs(T first,K last){
        this.first=first;
        this.last=last;
    }

    public K getLast() {
        return last;
    }

    public T getFirst() {
        return first;
    }
}
