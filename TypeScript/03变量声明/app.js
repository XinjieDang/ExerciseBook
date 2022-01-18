/*
变量是一种方便的占位符，用于引用计算机类型地址，把变量看做存储数据的容器
TypeScript 变量的命名规则
    变量名可以包含数字和字母
    除了下划线_和美元$符合外，不能包含其他特殊字符，包括空格
    变量名不能以数字开头
    变量名 使用前必须声明，使用var
    var [变量名]:[类型]=值；
*/
var uname = 'Runoob';
var score1 = 50;
var score2 = 45.20;
var sum = score1 + score2;
console.log("名字", uname);
console.log("第一个科目成绩", score1);
console.log("第二个科目成绩", score2);
console.log("总成绩", sum);
//TypeScript 遵循强类型，如果将不同类型赋值给变量会编译错误，如下实例
//var num:number='hello'  编译错误
//类型断言 手动指定一个值的类型，即允许变量从一种类型更改为另一种类型<类型>值  或值 as 类型
/*
var str='1'
var str2:number=<number><any> str //str、str2是string 类型
console.log(str2)


//变量作用域指定了变量定义的位置，变量的可用性由变量作用域决定
    全局作用域：全局变量定义在程序结构的外部，可用在代码任何位置使用
    类作用域：也可以成为字段，变量类声明在一个类里头，但在类的方法外面，但在类的方法外面，该变量可以通过类的对象来访问，类变量页可以是静态的
    局部作用域：局部变量，局部变量只能在声明他的一个代码块
*/
var global_num = 12; //全局变量
class Numbers {
    constructor() {
        this.num_val = 13; //实例变量
    }
    storeNum() {
        var local_num = 14; //局部变量
    }
}
Numbers.sval = 10; // 静态变量
