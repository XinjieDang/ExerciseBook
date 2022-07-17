### ES6标准入门

#### 1、let命令

let命令用来声明变量，类似var，但是声明的变量只在let命令所在的代码块内有效。

```javascript
{
    let a=10;
    var b=1;
}
//let 只在声明的代码块内有效
console.log(a)//undifined
console.log(b)//1
//for 循环的计数器很适合用let命令
for(let i=0;i<10;i++){
    
}
console.log(i);//报错，计数器i只在for 循环体内有效
```

**不存在变量提升**

`var`命令会发生变量提升现象，即变量可以在声明之前使用，值为`undifined`,`let`改变了这种语法行为，它所声明的变量一定要在声明语句之后才可以使用，否则报错。

```javascript
//var的情况
console.log(foo);//输出undefined
var foo=2;
//let 的情况
console.log(bar);//报错
let bar=1;
```

ES6规定暂时性死区和`let`,`const`语句不出现变量提升，主要是为了减少运行时错误，防止在变量声明前就使用这个变量。

**不允许重复声明**

```javascript
//let 不允许在相同的作用域内，重复声明同一个变量
function func(){
    let a=10;
    var a=1;
}
function func(){
    let a=10;
    let a=1;//报错
}
//不能在函数内部重新声明参数。
function func(arg){
    let arg;
}
func()//报错
function func(arg){
    {
        let arg;
    }
}
func()//不报错
```

#### 2、块级作用域

​	`let`实际上为JavaScript新增了块级作用域。外层代码块不受内层代码块的影响。

```javascript
function f1(){
    let n=5;
    if(true){
        let n=10;
    }
    console.log(n);//5
}
```

**块级作用域与函数声明**

ES6引入了块级作用域，明确允许在块级作用域之中声明函数，块级作用域之中，函数声明语句的行为类似于`let`,在块级作用域之外不可引用。

```javascript
//块级作用域内部的函数声明语句，建议不要使用
{
    let a='secret';
    function f(){
        return a;
    }
}
//块级作用域内部，优先使用函数表达式
{
    let a='secret';
    let f=function(){
        return a;
    }
}
```

#### 3、const 命令

`const`声明一个只读的常量，一旦声明，常量的值就不能改变。

```javascript
//一旦声明变量，就必须立即初始化，不能留到以后赋值，只声明不赋值，就会报错。
const PI=3.1415;
PI//3.1515
PI=3//报错

//const 与let 一样，只在声明的块级作用域内有效。
if(true){
    const MAX=5;
}
MAX;//报错，不能在MAX声明的作用域外使用
//不能在未声明之前使用，也不可重复声明。
```

**const本质**

`const`实际上是保证的，并不是变量的值不得改动，而是变量指向的那个内存地址所保存的数据不得改动，对于简单类型的数据（数值、字符串、布尔值），值就保存在变量指向的那个内存地址，因此等同于常量。

#### 4、变量的结构赋值

ES6允许按照一定模式，从数组和对象中提取值，对变量进行赋值，这被称为解构，**本质上这种写法属于模式匹配。**

只要等号两边的模式相同，左边的变量就会被赋予对应的值。

```javascript
//以前的模式
let a=1;
let b=2;
let c=3;
//ES6 可以从数组中提取值，按照对应位置，对变量赋值
let [a,b,c]=[1,2,3];

//使用嵌套数组
let [foot,[[bar],baz]]=[1,[[2],3]]
foot//1
bar//2
baz//3

let [, , thrid]=['foot','bar','baz'];
thrid//'baz'

let [x,,y]=[1,2,3];
x//1
y//3

let [head,...tail]=[1,2,3,4];
head//1
tail//[2,3,4]


let [x,y,...z]=['a'];
x//a
y//undefined 结构不成功，变量的值就等于undefined
z//[]

let [foo]=[];
let [bar,foo]=[1];

//不完整结构，等号左边只匹配一部分等号右边的数组
let [x,y]=[1,2,3];
x//1
y//2
```

**对象的结构赋值**

与组数不同，数组的元素是按次序排列的，变量的取值由它的位置决定，而对象的属性没有次序

