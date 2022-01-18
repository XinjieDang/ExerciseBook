// 接口是一系列抽象方法的声明，是一些方法特征的集合，方法应该是抽象的，需要具体的类去实现
//定义一个变量，类型是Iperson ,必须按照Iperson定义的
var customer = {
    firstName: 'Tom',
    lastName: 'Hanks',
    sayHello: function () { return "hi world"; }
};
console.log("customer对象...");
console.log(customer.firstName);
console.log(customer.lastName);
console.log(customer.sayHello());
//再定义一个变量
var employee = {
    firstName: "jack",
    lastName: 'black',
    sayHello: function () { return "hi I am jack"; }
};
console.log("employee...");
console.log(employee.firstName);
console.log(employee.lastName);
console.log(employee.sayHello());
var options = {
    program: "TEST1",
    commandleine: "hello"
};
//commandleine是字符串
console.log(options.commandleine);
//commandleine是字符串数组
options = {
    program: 'test2',
    commandleine: ["hello", "world", "testHelloWorld"]
};
var agelist;
agelist['john'] = 15;
var drummer = {};
// 只继承一个，可以有Person的age Musician的instrument
drummer.age = 27;
drummer.instrument = "Drums";
console.log("年龄", drummer.age);
console.log("喜欢的乐器", drummer.instrument);
var Iobj = { v1: 12, v2: 58 };
