// 函数定义
function greet() {
    return 'Hello world';
}
function caller() {
    var msg = greet(); //调用greet函数
}
// 调用函数
caller();
//带参数函数
function add(x, y) {
    return x + y;
}
//调用
add(1, 2);
//可选参数 和默认参数  ?符表示参数可选  可选参数必须放在默认参数后面，如果都是可选则没关系，参数不能同时设置可选和默认参数
function buildName(firstName, lastName) {
    if (lastName)
        return firstName + "" + lastName;
    else
        return firstName;
}
//默认参数
function calculate_discount(price, rate = 0.50) {
    var discount = price * rate;
    console.log("计算结果", discount);
}
calculate_discount(1000);
calculate_discount(1000, 0.5);
//剩余参数 不知道要向函数传入多少个参数，可以调用剩余参数
//参数语法允许将一个不确定数量的参数作为一个数组传入
//函数最后一个参数以...为前缀，她将成为一个由剩余参数组成的数组，索引值从0包括到restOfName.leng不包括
function builderName(firstName, ...restOfName) {
    return firstName + '  ' + restOfName.join("");
}
let employeeName = builderName("Joseph", "samuel", "Lucas", "Mackinize");
//...不确定数量的参数
function addNumbers(...nums) {
    var i;
    var sum = 0;
    for (i = 0; i < nums.length; i++) {
        sum = sum + nums[i];
    }
    console.log("和为", sum);
}
addNumbers(1, 2, 3);
addNumbers(10, 10, 10, 10, 10, 10);
//匿名函数 在程序运行时动态声明，除了没有函数名外，其他的与标准函数一样，将匿名函数赋值给一个变量，
//不带参数匿名函数
var msg = function () {
    return "hello 匿名函数";
};
console.log(msg());
//带参数匿名函数
var res = function (a, b) {
    return a * b;
};
console.log(res(12, 18));
//匿名函数自调用
(function () {
    var x = 'hello!!';
    console.log(x);
});
//构造函数
var myFunction = new Function("a", "b", "return a*b");
var x = myFunction(4, 3);
console.log(x);
//箭头函数
var foo = (x) => {
    x = 10 + x;
    console.log(x);
};
foo(10);
function disp(x, y) {
    console.log(x);
    console.log(y);
}
disp("abc");
disp(1, "xyz");
