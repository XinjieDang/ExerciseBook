package com.dxj.Generics;

/**
 * 一个类可以继承自一个泛型类
 */
public class IntPair extends  Pair<Integer>{
    public IntPair(Integer first, Integer last) {
        super(first, last);
    }
}
