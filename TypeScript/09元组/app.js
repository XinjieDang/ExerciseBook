//存储的元素数据类型不同，则需要使用元组，元组中允许存储不同类型的元素，元组可以作为参数传递给函数
// 声明一个元组并初始化,包含number 和string
var mytuple = [10, "Runboo"];
//或者先创建空元组，然后在初始化
var mytuple1 = [];
mytuple1[0] = 120;
mytuple1[1] = 234;
//访问元组
console.log(mytuple1[0]);
//元组运算 push() 往元组添加元素，pop()从元组移除元素（最后一个)并返回移除的元素
var mytuple2 = [10, "hello", "World", "TypeScript"];
console.log("添加元素个数", mytuple2.length);
//添加
mytuple2.push(100);
console.log("添加后元素个数", mytuple2.length);
//删除
mytuple2.pop();
console.log("删除后元素个数", mytuple2.length);
//元组是可变的，可以对元组进行更新
var mytuple3 = [10, "aabb", "testbbbb", "myTypeScript"];
console.log("元组第一个元素", mytuple3[0]);
//更新元组元素
mytuple3[0] = 520;
console.log("更新之后元组第一个元素", mytuple3[0]);
