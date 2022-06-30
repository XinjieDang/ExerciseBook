package com.dxj.annotation;

import java.lang.annotation.*;

/**
 * @interface 语法来定义注解(Annotation)
 * 元注解:
 *       @Target 是最常用的元注解，使用@Target 可以定义Annotation能够被应用于源码的哪些位置
 *       类或接口：ElementType.TYPE;
 *       字段：ElementType.FIELD;
 *       方法：ELementType.METHOD;
 *       构造 方法：ElementType.CONSTRUCTOR;
 *       方法参数：ELementType.PARAMETER.
 *
 *
 *
 * @Retention 注解定义了Annotation 的生命周期
 *         仅编译期：RetentionPolicy.SOURCE;
 *         仅class文件：RetentionPolicy.CLass;
 *         运行期：RetentionPolicy.RUNTIME。
 * 如果@Retention 不存在，则该Annotaion默认为ClASS
 *
 * @Repeatable 注解定于Annotation 是否可重复
 *
 *
 *
 * @Inherited
 * 使用@Inherited定义子类是否可继承父类定义的Annotation @Inherited仅针对@Target(ElementType.TYPE)类型的annotation有效
 * 并且仅针对class的继承，对interface的继承无效
 *
 */


//@Target 注解参数变为数组{ElementType.METHOD,ElementType.FIELD}


 @Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Report {
    /**
     * 注解参数类似无参数的方法，可以用default 设定一个默认值
     * @return
     */

    int type() default 0;
    String level() default "info";
    String value() default "";
}
