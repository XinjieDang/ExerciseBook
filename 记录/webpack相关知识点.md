### webpack相关知识点

#### 1、概念

本质是一个现代JavaScript应用程序的**静态模块打包器**，当webpack处理应用程序时，会递归的构建一个**依赖关系图**，图中包含应用程序需要的每个模块，将这些模块打包成一个或多个bundle。

##### 四个核心概念

* 入口（entry)
* 输出（output)
* loader
* 插件（plugins)

###### 入口

入口起点指示webpack应该使用哪个**模块来作为构建其内部依赖图的开始**，每个依赖项会被处理，最后输出到称为bundle的文件中，以下是基础配置。

```javascript
module.exports={
    entry:'./path/to/my/entry/file.js'
}
```

###### 出口

output属性告诉webpack**在哪里输出它所创建的bundles**，以及如何命名这些文件，默认值为`./dist/`,

本质上，**整个应用程序结构都会编译到指定的输出路径的文件夹中**，通过 **配置`output`字段**来配置这些处理过程。

**webpack.config.js**

```javascript
const path = require('path');
module.exports = {
  //入口
  entry: './path/to/my/entry/file.js',
  //出口
  output: {
    path: path.resolve(__dirname, 'dist'),
    //构建后输出的文件名
    filename: 'my-first-webpack.bundle.js'
  }
};
```

###### loader

loader让webpack能够处理非JavaScript文件（webpack自身只能理解JavaScript），loader可以将所有类型的**文件转换为webpack能够处理的有效模块**，本质：webpack loader将所有类型文件转换为程序的依赖图和最终bundle可以直接引用的模块。

loader有两个目标：

* test属性：用于标识出应该被对应的loader进行转换的某个或某些文件。
* use属性：表示进行转换时，应该使用哪个loader。

```javascript
const path = require('path');
const config = {
  output: {
    filename: 'my-first-webpack.bundle.js'
  },
  module: {
    //在遇到.txt的路径时，在打包之前，指定使用raw-loader转换一下。
    rules: [
      { test: /\.txt$/, use: 'raw-loader' }
    ]
  }
};
module.exports = config;
```

###### 插件

插件的范围包括从打包优化和压缩，一直到重新定义环境中的变量，使用一个插件，需要`require`它，然后把它添加`plugins`数组中。

```javascript
const HtmlWebpackPlugin = require('html-webpack-plugin'); // 通过 npm 安装
const webpack = require('webpack'); // 用于访问内置插件
const config = {
  module: {
    rules: [
      { test: /\.txt$/, use: 'raw-loader' }
    ]
  },
  plugins: [
    new HtmlWebpackPlugin({template: './src/index.html'})
  ]
};
module.exports = config;
```

###### 模式

通过选择 `development` 或 `production` 之中的一个，来设置 `mode` 参数，你可以启用相应模式下的 webpack 内置的优化。

```javascript
module.exports = {
  mode: 'production'
};
```



