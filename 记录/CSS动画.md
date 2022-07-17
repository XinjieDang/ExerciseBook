### CSS动画

#### 什么是CSS动画？

动画元素逐渐从一种样式变为另一种样式，可以随意更改任意数量的CSS属性,如需使用CSS动画，必须为动画指定一些关键帧。关键帧包含元素在特定时间所拥有的样式。

#### `@keyframes`规则

在`@keyframes`规则中指定了CSS样式，动画将在特定时间逐渐从当前样式更改为新样式。要使动画生效，必须将动画绑定到某个元素。

```css
/*添加动画*/
@keyframes example{
    //from与0% 代表开始，可以使用百分比，设置样式何时改变
    from{
        background-color:red;
    }
    //to与100% 代表结束
    to{
        background-color:yellow;
    }
}
/*应用动画*/
.div{
    width:100px;
    height:100px;
    background-color:red;
    animation-name:example;
    //定义需要多长时间才能完成动画，如果不指定则动画不会发生，因为默认是0s
    animation-duration:4s;
}
```

延迟动画`animation-delay`属性规定动画开始的延迟时间

```css
div {
  width: 100px;
  height: 100px;
  position: relative;
  background-color: red;
  animation-name: example;
    //定义4s 完成该动画
  animation-duration: 4s;
    //动画开始前有2s的延迟
  animation-delay: 2s;
  //如果使用负值，则动画开始播放，如同已播放N秒，动画开始播放，就像已经播放了2s
  animation-delay: -2s;
}
```

#### 设置动画应运行多少次。

`animation-iteration-count`属性指定动画应运行的次数。

```css
div {
  width: 100px;
  height: 100px;
  position: relative;
  background-color: red;
  animation-name: example;
  animation-duration: 4s;
  //在停止前把动画运行3次
  animation-iteration-count: 3;
  //infinite使动画永远持续下去 
  animation-iteration-count: infinite;
}
```

#### 反向或交替运行动画

`animation-direction`属性指定的向前播放，向后播放还是交替播放动画。

可接受以下值

* normal-动画正常播放（向前)默认值。
* reverse-动画以反方向播放（向后)
* alternate-动画先向前播放，然后向后
* alternate-reverse-动画先向后播放，然后向前

#### 指定动画的速度曲线

`animation-timing-funciton`属性规定动画的速度曲线。

可接受以下值

* ease-指定从慢速开始，然后加快，然后缓慢结束的动画
* linear-规定从开始到结束的速度相同的动画
* ease-in-规定慢速开始的动画
* ease-out-规定慢速结束的动画

![image-20220321163736369](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20220321163736369.png)

#### transform

`transform`属性允许你旋转，缩放，倾斜或平移给定元素，通过修改CSS视觉格式化模型的坐标空间来实现。

只能转换由盒模型定位的元素，transform 默认值为none