package com.dxj.Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 泛型：泛型就是定义一种模板，例如ArrayList<T> 然后在代码中为用到的类创建对应的ArrayList<类型>
 *     ArrayList<String> strList=new ArrayList<String>(); 由编译器针对类型做检查
 *     实现编写一次，万能匹配，又通过编译器保证了 类型安全，就是泛型
 *    编写模板代码来适应任意类型
 *    好处：使用时不必对类型进行强制转化，它通过编译器对类型进行检查
 *
 *    可以在接口中定义泛型类型，实现此接口的类必须实现正确的泛型类型
 */
public class Demo {

    public static void main(String[] args) {
        ArrayList<String> strList=new ArrayList<>();
        strList.add("hello");
        String s=strList.get(0);


        //使用泛型时，如果不定义泛型类型，实际上就是object
        //编译器警告
        List list=new ArrayList<>();
        list.add("愿你始终有初心模样，一生热爱不遗憾");
        list.add("鱼书");
        String fist=(String)list.get(0);
        String second=(String)list.get(1);
        //此时，只能把<T>当做object 使用，没有发挥泛型的优势
        //无编译器警告
        List<String> stringList=new ArrayList<>();
        stringList.add("少年，少年");
        //无强制转化
        String str2 =stringList.get(0);

        //定义泛型类型<Number>后，list<T>的泛型接口变为强类型List<Number> ,可以省略Number，编译器自动推断。
        List<Number> list1=new ArrayList<>();
        list1.add(new Integer(123));
        list1.add(new Double(12.34));

        Number first=list1.get(0);
        Number second2=list1.get(1);


        //泛型接口 例如 Arrays.sort(Object[]) 可以对任意数组进行排序，但排序的元素必须实现Comparable<T>这个泛型接口

        //可直接对String 数组进行排序，因为String 本身已经实现了Comparable<String>接口
        String [] ss=new String[]{"hello","apple","Pear"};
        Arrays.sort(ss);
        System.out.println( Arrays.toString(ss));








    }
}
