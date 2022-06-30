package com.dxj.reflex;

/**
 * 通过class 实例获取 所有MeThod 信息
 * getMethod(name,class...)：获取某个public 的method包括父类
 * getDeclaredMethod(name,Class...）：获取当前类的某个Method 不包括父类
 * getMethods()：获取所有public 的Method 包括父类
 * getDeclaredMethods()：获取当前类的所有 Method不包括父类
 */
public class Demo5 {
    public static void main(String[] args) throws NoSuchMethodException {
        Class stdClass=Student.class;
        //获取public方法getScore,参数为String;
        System.out.println(stdClass.getMethod("getScore", String.class));
        //获取继承的public 方法getName，无参数
        System.out.println(stdClass.getMethod("getName"));
        //获取private方法getGrade,参数为int
        System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));

    }

    class Student extends Person {
        public int getScore(String type) {
            return 99;
        }

        private int getGrade(int year) {
            return 1;
        }
    }

    class Person {
        public String getName() {
            return "Person";
        }
    }

}
