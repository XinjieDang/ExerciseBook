/* TypeScript 与 JavaScript 类似，支持 Number 对象。

     Number 对象是原始数值的包装对象。
     一个参数不能转化为一个数字，将返回NaN;
*/

var num = new Number(1);


//protorype实例
function employess(id: number, name: string) {
    this.id = id;
    this.name = name;
}
var emp = new employess(123, "admin");

employess.prototype.email = "admin@qqqq.com";
console.log("员工id", emp.id);
console.log("员工姓名", emp.name);
console.log("员工邮箱", emp.email);