变量必须与属性同名，才能取得正确的值。

```javascript
let{foo,bar}={foo:'aaa',bar:'bbb'};
foo//'aaa'
bar//'bbb'

let {baz}={foo:'aaa',bar:'bbb'};
baz//undefined 没有对应的同名属性
//如果结构失败，变量的值等于`undefined`
let {foo}={bar:'baz'}
foo//undefined
```

对象结构赋值的内部机制，是先找到同名属性，然后在赋给对应的变量，真正被赋值的是后者，而不是前者。

```javascript
let {foo:'foo',bar:bar}={foo:'aaa',bar:'bbb'}

//foo是匹配模式，baz是变量，真正
let{foo:baz}={foo:'aaa',bar:'bbb'};
baz//'aaa'
foo //is not defined
```

#### 5、函数参数的默认值

ES6之前，不能为函数的参数指定默认值

```javascript
function log(x, y) {
  // 若ｙ没有值则等于world＇
  y = y || 'World';
  console.log(x, y);
}
log('Hello') // Hello World
log('Hello', 'China') // Hello China
log('Hello', '') // Hello World
```

ES6允许为函数的参数设置默认值，可以直接写在参数定义的后面。

```javascript
function log(x,y='world'){
    console.log(x,y);
}
log('Hello') // Hello World
log('Hello', 'China') // Hello China
log('Hello', '') // Hello

//另一个例子
function Point(x = 0, y = 0) {
  this.x = x;
  this.y = y;
}
//new 对象的时候不赋值则是默认值
const p = new Point();
p // { x: 0, y: 0 }
```

参数变量是默认声明的，不能用`let`或`const`再次声明。

```javascript
function foo(x = 5) {
  //这里不能再次用let声明。
  let x = 1; // error
  const x = 2; // error
}
```

使用参数默认值时，不能存在有同名函数。

```javascript
// 不报错
function foo(x, x, y) {
  // ...
}
// 报错 同名函数foo
function foo(x, x, y = 1) {
  // ...
}
// SyntaxError: Duplicate parameter name not allowed in this context
```

**与解构赋值默认值结合使用**

```javascript
function foo({x, y = 5}) {
  console.log(x, y);
}
//传参数的时候传{}这种格式
foo({}) // undefined 5
foo({x: 1}) // 1 5
foo({x: 1, y: 2}) // 1 2
foo() // TypeError: Cannot read property 'x' of undefined

//例子2
function fetch(url, { body = '', method = 'GET', headers = {} }) {
  console.log(method);
}
fetch('http://example.com', {})
// "GET"
fetch('http://example.com')
// 报错

```

**默认参数值的位置**

通常情况下，定义了默认值的参数，应该是函数的尾参数，如果非尾部的参数设置默认值，实际上这个参数是不能省略的。

```javascript
// 例一
function f(x = 1, y) {
  return [x, y];
}
f() // [1, undefined]
f(2) // [2, undefined]
f(, 1) // 报错
f(undefined, 1) // [1, 1]
// 例二
function f(x, y = 5, z) {
  return [x, y, z];
}
f() // [undefined, 5, undefined]
f(1) // [1, 5, undefined]
f(1, ,2) // 报错
f(1, undefined, 2) // [1, 5, 2]
```

#### 6、rest参数

ES6引入rest参数（形式为...变量名)，**用于获取函数的多余参数**，这也不需要argument对象了，rest参数搭配的变量是一个数组，该变量将多余的参数放入数组中。

```javascript
function add(...values){
    let sum=0;
    
    for(var val of values){
        sum+=val;
    }
    return sum;
}
//利用rest参数，可以向该函数传入任意数目的参数
add(2,5,3);

//利用rest参数改写数组push方法
function push(array, ...items) {
  items.forEach(function(item) {
    array.push(item);
    console.log(item);
  });
}
var a = [];
push(a, 1, 2, 3)
```

rest参数之后不能再有其他参数，即只能是最后一个参数，否则会抱错。

```javascript
//报错
function f(a,..b,c){
    //
}
```

