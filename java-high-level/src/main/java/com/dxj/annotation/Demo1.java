package com.dxj.annotation;

/**
 * 注解 是放在 Java 源码的类、方法、字段、参数前的一种特殊注释
 * 注解会被编译器 直接忽略，注解则可以 变编译器 打包进入class 文件，注解是一种用于标注的元数据
 * 作用：
 *   从JVM的角度看，注解本身对代码没有任何影响，如何使用注解完全由工具决定
 *   三类注解：
 *     1、 由编译器使用的注解：@override:让编译器检查该方法是否正确的实现了覆写。
 *                       @SuppressWarnings：告诉编译器忽略此处代码产生的警告
 *                       这类注解不会被编译进.class 文件，在编译后就被编译器扔掉了
 *     2、由工具处理.class文件使用的注解，有些工具类会在加载class的时候，对class做动态修改，实现一些特殊的功能，这类注解会被编译进入.class文件
 *     但加载结束后并不会存在于内存中
 *     3、在程序的运行期间能够读取的注解，在加载后一直存在于JVM中，这也是最常用的注解，一个配置了@PostConstruct的方法会在调用构造方法后自动被调用
 */
public class Demo1 {
//    @Check(min=0,max=100,value=55)
//    public int n;
//    @Check(value=99)
//    public int p;
//
//    @Check(99)
//    public int x;
//    @Check
//    public int y;
}
