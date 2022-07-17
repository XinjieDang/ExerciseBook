# TypeScript 入门教程

### 1、什么是TypeScript？

TypeScript有两个最重要的特性，类型系统、适用于任何规模。

**TypeScirpt是静态类型**

类型系统按照类型检查的时机分类，可分为动态类型和静态类型。

* 动态类型：是指运行时才进行类型检查，语言的错误只有在运行时才能检测出来。javaScript是一门解释语型语言，没有编译阶段，所以它是动态类型。
* 静态类型：是指编译阶段就能确定每个类型的变量，这种语言的类型错误往往会导致语法错误，TypeSctipt在运行前需要编译为javaScript，而在编辑阶段进行类型检查，所以TypeScript是静态类型，在编辑阶段就能检查出错误。

**TypeScript是弱类型**

类型系统按照是否允许隐式类型转换来分类，可以分为强类型和弱类型，TypeScript是完全兼容JavaScript的，它不会修改JavaScript运行时的特性，所以都是弱类型，**JavaScript 和 TypeScript 中不管加号两侧是什么类型，都可以通过隐式类型转换计算出一个结果**。

类型系统体现了TypeScript的核心设计理念，在完整保留JavaScript运行时行为的基础上，通过引入静态类型系统来提高代码的可维护性，减少可能出现的bug。

TypeScript非常适用于大型项目，类型系统可以为大型项目带来更高的可维护性。

###   2、安装TypeScript 

全局安装`tsc`命令，安装完成后可以在任何地方执行`tsc`命令。

```shell
npm install -g typescript
```

编译一个TypeScript文件‘

```shell
tsc hello.ts
```

编辑器推荐 Visual studio code

### 3、基础

#### 原始数据类型

