//联合类型可以通过|管道符将变量声明未为多种类型，赋值时可以根据设置类型来赋值，只能赋值指定的类型
//声明一个联合类型
var val;
val = 12;
val = "hello world"; //赋值其他就会报错 val=true
//联合类型作为参数使用
function disp(name) {
    if (typeof name == "string") {
        console.log(name);
    }
    else {
        var i;
        for (i = 0; i < name.length; i++) {
            console.log(name[i]);
        }
    }
}
disp("Hello");
console.log("输出数组...");
disp(["good", "study", "FaceBook"]);
//联合类型数组
var arr;
var i;
arr = [1, 2, 4];
console.log("==数字数组==");
for (i = 0; i < arr.length; i++) {
    console.log(arr[i]);
}
arr = ["Runoob", "Google", "Taobao"];
console.log("**字符串数组**");
for (i = 0; i < arr.length; i++) {
    console.log(arr[i]);
}