函数的length属性，不包括rest参数

```javascript
(function(a) {}).length  // 1
(function(...a) {}).length  // 0
(function(a, ...b) {}).length  // 1
```

**name属性**

函数的`name`属性，返回该函数的函数名。

```javascript
function foo(){};
foo.name;//foo

//如果将一个匿名函数赋值给一个变量，es5的name属性，返回空字符串，而es6的name属性会返回实际的函数名。
var f=function(){}
//es5
f.name //''
//es6
f.name //f
//变量f等于一个匿名函数，es5和es6 name属性返回的值不一样
//如果将一个具名函数赋值给一个变量，则es5和ES6的name属性都返回这个具名函数原本的名字
const bar =function baz(){};
//es5
bar.name //baz
//es6
bar.name //baz

//bind返回的函数，name属性值会加上bound前缀。
function foo() {};
foo.bind({}).name // "bound foo"
(function(){}).bind({}).name // "bound "

```

**箭头函数**

ES6允许使用"箭头"(=>)定义函数。

```javascript
var f=v=>v;
//等同于
var f=function(v){
    return v;
}
```

箭头函数不需要参数或者需要多个参数，使用一个圆括号代表参数部分。

```javascript
var f = () => 5;
// 等同于
var f = function () { return 5 };
var sum = (num1, num2) => num1 + num2;
// 等同于
var sum = function(num1, num2) {
  return num1 + num2;
};
```

 箭头函数的代码块多于一条语句，就要使用大括号将他们括起来，并且使用return 语句返回。

```javascript
var sum = (num1, num2) => { return num1 + num2; }
```

由于大括号被解释为代码块，如果箭头函数直接返回一个对象，必须在对象外面加上括号，否则会报错

```javascript
//报错
let getTempItem=id=>{id:id,name:'temp'};
//不报错
let getTempItem=id=>({id:id,name:'temp'})
```

如果箭头函数只有一行语句，没有返回值，可以省略大括号。

```javascript
let fn=()=>void doesNotReturn();
```

箭头函数可以与变量解构赋值结合使用

```javascript
const full=({first,last})=>first+''+last;
//等同于
const full=function(person){
    return person.first+''+person.last;
}
```

箭头函数用于简化回调

```javascript
//正常函数写法
[1,2,3].map(function(x){
    return x*x;
});
//箭头函数写法
[1,2,3].map(x=>x*x);

//另一个例子
var restult=values.sort(function(a,b){
    return a-b;
}
//箭头函数写法
 var result=values.sort((a,b)=>a-b);
```

rest参数与箭头函数结合的例子

```javascript
const numbers=(...nums)=>nums;
numbers(1,2,3,4,5)
//[1,2,3,4,5]
const headAndTail=(head,...tail)=>[head,tail];
headAndTail(1,2,3,4,5)
//1,[2,3,4,5]
```

箭头函数使用注意点

* 函数体内的**`this`对象**，就是**定义时所在的对象**，而不是使用时所在的对象。
* 不可以当做构造函数，也就是说不能使用new命令，否则会抛出错误。
* 不可以使用`arguments`对象，该对象在函数体内不存在。如果要用，可以用 rest 参数代替。
* 不可以使用`yield`命令，因此箭头函数不能用作 Generator 函数。

`this`对象的指向是可变的，但是在箭头函数中，它是固定的

```javascript
function foo(){
    //如果是普通函数，this应该指向全局对象window
    setTimeout(()=>{
        //箭头函数总是指向函数定义时生效时所在的对象（例子中是{id:42})所以输出42
        console.log('id'，this.id);
    },100);
}

var id=21;
foo.call({id:42});
```

箭头函数**总是使this指向固化**，这样有利于封装回调函数，`this`的固定化，并不是因为箭头函数内部绑定有this的机制

实际是箭头函数根本没有自己的this，导致内部的this就是外层代码块的this，正是因为它没有this，所以也不能用作构造函数。

```javascript
fvar handler = {
  id: '123456',
  init: function() {
    document.addEventListener('click',
      //这里的this 总是指向handler对象
      event => this.doSomething(event.type), false);
  },
  doSomething: function(type) {
    console.log('Handling ' + type  + ' for ' + this.id);
  }
};
```

