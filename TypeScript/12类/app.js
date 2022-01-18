var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
// TypeScript是面向对象的JavaScript，类描述了所创建对象的共同属性和方法，TypeScript支持面向对象的所有特征，比如类，接口
// 创建一个Person类
var Person = /** @class */ (function () {
    // 构造函数
    function Person(name, age) {
        this.name = name;
        this.age = age;
    }
    // 方法
    Person.prototype.sayHello = function () {
        return "Hello  你好世界";
    };
    return Person;
}());
//创建实例化对象,调用构造函数
var objPerson = new Person('张三', 18);
// 访问属性
objPerson.age;
// 访问方法
objPerson.sayHello();
// 类的继承,子类只能继承一个父类，不支持继承多个类，但支持多重继承
var Shape = /** @class */ (function () {
    function Shape(a) {
        this.Area = a;
    }
    return Shape;
}());
//  继承Shape，输出Shape中Area
var Circle = /** @class */ (function (_super) {
    __extends(Circle, _super);
    function Circle() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    Circle.prototype.disp = function () {
        console.log("圆的面积", this.Area);
    };
    return Circle;
}(Shape));
//  调用
var objCircle = new Circle(223);
objCircle.disp();
// 多重继承
var Root = /** @class */ (function () {
    function Root() {
    }
    return Root;
}());
var Child = /** @class */ (function (_super) {
    __extends(Child, _super);
    function Child() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    return Child;
}(Root));
var Leaf = /** @class */ (function (_super) {
    __extends(Leaf, _super);
    function Leaf() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    return Leaf;
}(Child)); //多重继承，继承了Child 和Root
var objLeaf = new Leaf();
objLeaf.str = 'hello';
console.log(objLeaf.str);
// 继承类方法重写,类继承后，子类可以对父类的方法重新定义，这个过程称为方法的重写
// super 关键字是对父类的直接引用，该关键字作用？可以直接引用父类的属性和方法
var PrinterClass = /** @class */ (function () {
    function PrinterClass() {
    }
    PrinterClass.prototype.doPrint = function () {
        console.log("父类的doPrint()方法。");
    };
    return PrinterClass;
}());
var StringPrinter = /** @class */ (function (_super) {
    __extends(StringPrinter, _super);
    function StringPrinter() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    StringPrinter.prototype.doPrint = function () {
        _super.prototype.doPrint.call(this); //调用父类的函数
        console.log("子类的doPrint()方法");
    };
    return StringPrinter;
}(PrinterClass));
// static 关键字 定义类的成员（属性和方法）为静态的，静态成员可以直接通过类名调用
var StaticMem = /** @class */ (function () {
    function StaticMem() {
    }
    StaticMem.disp = function () {
        console.log("num值为", StaticMem.num);
    };
    return StaticMem;
}());
StaticMem.num = 12;
StaticMem.disp(); //调用静态方法
// instanceof 运算符 用于判断对象是否是指定的类型。如果是返回true,否则返回false
var Person2 = /** @class */ (function () {
    function Person2() {
    }
    return Person2;
}());
var objPerson2 = new Person2();
var isPerson2 = objPerson2 instanceof Person2;
console.log("objPerson2对象是Person2的实例吗", isPerson2);
