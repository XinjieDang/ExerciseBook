// 1、安装TypeScript npm install -g typescript
// 2、查看typescript 版本  tsc-v
// 说明 使用.ts 后缀作为TypeScript 代码文件的扩展名
// 3、使用tsc app.ts 将TypeScript 代码转化为Javascript 的代码
// 4、使用node app.js命令来执行app.js 文件，可以同时编译多个ts文件：tsc file1.ts file2.ts file3.ts
// 第一个TypeScirpt 程序
var message = 'hello World';
console.log(message);
//TypeScript 面向对象编程实例
class Site {
    //定义了一个类Site，方法name(),无返回值，输出"Runoob"
    name() {
        console.log("Runoob");
    }
}
//new 关键字创建类的对象，调用该对象的方法name();
var obj = new Site();
obj.name();
