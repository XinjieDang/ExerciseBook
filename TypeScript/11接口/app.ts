// 接口是一系列抽象方法的声明，是一些方法特征的集合，方法应该是抽象的，需要具体的类去实现

//定义一个接口
interface Iperson {
    firstName: string,
    lastName: string,
    sayHello: () => string //方法的返回类型是string
}

//定义一个变量，类型是Iperson ,必须按照Iperson定义的
var customer: Iperson = {
    firstName: 'Tom',
    lastName: 'Hanks',
    sayHello: () => { return "hi world" }
}
console.log("customer对象...");
console.log(customer.firstName)
console.log(customer.lastName);
console.log(customer.sayHello());

//再定义一个变量
var employee: Iperson = {
    firstName: "jack",
    lastName: 'black',
    sayHello: () => { return "hi I am jack" }
}

console.log("employee...");
console.log(employee.firstName)
console.log(employee.lastName);
console.log(employee.sayHello());

//接口不能转化为JavaScript，只是TypeScript的一部分


//联合类型和接口 在接口中使用联合类型
interface RunOptions {
    program: string,
    //三种类型 字符串数组，字符串，函数表达式
    commandleine: string[] | string | (() => string);
}

var options: RunOptions = {
    program: "TEST1",
    commandleine: "hello"
}
//commandleine是字符串
console.log(options.commandleine)
//commandleine是字符串数组

options = {
    program: 'test2',
    commandleine: ["hello", "world", "testHelloWorld"]
}

//接口和数组，在接口中将数组的索引值和元素设置为不同类型，索引值可以是数字或字符串
interface namelist {
    [index: number]: string
}
//var list2:namelist=["john",1,"bran"] 错误，1 不是string类型

interface ages {
    [index: string]: number
}
var agelist: ages;
agelist['john'] = 15
//agelist[2]='nice' 错误

// 接口继承 接口可以通过其他接口拓展自己 TypeScript 允许接口继承多个接口，继承使用关键字extends，继承的各个接口用,隔开
// 单继承实例
interface Person {
    age: number
}
interface Musician extends Person {
    instrument: string
}
var drummer = <Musician>{};
// 只继承一个，可以有Person的age Musician的instrument
drummer.age = 27;
drummer.instrument = "Drums";
console.log("年龄", drummer.age);
console.log("喜欢的乐器", drummer.instrument)
// 多继承实例
interface IParent1 {
    v1: number
}
interface IParant2 {
    v2: number
}
// 多继承只有 继承两个，有继承的属性和方法，同时有自己的属性和方法

interface Child extends IParent1, IParant2 {

}

var Iobj: Child = { v1: 12, v2: 58 }