箭头函数转成ES5的代码如下

```javascript
// ES6
function foo() {
  setTimeout(() => {
    console.log('id:', this.id);
  }, 100);
}
// ES5
function foo() {
   //箭头函数根本没有自己的this,而是引用外层的this
  var _this = this;
  setTimeout(function () {
    console.log('id:', _this.id);
  }, 100);
}
```

**不适合使用箭头函数的场景**

由于箭头函数使得`this`从动态变成静态，下面两个场景不应该使用箭头函数。

1、定义对象的方法，且该方法内部包括`this`

```javascript
const cat={
    lives:9,
    jumps:()=>{
        //对象不构成单独的作用域，导致jumps箭头函数定义时的作用域就是全局作用域
        this.lives--;
    }
}
```

2、需要动态`this`的时候，也不应使用箭头函数。

```javascript
//button 的监听函数就是一个箭头函数，导致里面的this就是全局对象，如果改成普通函数
//this就会动态指向被点击的按钮对象

var button=document.getElementById('press');
button.addEvenListener('click',()=>{
    this.classList.toggle('on');
})
```

**尾调用优化**

什么是尾调用？

尾调用是函数式编程的一个重要概念，就是指某个函数的最后一步是调用另一个函数

```javascript
function f(x){
    return g(x);
}
```

以下三种情况不属于尾调用

```javascript
// 情况一
function f(x){
  let y = g(x);
   //赋值之后还有操作
  return y;
}
// 情况二
function f(x){
  return g(x) + 1;
}
// 情况三
function f(x){
  g(x);
}
```

尾调用优化

尾调用之所以与其他调用不同，就在于它的特殊的调用位置

> 函数调用会在内存形成一个“调用记录"，又称调用帧，保存调用位置和内部变量等信息，如果在
>
> 函数A内部调用函数B,那么在A 的调用帧上方，还会形成一个B的调用帧，等到B运行结束，将结果
>
> 返回到A,B的调用帧才会结束，如果函数`B`内部还调用函数`C`，那就还有一个`C`的调用帧，以此类推。所有的调用帧，就形成一个“调用栈”（call stack）。

尾调用由于是函数的最后一步操作，所以不需要保留外层函数的调用帧，因为调用位置、内部变量等信息都不会再用到了，只要**直接用内层函数的调用帧，取代外层函数的调用帧就可以了**。

```java
function f() {
  let m = 1;
  let n = 2;
  return g(m + n);
}
f();
// 等同于
function f() {
  return g(3);
}
f();
// 等同于
g(3);
```

**扩展运输符**

扩展运算符是三个点（...），它好比rest参数的逆运算，将一个数组转换为用逗号分割的参数序列。

```javascript
console.log(...[1,2,3])
//1 2 3
console.log(1,...[2,3,4],5)
//1 2 3 4 5
[...document.querySelectorAll('div')]
// [<div>, <div>, <div>]
```

该运算符主要用于函数调用

```javascript
function push(array,...item){
    //函数调用
   array.push(...item);
}

function add(x,y){
    return x+y;
}
const mumbers=[4,38]
//函数调用
add(...numbers)

```

扩展运算符与正常的函数参数相结合

```javascript
function f(v,w,x,y){}
const args=[0,1]

f(-1,...args,2,...[3]);
```

代替函数的apply方法

扩展运输符可以展开数组，不再需要`apply`方法，将数组转为函数的参数。

```javascript
// ES5 的写法
function f(x, y, z) {
  // ...
}
var args = [0, 1, 2];
f.apply(null, args);
// ES6的写法
function f(x, y, z) {
  // ...
}
let args = [0, 1, 2];
f(...args);
```

扩展运算符可以合并数组

```javascript
const arr1 = ['a', 'b'];
const arr2 = ['c'];
const arr3 = ['d', 'e'];
// ES5 的合并数组
arr1.concat(arr2, arr3);
// [ 'a', 'b', 'c', 'd', 'e' ]
// ES6 的合并数组
[...arr1, ...arr2, ...arr3]
// [ 'a', 'b', 'c', 'd', 'e' ]
```

