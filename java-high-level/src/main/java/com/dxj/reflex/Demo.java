package com.dxj.reflex;

/**
 * 反射就是Reflection,java反射指程序在运行期间可以拿到一个对象的所有信息
 * 反射为了解决 在运行期，对某一实例一无所知的情况下，如何调用其方法。
 * 由于jvm 为每个加载 的class 创建了对应的class实例，并在该实例中保存了该class的所有信息，包括类名、包名、父类、实现的接口、方法等，
 * 因此获取了某个class 实例，我们就可以通过这个class 实例 获取到该实例对应的class 的所有信息
 * 这种通过class 获取class信息的方法称为反射。
 */
public class Demo {
    public static void main001(String[] args) throws ClassNotFoundException {

        //方法一：通过class 静态变量class 获取
        Class cls=String.class;
        //方法二：如果有实例变量，可以通过该实例变量提供的getClass()方法获取
        String s="Hello";
        Class sClass=s.getClass();
        System.out.println(sClass);
        //方法三：如果知道一个class的完整类名，可以通过静态方法class.forName()获取
        Class ClsClass=Class.forName("java.lang.String");
        //class 实例在JVM中是唯一的，所以上面两个获取的class实例是同一个实例，可以用==比较两个class实例
        boolean sameClass=sClass==ClsClass;
        System.out.println(sameClass);

        //Class实例和instanceof的差别
        Integer n=new Integer(123);
        boolean n1=n instanceof Integer;//true n是integer类型
        boolean b2=n instanceof Number;//true n是Number类型的子类
        boolean b3=n.getClass()==Integer.class;//true 因为n.getClass()返回Integer.class
        //boolean b4=n.getClass()==Number.class;//false 因为Integer.class!=Number.class
        //通常情况下，应该使用instanceof 判断数据类型，因为面向抽象编程，不需要关心具体的子类，只有在需要精确判断一个类型是不是某个class的时候，
        //才使用==判断class实例
    }

    /**
     * 反射的目的是获得某个实例的信息，当拿到某个object 实例时，可以通过反射获取该object的class信息
     * @param obj
     */
    public void printObjectInfo(Object obj){
        Class cls=obj.getClass();
    }
}
