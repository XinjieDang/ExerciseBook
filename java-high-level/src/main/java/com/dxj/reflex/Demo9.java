package com.dxj.reflex;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理机制：在运行期间动态创建某个interface的实例
 * 运行期间动态创建：与静态相对
 * 动态代理： 先定义接口，但是并不去编写实现类，而是直接通过jdK 提供 的Proxy.newProxyInstance()创建接口对象，这种没有实现类但是
 * 在运行期间动态创建了一个接口对象的方式，称为动态代码，JDK提供的动态创建接口对象的方式，叫做动态代理。
 */
public class Demo9 {
    public static void main(String[] args) {
        InvocationHandler handler=new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if(method.getName().equals("morning")){
                    System.out.println("Good morning,"+args[0]);
                }
                return null;
            }
        };
        //不编写实现类，通过jdk提供的Proxy.newProxyInstance()创建一个代理对象
        Hello hello=(Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(),
                new Class[]{Hello.class},handler);
        hello.morning("BOB");

        }
    }

    interface  Hello{
        void morning(String name);
    }