**数组实例的copyWithin()**

在当前数组内部，将指定位置的成员复制到其他位置（会覆盖原有成员），然后返回当前数组，使用这个方法

会修改当前数组。

```javascript
[1, 2, 3, 4, 5].copyWithin(0, 3)
// [4, 5, 3, 4, 5]
//表示从 3 号位直到数组结束的成员（4和5）,复制从0号位开始的位置，结果覆盖了原来的1 和2
```

**数组实例的find()和findInde()**

`find`方法，用于找出第一个符合条件的数组成员，它的参数是一个回调函数，所有数组成员依次执行该回调

函数，直到找出第一个返回值为true的成员，返回返回该成员，如果没有符合条件的，则返回undefined

```javascript
[1,4,-5,10].find(function (value,index,arr){
    return value>9;
})
//返回 10

find方法的函数所接受三个参数，当前值，当前的位置，原数组。
```

实例的findIndex方法，返回符合条件的第一个值的位置索引，若不符合则返回-1。

```javascript
[1, 5, 10, 15].findIndex(function(value, index, arr) {
  return value > 9;
}) // 2
```

这两个方法都可以接受第二个参数，用来绑定回调函数的this对象。

```javascript
function f(v){
  return v > this.age;
}
let person = {name: 'John', age: 20};
[10, 12, 26, 15].find(f, person);    // 26
```

**数组实例的fill()**

fill方法使用给定值，填充一个数组，fill方法用于空数组的初始化非常方便。

```javascript
['a','b','c'].fill(7)
//[7,7,7]
new Array(3).fill(7)
//[7,7,7]
```

`fill`方法还可以接受第二个和第三个参数，用于**指定填充的起始位置**和**结束位置**

```javascript
['a', 'b', 'c'].fill(7, 1, 2)
//fill方法从 1 号位开始，向原数组填充 7，到 2 号位之前结束
// ['a', 7, 'c']

```

若填充的类型为对象，那么被赋值的是同一个内存地址的对象，而不是深拷贝对象。

```javascript
let arr = new Array(3).fill({name: "Mike"});
arr[0].name = "Ben";
arr
// [{name: "Ben"}, {name: "Ben"}, {name: "Ben"}]
let arr = new Array(3).fill([]);
arr[0].push(5);
arr
// [[5], [5], [5]]
```

**数组实例的entries()，keys()和values()**

ES6提供三个新方法`entries()`，`keys()`和`values()`用于遍历数组，返回一个遍历器对象，

可以用`for...of`循环进行遍历，唯一的区别是keys()是对键名的遍历、values()是对键值的遍历

`entries()`是对键值对的遍历.

```javascript
for (let index of ['a', 'b'].keys()) {
  console.log(index);
}
// 0
// 1
for (let elem of ['a', 'b'].values()) {
  console.log(elem);
}
// 'a'
// 'b'
for (let [index, elem] of ['a', 'b'].entries()) {
  console.log(index, elem);
}
// 0 "a"
// 1 "b"

//不使用for..of 可以手动调用遍历器对象的next方法
let letter = ['a', 'b', 'c'];
let entries = letter.entries();
console.log(entries.next().value); // [0, 'a']
console.log(entries.next().value); // [1, 'b']
console.log(entries.next().value); // [2, 'c']
```

**数组实例的includes()**

该方法返回一个布尔值，表示某个数组是否包含给定的值，与字符串的Includes方法类似

```javascript
[1, 2, 3].includes(2)     // true
[1, 2, 3].includes(4)     // false
[1, 2, NaN].includes(NaN) // true
```

Map与Set 数据结构有一个`has`方法，需要注意与`includes`区分。

* Map结构的`has`方法，用来查找键名，比如`Map.prototype.has(key)`,`WeakMap.prototype.has(key)`,`Reflect.has(target, propertyKey)`
* Set结构的`has`方法，用来查找值，比如`Set.prototype.has(value)`,`WeakSet.prototype.has(value)`'

