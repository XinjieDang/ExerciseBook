// TypeScript是面向对象的JavaScript，类描述了所创建对象的共同属性和方法，TypeScript支持面向对象的所有特征，比如类，接口
// 创建一个Person类
class Person {
    // 字段
    name: string;
    age: number;
    // 构造函数
    constructor(name: string, age: number) {
        this.name = name
        this.age = age
    }
    // 方法
    sayHello(): string {
        return "Hello  你好世界"
    }
}
//创建实例化对象,调用构造函数
var objPerson = new Person('张三', 18)
// 访问属性
objPerson.age
// 访问方法
objPerson.sayHello();

// 类的继承,子类只能继承一个父类，不支持继承多个类，但支持多重继承
class Shape {
    Area: number
    constructor(a: number) {
        this.Area = a;
    }
}
//  继承Shape，输出Shape中Area
class Circle extends Shape {
    disp(): void {
        console.log("圆的面积", this.Area)
    }
}

//  调用
var objCircle = new Circle(223);
objCircle.disp();

// 多重继承
class Root {
    str: string
}
class Child extends Root { }
class Leaf extends Child { }//多重继承，继承了Child 和Root

var objLeaf = new Leaf();
objLeaf.str = 'hello';
console.log(objLeaf.str);

// 继承类方法重写,类继承后，子类可以对父类的方法重新定义，这个过程称为方法的重写
// super 关键字是对父类的直接引用，该关键字作用？可以直接引用父类的属性和方法

class PrinterClass {
    doPrint(): void {
        console.log("父类的doPrint()方法。")
    }
}

class StringPrinter extends PrinterClass {
    doPrint(): void {
        super.doPrint();//调用父类的函数
        console.log("子类的doPrint()方法")
    }
}
// static 关键字 定义类的成员（属性和方法）为静态的，静态成员可以直接通过类名调用


class StaticMem {
    static num: number;
    static disp(): void {
        console.log("num值为", StaticMem.num)
    }
}
StaticMem.num = 12;
StaticMem.disp();//调用静态方法
// instanceof 运算符 用于判断对象是否是指定的类型。如果是返回true,否则返回false

class Person2 { }
var objPerson2 = new Person2();
var isPerson2 = objPerson2 instanceof Person2
console.log("objPerson2对象是Person2的实例吗", isPerson2)

// 访问控制修饰符

class Encapsulate {
    str1: string = 'hello'
    private st2: string = 'world'
}

var objEn = new Encapsulate();
objEn.str1;
//objEn.str2 访问错误
// 类和接口 


interface Ilon {
    interest: number
}
// 实现接口
class ArgiLoan implements Ilon {
    interest: number;
    rabate: number;
    constructor(interest: number, rebate: number) {
        this.interest = interest
        this.rabate = rebate
    }
}