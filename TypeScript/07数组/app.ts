//数组对象是使用单独的变量名来存储一系列的值
//声明时初始化,若声明时为设置类型，则会被认为是any 类型，在初始化时根据第一个元素的类型来推断数组的类型
//var array_name[:data type] = [val1,val2…valn]
//创建一个number 类型的数组
var numlist: number[] = [2, 4, 6, 8]
//创建一个String  类型的数组
var sites: string[];
sites = ["Goodle", "Runoob", "Taobao"];
//根据索引值来访问数组元素
console.log(sites[0]);

//声明时直接初始化数组
var nums: number[] = [1, 2, 3, 4];

// 使用array对象创建数组
var arr_names: number[] = new Array(4);//指定数组初始化大小
for (var i = 0; i < arr_names.length; i++) {
    arr_names[i] = i * 2;
    console.log(arr_names[i])
}

//直接初始化数组
var sitesString: string[] = new Array("Google", "Runoob", "Taobao", "FaceBook")


//数组结构
var arr: number[] = [12, 13];
var [x, y] = arr;//将数组的两个元素赋值给变量x 和y



//数组在函数中的作用 
//作为参数传递给函数
var sitesStra: string[] = new Array("Google", "Hello", "Test", "Study");

function disp(array_sites: string[]) {
    for (var i = 0; i < array_sites.length; i++) {
        console.log(array_sites[i])
    }
}

disp(sitesStra);
//数组作为函数的返回值
function dispBook(): string[] {
    return new Array("GOOD", "盗将行", "雪中悍刀行")
}

var sitesBook = dispBook();


for (var i = 0; i < sitesBook.length; i++) {
    console.log(sitesBook[i])
}