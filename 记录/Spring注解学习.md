### Spring注解学习

#### @Target(ElementType.METHOD)

Target说明了Annotation所修饰的对象范围，作用：用于描述注解的使用范围（即：被描述的注解可以用在什么地方），ElementType取值有

* FIELD：用于描述域
* METHOD：用于描述方法
* PARAMETER：用于描述参数
* CONSTRUCTOR：用于描述构造器
* LOCAL_VARIABLE：用于描述局部变量
* PACKAGE：用于描述包 Package declaration
* TYPE_PARAMETER：用来标注类型参数

#### @Retention(RetentionPolicy.RUNTIME)

@Retention作用是定义被它所注解的注解保留多久，一共有三种策略，定义在RetentionPolicy枚举中，取值有

* source：注解只保留在源文件，当java文件编译成class 文件的时候，注解被遗弃，被编译器忽略。
* class：注解保留到class文件，但jvm加载的时候被遗弃，这是默认的生命周期
* runtime：注解不仅保留到class文件中，jvm加载class文件之后，仍然存在。

