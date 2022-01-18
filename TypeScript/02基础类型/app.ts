/*
any：任意类型，声明为any 的变量可以赋予任意类型的值 
    使用场景：变量的值会动态改变时，比如来自用户的输入，任意值类型可以让这些变量跳过编译阶段的类型检查
    let x:any=1;//数字类型
    x='i am test'；//字符串类型
    x=false; //布尔类型
    //定义存储各种类型的数据
    let arrayList：any[]=[1,false,'fine];
    arrryList[1]=100；






number:数字类型 双精度64位 浮点值，用来表示整数和分数
    let decliteral:number=6
String:字符串类型，一个字符系列，使用单引号''或双引号""来表示字符串类型
    let name:string ="peiqi"
boolean：表示逻辑值true或false
    let flag:boolean=true:
数组类型：声明变量为数组
    //在元素类型后面加上[]
    let arr:number[]=[1,2]  
    //使用泛型数组
    let arr:Array<number> =[1,2]      
元组：类型表示已知元素数量和类型的数组，各元素的类型不必相同，对应位置的类型需要相同。
    let x:[string,number];
    x=['Runoob',1]//运行正常
    x=[1,'Runoob']//运行报错
枚举：enum 定义数值集合
    enum Color {Red,Green,Blue};
    let c:Color=color.Blue;
    console.log(c);//输出2
void:用于标识方法返回值的类型，表示该方法没有返回值
    function hello():void{
        alter("Hello Runnob")
    }
null：表示对象缺失
undefined：用于初始化变量为一个未定义的值
never:其他类型（包括null和 undefined）的子类型，代表从不会出现的值 。never类型的变量只能被never类型所赋值，在函数中它通常表现为抛出异常或无法执行到终止点
let x:never;
let y:never;
x=123 ;//错误，数字类型不能转为never 类型
x=(()=>{throw new Error('exception')});//运行正确          





*/
