package com.dxj.annotation;

import javax.swing.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 读取注解 RUNTIME类型的注解不但要使用，还经常需要编写，注解定义后也是一种class，所有注解都继承自java.lang.annotation.Annnotation
 * 因此，读取注解需要使用反射API,java 提供的使用反射API读取Annotation的方法包括
 * 判断某个注解是否存在于 class、Field、Method 或Constructor
 *使用反射API读取Annotation
 *
 *   Class.getAnnotation(class)
 *   Field.getAnnotation(Class)
 *   Method.getAnnotation(Class)
 *   Constructor.getAnnotation(Class)
 */
public class Demo2 {
    public static void main(String[] args) {
        //判断@Report 注解是否存在于Person类
        Person.class.isAnnotationPresent(Report.class);
        //获取Person定义的@Report注解
        Report report=Person.class.getAnnotation(Report.class);
        int type=report.type();
        String Level=report.level();
        System.out.println("type为"+type+"level为"+Level);

        //利用反射API读取Annotation的方式
        //方式1：先判断Annotation是否存在，如果存在就直接读取；
        Class cls=Person.class;
//        if(cls.isAnnotationPresent(Report.class)){
//            Report report2 = cls.getAnnotation(Report.class);
//        }
        //方式二 直接读取Annotation，如果Annotation 不存在，将返回Null
        Class cls2=Person.class;
        Annotation report1=cls2.getAnnotation(Report.class);
        if(report1!=null){
            ///
        }


    }

    /**
     * 检验注解
     * @param person
     */
    void check(Person person) throws IllegalAccessException {
        // 遍历所有Field:
        for (Field field : person.getClass().getFields()) {
            // 获取Field定义的@Range:
            Range range = field.getAnnotation(Range.class);
            // 如果@Range存在:
            if (range != null) {
                // 获取Field的值:
                Object value = field.get(person);
                // 如果值是String:
                if (value instanceof String) {
                    String s = (String) value;
                    // 判断值是否满足@Range的min/max:
                    if (s.length() < range.min() || s.length() > range.max()) {
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    }
                }
            }
        }
    }
}