JavaScript 的类型分为两种：原始数据类型（[Primitive data types](https://developer.mozilla.org/en-US/docs/Glossary/Primitive)）和对象类型（Object types）。原始数据类型包括：**布尔值、数值、字符串、`null`、`undefined` 以及 ES6 中的新类型 [`Symbol`](http://es6.ruanyifeng.com/#docs/symbol) 和 ES10 中的新类型 [`BigInt`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/BigInt)。**

###### 布尔值

使用`boolean`定义布尔值类型

```typescript
let isDone:boolean=false;
//使用构造函数`Boolean创造的对象不是布尔值：
let createByNewBoolean:boolean=new Boolean(1);
```

###### 数值

使用`number`定义数值类型

```typescript
let hextList:number=6;
//ES6中二进值语法
let binaryLiteral:number=0b10110;
```

###### 字符串

使用`string`定义字符串类型

```typescript
let MyName:string='Tom';
//使用ES6模板字符串
let strHello:string=`Hello my name is${MyName}`;
```

###### 空值

JavaScript 没有空值(Void)的概念，在TypeScript中，可以用`Void`表示没有任何返回值的函数：

```typescript
function alertName():void{
    alert("my name is Tom");
}
```

声明一个变量为`void`类型的变量没什么用，只能将它赋值为`undefined`和`null`。

```typescript
let unusable:void=undefined;
```

###### Null和Undefined

在TypeScript中，可以使用`null`和`undefined`来定义两个原始数据类型。

```typescript
let u:undefined=undefined;
let n:null=null;
//这样不会报错
let num:number=u;
```

与`void`的区别是：

`undefined`和`null`是所有类型的子类型，undefined类型的变量可以赋值给`number`类型的变量。

但是`void`类型的变量不能复制给`number`类型的变量。

```typescript
let voidStr:void=void;
//这样报错
let sum:number=voidStr;
```

###### 任意值

任意值(any)，表示允许赋值为任意类型。

如果是普通类型，在赋值中改变类型是不被允许的：

```typescript
let myFnumber:string="serven";
//报错，不允许
myFnumber=7;
```

但是`any`类型则被允许赋值为任意类型。可以认为，声明一个变量为任意值之后，对它的操作，返回的类型都是任意值类型。

```typescript
let Myfa:any='seven';
Myfa=7;
```

###### 未声明类型的变量

变量如果在声明的时候，未指定值类型，那么它会被识别为任意值类型

```typescript
let dosomeing;
dosomeing='seven';
dosomeing=7;
```

###### 类型推论

如果没有明确指定的类型，那么TypeScript 会依照类型推论规则推断出一个类型。

```typescript
let myFavoriteNumber='seven';
myFavoriteNumber=7;

//等价于
let myFavoriteNumber:string='seven';
myFavoriteNumber=7;

```

如果定义的时候没有赋值，不管之后有没有赋值，都会被推断成`any`类型而完全不被类型检查；

```TYE
let myFnNumber;
myFnNumber='seven';
myFnNumber=7
```

###### 联合类型

联合类型表示取值可以为多种类型种的一种,使用|分隔符分割类型。

```typescript
let myFunumber:string|number;
myFunumber='seven';
myFunumber=7;
```

`string|number`的含义是 允许myFunumber的类型是`string`或者`number`，但是不能是其他类型。

**访问联合类型的属性和方法**

当TypeScript不确定一个联合类型的变量到底是哪个类型的时候，只能访问此联合类型的所有类型里共有的属性和或方法。

```typescript
function getString(something:string|number):string{
    //toString 是sring 和number 的共有属性
    return something.toString();
}
```

联合类型变量在赋值的时候，会根据类型推论规则推断一个类型。

```typescript
let myfanumber:string|number;
myfanumber='seven';
console.log(myfanumber.lenght);//推断成为string,不会报错
myfanumber=7;//推断为number
console.log(myfanumber.lenght);//再次编译，会出错，number没有.length 属性。
```

###### 接口

在面向对象语言中，对象是对行为的抽象，具体的如何行动需要类去实现。

在TypeScript 中，接口是一个很灵活的概念，除了可用于对类的一部分进行抽象以外，也常于对对象的形象进行描述。

```typescript
//接口名称一般大写，有的接口名称前缀会加上I
interface Person{
    name:string;
    age:number;
}
//定义一个变量，类型是Person ,这样就约束了tom 的形状必须和接口Person一致。
let tom:Person={
    name:'Tom'，
    age:18
}
//定义的变量比接口少一些属性是不允许的。
let alin:Peson={
    name:'Alin'
}
//定义的变量比接口多一些属性也是不允许的。因此，赋值的时候必须和接口一致。
let yase:Peron={
    name:'Yase';
    age:18;
    gender:'maele'
}
//可以在接口属性前面加个？表明这是可选属性，该属性可以不存在。

interface Person{
    name:string;
    //可选属性
    age?:number;
}
//但是定义的变量不允许添加接口中未定义的属性
let libai:Person={
    name:'libai',
    age:25,
    //不能定义这个接口中没有的属性。
    genger:'male'
}
//接口中可以有一个任意属性
interface Person{
    name:string,
    age:number,
    //使用[propName:string]定义了任意属性取string类型的值
    //一旦定义了任意属性，那么确定属性和可选属性的类型都必须是它的类型的子集
    [propName:string]:string
}

let dw:Person={
    name:'Dw',
    //上面定义了任意属性的值类型string，但是可选属性的值却是number 25，number不是string的子集，会报错。
    age:25,
    gender:'male'
}

//一个接口中只能有一个任意属性，如果接口中有多个类型的值，则可以在任意属性中使用联合类型。
interface Person{
    name:string;
    age?:number;
    [propName:string]:string|number;
}

let xhd:Person={
    name:'Xhd',
    //age不会报错，number在任意属性的子集中
    age:25,
    gender:'male'
}
//只读属性,希望对象中的一些字段只能在创建的时候被赋值，可以用readony定义只读属性
interface Person{
    readonly id:number;
    name:string,
    age?:number,
}

let Ase:Peron={
    id:'8881',
    name:'Ase',
    gender:'male'
}
//报错，只读属性不能在赋值
Ase.id=8882;

```

###### 数组的类型

类型+方括号 表示法

```typescript
let fibonacci:number[]=[1,2,3,4,5,6]
//数组的项中不允许出现其他类型
let fibonacci:number[]=[1,'2',3,4,5,6]
//数组方法的参数也会根据数组在定义时约定的类型进行限制
let fibonacci:number[]=[1,2,3,4,5,6];
//报错，push方法只允许传入number类型的参数。
fibonacci.push('7')
```

###### 数组泛型

使用数组泛型`Array<elemType>`来表示数组。

```typescript
let fibonacci:Array<number>=[1,2,3,4,5,6]
```

###### 用接口表示数组

```typescript
interface NumberArray{
    //只要索引的类型是数字时，那么值的类型必须是数字
    [index:number]:number;
}
let fibonacci:NumberArray=[1,1,1,2,1,21,21];
```

###### 类数组

###### any在数组中的应用

用any 表示数组中允许出现任意类型

```typescript
let list:any[]=['xiaoxin',25,{webside:'http:sssxx.com'}];
```

###### 函数的类型

函数声明

两种常见的定义函数的方式---函数声明和函数表达式

```typescript
//函数声明
function sum(x,y){
    return x+y;
}
//函数表达式
let mySum=function(x,y){
    return x+y;
}
```

在TypeScrip中，要对函数的输入和输出进行约束

```typescript
function sum(x:number,y:number):number{
    return x+y;
}
//输入多余的或少于要求的参数是不被允许的
sum(1,2,3);//报错，参数不对
```

###### 函数表达式

定义一个函数表达式

```typescript
let mySum=function(x:number,y:number):number{
    return x+y;
}
//上述表达式只对等号右侧匿名函数进行了类型定义，而左边的mySum是通过赋值操作进行类型推论而推断出来的
//若需要手动给mySum加类型，则
let mySum:(x:number,y:number)=>number=function(x:number,y:number):number{
    return x+y;
}
//Typescript 中 =>用来表示函数的定义，左边是输入类型，需要用括号括起来，右边是输出类型
```

###### 用接口定义函数的形状

```typescript
interface SearchFunc{
    (source:string,subString:string):boolean;
}

//定义一个函数，类型为SearchFunc,对等号左侧进行类型限制，可以保证以后对函数名赋值时保证参数个数、参数类型、返回值不变
let mySearch:SearchFunc;
mySearch=function(source:string,subString:string){
    return source.search(subString)！==-1；
    
}
```

###### 可选参数

可以用`?`表示可选的参数

```typescript
function buildName(firstName:string,lastName?:string){
    if(lastName){
        return firstName+''+lastName;
    }else{
        return firstName;
    }
}
let tomcat=buildName('tom','cat');
let tom=buildName('tom')

//特别注意，可选参数必须接在必须参数后面，可选参数后面不允许再出现必须参数了
function buildName(firstName?:string,lastName:string){
     if(firstName){
        return firstName+''+lastName;
    }else{
        return lastName;
    }
}
//会报错
let tomcat=buildName('tom','cat');
let tom=buildName(undefined,'tom')
```

###### 参数默认值

在ES6中，允许给函数的参数添加默认值，TypeScript会将添加了 默认值的参数识别为可选参数。

````typescript
function buildName(firstName:string,lastName:string='cat'){
    return firstName+''+lastName;
}
let tomcat=buildName('tom','cat');
let tom=buildName('tom');
//添加默认参数后不受可选参数必须在默认参数后面的限制了。
function buildName(firstName:string='tom',lastName:string='cat'){
    return firstName+''+lastName;
}
let tomcat=buildName('tom','cat');
let tom=buildName(undefined,'tom')

````

###### 剩余参数

在ES6中，可以使用`...rest`的方式获取函数中的剩余参数（rest参数)；

```typescript
function push (array,...items){
    items.forEach(function(item){
        array.push(item);
    })
}
let a:any[]=[];
push(a,1,2,3)

//实际items是一个数组，可以用数组的定义
function push(array:any[],...item:array[]){
     items.forEach(function(item){
        array.push(item);
    })
}
let a:any[]=[];
push(a,1,2,3)
```

###### 重载

重载允许一个函数接受不同数量或类型的参数时，做出不同的处理。

###### 类型断言

语法：值 as 类型或 <类型>值

断言的用途

将一个联合类型断言为其中一个类型

当TypeScript不确定一个联合类型的变量到底是哪个类型的时候，只能访问此联合类型的所有类型中的共有

属性或方法：

```typescript
interface Cat{
    name:string;
    run():void;
}
interface Fish{
    name:string;
    swim():void;
}
function getName(animal:Cat|Fish){
    return animal.name;
}
```

有时候，需要在还不确定类型的时候就访问其中一个类型特有的属性和方法

尽量避免断言后调用方法或引用深层属性

```typescript
interface Cat{
    name:string;
    run():void;
}
interface Fish{
    name:string;
    swim():void;
}

function isFish(animal:Cat|Fish){
    if(typeof(animal as Fish).swim==='function'){
        return true;
    }
    return false;
}


```

**将一个父类断言为更加具体的子类**

当类之间有继承关系时，类型断言

```typescript
class AipError extends Error{
    code:number=0;
}
class HttpError extends Error{
    statusCode:number=200;
}

function isAipError(error:Error){
    //判断传入的参数 是不是ApiEoor类，由于父类中没有code 属性，故直接获取error.code会报错，
    //需要使用类型断言获取
    if(typeof (error as AipError).code=='number'){
        return true;
    }
    return false;
}

//上述例子也可以使用instanceof来判断error是否是它的实例
function isAipError(error:Error){
    //使用instanceof比较合适，因为AipError是JavaScript的类，能够通过instanceof 来
    //判断error是否是它的实例。
    if(error instanceof AipError){
        return true;
    }
    return false;
}
//有的情况AipError是一个接口，接口是类型，不是真正的值，此时只能使用类型断言

```

将任何一个类型断言为`any`

理想情况下，TypeScript的类型系统运转良好，每个指都具体而精确，

当引用一个在此类型上不存在的属性或方法时，就会报错：

```typescript
const foo:number=1;
//报错，数字类型变量没有length属性的
foo.length=1;

```

但有时候非常确定这段代码不会出错，

```typescript
//在window上添加一个属性foo,但TypeScript编译时会报错，提示window上不存在foo属性
window.foo=1;
//此时可以用as any 临时将window断言为any类型,在any 类型的变量上，访问任何属性都是允许的。
(window as any).foo=1;
//注意的是，将一个变量断言为any可以说是解决TypeScript中类型问题的最后一个手段。
//它极有可能掩盖了真正的错误类型，所以如果不是非常确定，就不要用as any
```

###### 声明文件

当使用第三方库时，需要引用它的声明文件，才能获得对应的代码补全，接口提示等功能。

**新语法**

* declare var 声明全局变量
* declare funciton 声明全局方法。
* declare class 声明全局类
* declare enum 声明全局枚举类型
* declare namespace 声明含有子属性的全局对象
* interface 和type声明全局类型
* export 导出变量
* export namespace导出含有子属性的对象
* export default ES6默认导出
* export=commonjs 导出模块
* export as namespace  UMD库声明全局变量
* declare global 扩展全局变量
* declare module扩展模块
* ///<reference/>三斜线指令

**什么是声明语句？**

假如使用第三方库，一种常见的是在html中通过`<script>`，标签引入Jquery，然后就可以

使用全局变量$或jquery了

通常获取一个id是foo的元素

```js
$('#foo');
//在TS中编译器不知道$是什么东西
JQuery('#foo');
```

在TS中

```typescript
//declare 并不是真正定义一个变量，只是定义 了全局变量jquery的类型，仅仅会用于编译时期的检查。
declare var JQuery:(selector:string)=>any;
JQuery('#')
```

`什么是声明文件`

通常会把声明语句放到一个单独的文件（jquery.d.ts）中，这就是声明文件，必须以.d.ts为后缀。

一般来说，ts会解析项目中所有的*.ts文件，也包括.d.ts结尾的文件，当我们将jquery.d.ts 放到项目中时，其他

所有*.ts文件就都可以获得jQuery的类型定义了。

```typescript
//src/jquery.d.ts
declare var JQuery:(selector:string)=>any;

//在src/index.ts
JQuery('#foo');
```

###### 内置对象

###### 类型别名

类别别名用来给一个类型起个新名字

```typescript
type Name=string;
//用Type创建类型别名，类型别名常用于联合类型。
type NameResolver=()=>string;
type NameOrResolver=name|NameRsolver;
function getName(n:NameOrResolver):Name{
    if(typeof n==='string'){
        return n;
    }else{
        return n();
    }
}
```

###### 字符串字面量类型

字符串字面量类型用来约束取值只能是某几个字符串中的一个。

```typescript
//用type定一个字符串字面量类型EventNames,它只能取三种字符串中的一种。
//类型别名和字符串字面量类型都是使用type进行定义。
type EventName='click'|'scroll'|'mousemove';
function handleEvent(ele:Element,event:EventNames){
    //do something 
}
//调用
handleEvent(document.getElementById('hello'),'scroll');
handleEvent(document.getElementById('world'),'scrollsss');//报错
```

###### 元组

数组合并了相同类型的对象，而元组（Tuple）合并了不同类型的对象

```typescript
//定义一对值为string 和number的元组
let tom:[string,number]={'tom',25};
//当赋值或访问一个已知索引的元素时，会得到正确的类型
let tom:[string,number];
```





