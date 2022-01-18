/*
Map 对象保存键值对，并且能够记住键的原始插入顺序，任何值（对象或者原始值)都可以作为一个键或一个值

*/
//创建TypeScript使用Map和new 关键字来创建Map;
let myMap = new Map();
//初始化Map,可以以数组的格式来传入键值对
let myMa2 = new Map([
    ["key1", "value1"],
    ["key2", "value2"]
])


let nameSiteMapping = new Map();
//设置map对象
nameSiteMapping.set("Google", 1);
nameSiteMapping.set("test", 2);
nameSiteMapping.set("setMap", 3);
//获取键对应的值’
console.log(nameSiteMapping.get("test"));
console.log(nameSiteMapping.get("Google"))

//判断map中是否包含键对应的值
console.log(nameSiteMapping.has("test"))
//返回map中对象键/值对的数量
console.log(nameSiteMapping.size)

//删除键
nameSiteMapping.delete("test")
//移除map 所有对应的键值对
nameSiteMapping.clear();
//迭代map
let testNameMap = new Map();
testNameMap.set("test", 1);
testNameMap.set("test1", 2);
testNameMap.set("test3", 3)

//迭代map中的key 
for (let key of testNameMap.keys()) {
    console.log(key)
}
//迭代map中的value
for (let value of testNameMap.values()) {
    console.log(value)
}

//迭代map中的key=>value
for (let entry of testNameMap.entries()) {
    // 0 key 1  value 
    console.log(entry[0], entry[1])
}

//使用对象解析
for (let [key, value] of testNameMap) {
    console.log(key, value);
}