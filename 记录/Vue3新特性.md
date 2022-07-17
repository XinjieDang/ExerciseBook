### Vue3新特性

* `$attrs`：父组件给子组件关联数据，子组件不用props接收，那么这些数据就作为普通的HTML特性应用在子组件的根元素上。可以通过`inheritAttrs=false`来控制这些特性是否显示在dom元素上。
* `$slots`：用来访问被`slot`分发的内容，每个具名`slot`有其相应的属性，例如`slot='foot'`中的内容将会在`vm.$slots.foot`中被找到。
* $emit：子组件可以使用`$emit`让父组件监听到自定义事件，`vm.$emit(eventName,arg)`,`vm.$on(event,fn)`监听事件后运行。
* $parent：当前组件树的根Vue实例，如果当前实例没有父实例，此实例将会是自己，可以获取到组件的实例，就可以调用组件的属性和方法。
* $children：当前实例的直接子组件，`$children`并不保证顺序，也不是响应式的
* $root：与`$parent`都能实现访问父组件的属性和方法，两者的区别在于如果存在多级子组件，通过`$parent`访问得到的是它最近一级的父组件，通过`$root`访问得到的是根组件。

#### Vue3新特性

#####  （1）setup函数

`setup`函数也是`Composition API`的入口函数，变量、方法都是在该函数中定义。

```vue
<template>
  <div id="app">
      <p>{{ number }}</p>
      <button @click="add">增加</button>
  </div>
</template>

<script>
// 1. 从 vue 中引入 ref 函数
import {ref} from 'vue'
export default {
  name: 'App',
  setup() {
      // 2. 用 ref 函数包装一个响应式变量 number
      let number = ref(0)

      // 3. 设定一个方法
      function add() {
          // number是被ref函数包装过了的，其值保存在.value中
          number.value ++
      }

      // 4. 将 number 和 add 返回出去，供template中使用
      return {number, add}
  }
  
}
</script>
```

可以将 `ref` 函数包装过的变量看作是Vue2 `data` 中的变量。

在vue3中，`this`指向的是`undefined`，不能像vue2中通过`this`hi获取变量。

`setup`函数有两个参数，分别是`props`,`context`前者存储着定义当前组件允许外界传递过来的参数名称以及对应的值；后者是一个上下文对象，能从中访问到`attr`,`emit`，`slots`，`emit`就是我们熟悉的Vue2中与父组件通信的方法，可以直接拿来调用。

##### （2）生命周期

Vue2中有`beforeCreate`，`create`，`beforeMount`，`mounted`，`beforeUpdate`，等生命周期函数。，以下是Vue3的变化图。

![image-20220308104456403](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20220308104456403.png)

使用先中`vue`中导入，再直接进行调用。

```vue
<script>
// 1. 从 vue 中引入 多个生命周期函数
import {onBeforeMount, onMounted, onBeforeUpdate, onUpdated, onBeforeUnmount, unMounted} from 'vue'
export default {
  name: 'App',
  setup() {
      onBeforeMount(() => {
          // 在挂载前执行某些代码
      })

      onMounted(() => {
          // 在挂载后执行某些代码
      })

      onBeforeUpdate(() => {
          // 在更新前前执行某些代码
      })

      onUpdated(() => {
          // 在更新后执行某些代码
      })

      onBeforeUnmount(() => {
          // 在组件销毁前执行某些代码
      })

      unMounted(() => {
          // 在组件销毁后执行某些代码
      })

      return {}
  }
  
}
</script>
```

##### （3）reactive

`reactive`用来创建一个响应式数据对象，该API很好的解决了Vue通过`defineProperty`实现数据响应式的缺陷。

```vue
<template>
  <div id="app">
  	<!-- 4. 访问响应式数据对象中的 count  -->
  	{{ state.count }}
  </div>
</template>

<script>
// 1. 从 vue 中导入 reactive 
import {reactive} from 'vue'
export default {
  name: 'App',
  setup() {
      // 2. 创建响应式的数据对象
      const state = reactive({count: 3})

      // 3. 将响应式数据对象state return 出去，供template使用
      return {state}
  }
}
</script>
```

##### （4）ref

在介绍`setup`函数时，使用`ref`函数包装了一个响应式数据对象，表面上看上去和`reactive`功能差不多，因为`ref`就是通过`reactive`包装了一个对象，然后是将值传递给对象中`value`属性，这也就解释了为什么每次访问时我们都需要加上`.value`，可以简单的理解为`ref(obj)`理解为`reactive({value:obj})`

```vue
<script>
import {ref, reactive} from 'vue'
export default {
  name: 'App',
  setup() {
      const obj = {count: 3}
      const state1 = ref(obj)
      const state2 = reactive(obj)
      console.log(state1)
      console.log(state2)
  }
}
</script>
/*这里指的 .value 是在 setup 函数中访问 ref 包装后的对象时才需要加的，  在 template 模板中访问时是不需要的，因为在编译时，会自动识别其是否为 ref */包装过的
```

该如何选择`ref`与`reactive`？

> 1、基本类型：String、number、Booolean等或单值对象，类似像{count:3}这样只有一个属性值的对象使用ref。
>
> 2、引用值类型：Object、Array、使用reactive

##### （5）toRef

`toRef`是将某个对象中的某个值转化为响应式数据，其接受两个参数，第一个参数为`obj`对象；第二个参数为对象中的属性名。

对比ref：

> 1、`ref`是对传入数据的拷贝；`toRef`是对传入数据的引用
>
> 2、`ref`的值改变会更新视图；`toRef`的值改变不会更新视图

##### （6）toRefs

`toRefs`是将传入的对象里所有属性的值都转化为响应式数据对象，该函数支持一个参数，即`obj`对象。

##### （7）shallowReactive

一个浅层的`reactive`，这是一个用于性能优化的API。

当将`obj`作为参数传递给`reavtive`生成响应式数据对象时，若`obj`不止一层，那么每层都用`Proxy`包装一次。

`shallowReactive`监听第一层属性的值，一旦发生改变，则更新视图。

##### （8）shallowRef

一个浅层的`ref`，这是一个用于性能优化的API。

与`reactive`一样，是拿来做性能优化。

（10）`triggerRef`：调用立马更新视图，其接收一个参数`state`，即需要更新的`ref`对象。

```vue
<template>
	<p>{{ state.a }}</p>
	<p>{{ state.first.b }}</p>
	<p>{{ state.first.second.c }}</p>
	<button @click="change">改变</button>
</template>
<script>
import {shallowRef, triggerRef} from 'vue'
export default {
    setup() {
        const obj = {
            a: 1,
            first: {
                b: 2,
                second: {
                    c: 3
                }
            }
        }
        const state = shallowRef(obj)
        console.log(state);
        function change() {
            state.value.first.b = 8
            state.value.first.second.c = 9
            // 修改值后立即驱动视图更新
            triggerRef(state)
            console.log(state);
        }
        return {state, change}
    }
}
</script>
```

##### （9）toRaw

​	`toRaw`方法是用于获取`ref`或`reactive`对象的原始数据的。

```vue
<template>
	<p>{{ state.name }}</p>
	<p>{{ state.age }}</p>
	<button @click="change">改变</button>
</template>

<script>
import {reactive} from 'vue'
export default {
    setup() {
        const obj = {
            name: '前端印象',
            age: 22
        }

        const state = reactive(obj)	

        function change() {
            //改变reactive中的数据，原始数据和reactive包装过的对象的值都发生了变化，这是一个引用关系
            state.age = 90
            console.log(obj); // 打印原始数据obj
            
            //若是直接改变原始对象Object的值，reactive的值也会跟着改变，但是视图不会更新。
            console.log(state);  // 打印 reactive对象
        }

        return {state, change}
    }
}
</script>
```

当我们修改数据但不想更新视图，可以选择直接修改原始数据上的值。可以使用toRow方法。

`toRaw`接受一个参数，即`ref`对象或`reactive`对象。

```VUE
<script>
import {reactive, toRaw} from 'vue'
export default {
    setup() {
        const obj = {
            name: '前端印象',
            age: 22
        }
        //若toRaw方法接收的参数是ref对象，需要加上.value才能获取到原始数据。
        const state = reactive(obj)	
        //获取原始数据=》obj 
        const raw = toRaw(state)
        //可以证明获取的是原始数据,obj===raw
        console.log(obj === raw)   // true
    }
}
</script>
```

##### （10）markRaw

`markRaw`可以将原始数据标记为非响应式的，然后使用`ref`或`reactive`将其包装，仍无法实现响应式，其接收一个参数，即原始数据，并返回被标记后的数据。

```VUE
<template>
	<p>{{ state.name }}</p>
	<p>{{ state.age }}</p>
	<button @click="change">改变</button>
</template>

<script>
import {reactive, markRaw} from 'vue'
export default {
    setup() {
        const obj = {
            name: '前端印象',
            age: 22
        }
        // 通过markRaw标记原始数据obj, 使其数据更新不再被追踪
        const raw = markRaw(obj)   
        // 试图用reactive包装raw, 使其变成响应式数据
        const state = reactive(raw)	

        function change() {
            state.age = 90
            console.log(state);
        }

        return {state, change}
    }
}
</script>
```

即使修改了age的值也不会更新视图了 ，即没有实现数据响应式。

##### （11）provide&inject

与Vue2中的`provide`和`inject`作用相同，在Vue3中需要手动导入。

* provide：向子组件以及子孙组件传递数据，接受两个参数，第一个参数是Key，即数据的名称，第二个参数是value,即数据的值。

* inject：接受父组件或祖先组件传递过来的数据，接受一个参数key，即父组件或祖先组件传递的数据名称。

  ```vue
  // A.vue
  <script>
  import {provide} from 'vue'
  export default {
      setup() {
          const obj= {
              name: '前端印象',
              age: 22
          }
  
          // 向子组件以及子孙组件传递名为info的数据
          provide('info', obj)
      }
  }
  </script>
  
  // B.vue
  <script>
  import {inject} from 'vue'
  export default {
      setup() {	
          // 接收A.vue传递过来的数据
          inject('info')  // {name: '前端印象', age: 22}
      }
  }
  </script>
  
  // C.vue
  <script>
  import {inject} from 'vue'
  export default {
      setup() {	
          // 接收A.vue传递过来的数据
          inject('info')  // {name: '前端印象', age: 22}
      }
  }
  </script>
  ```

##### （12）watch&watchEffect

`wathch`和`watchEffect`都是用来监视某些数据变化从而执行指定的操作的

* watch：watch(source，cb，[options])

  > * source：可以是表达式或函数，用于指定监听的依赖对象
  > * cb：依赖对象变化后执行的回调函数
  > * options：可参数，可以配置的属性有immediate（立即执行触发回调函数）、deep(深度监听)

监听`ref`

```VUE
<script>
import {ref, watch} from 'vue'
export default {
    setup() {	
        const state = ref(0)
        watch(state, (newValue, oldValue) => {
            console.log(`原值为${oldValue}`)
            console.log(`新值为${newValue}`)
            /* 1秒后打印结果：
                            原值为0
                            新值为1
            */
        })
        // 1秒后将state值+1
        setTimeout(() => {
            state.value ++
        }, 1000)
    }
}
</script>
```

监听`reactive`

```vue
<script>
import {reactive, watch} from 'vue'
export default {
    setup() {	
        const state = reactive({count: 0})

        watch(() => state.count, (newValue, oldValue) => {
            console.log(`原值为${oldValue}`)
            console.log(`新值为${newValue}`)
            /* 1秒后打印结果：
                            原值为0
                            新值为1
            */
        })

        // 1秒后将state.count的值+1
        setTimeout(() => {
            state.count ++
        }, 1000)
    }
}
</script>
```

同时监听多个值

```vue
<script>
import {reactive, watch} from 'vue'
export default {
    setup() {	
        const state = reactive({ count: 0, name: 'zs' })

        watch(
            [() => state.count, () => state.name], 
            ([newCount, newName], [oldvCount, oldvName]) => {
                console.log(oldvCount) // 旧的 count 值
                console.log(newCount) // 新的 count 值
                console.log(oldName) // 旧的 name 值
                console.log(newvName) // 新的 name 值
            }
        )

        setTimeout(() => {
          state.count ++
          state.name = 'ls'
        }, 1000)
    }
}
</script>
```

* `watch`方法的第一个参数我们已经指定了监听对象，当组件初始化时，不会执行第二个参数中的回调函数，若想让其初始化时就先执行一遍，可以在第三个参数对象中设置`immediate：true`。
* `watch`方法默认是浅层监听指定的数据，若是监听的数据有多层嵌套，要对其进行监听，可在第三个参数中设置`deep:true`，`watch`方法会返回一个stop方法，若想要停止监听，可执行stop函数。

`watchEffect`与`watch`的区别:

* 不需要手动传入依赖
* 每次执行初始化时会执行一次回调函数自动获取依赖。
* 无法获取到原值，只能得到变化后的值。

```vue
<script>
import {reactive, watchEffect} from 'vue'
export default {
    setup() {	
        const state = reactive({ count: 0, name: 'zs' })
        //不需要传入依赖
        watchEffect(() => {
            //每次执行自动执行一次回调函数自动获取依赖。
            console.log(state.count)
            console.log(state.name)
            /*  初始化时打印：
                            0
                            zs

                1秒后打印：
                            1
                            ls
            */
        })

        setTimeout(() => {
          state.count ++
          state.name = 'ls'
        }, 1000)
    }
}
</script>
```

##### （13）getCurrentInstance

Vue2中可以通过`this`获取当前组件实例，在Vue3中`this`是`undefine`，可以通过`getCurrentInstance`方法获取组件当前实例。

```vue
<template>
	<p>{{ num }}</p>
</template>
<script>
import {ref, getCurrentInstance} from 'vue'
export default {
    setup() {	
        const num = ref(3)
        const instance = getCurrentInstance()
        console.log(instance)
        return {num}
    }
}
</script>
```

##### （14）useStore

在Vue2中使用Vuex，通过`this.$store`来获取Vuex实例，但Vue3中`this`已不能用，可以通过使用

`useStore`。

```vue
// store 文件夹下的 index.js
import Vuex from 'vuex'

const store = Vuex.createStore({
    state: {
        name: '前端印象',
        age: 22
    },
    mutations: {
        ……
    },
    ……
})

// example.vue
<script>
// 从 vuex 中导入 useStore 方法
import {useStore} from 'vuex'
export default {
    setup() {	
        // 获取 vuex 实例
        const store = useStore()

        console.log(store)
    }
}
</script>
```

##### （15）通过ref获取标签元素或组件

在Vue2中可以通过给元素加`ref`属性，然后使用`this.$ref.xx`访问，但Vue3中已不适用。

设置的元素引用变量只有在组件挂载后才能访问到，因此在挂载前对元素进行操作都是无效的。

```vue
<template>
  <div>
    <div ref="el">div元素</div>
  </div>
</template>

<script>
import { ref, onMounted } from 'vue'
export default {
  setup() {
      // 创建一个DOM引用，名称必须与元素的ref属性名相同
      const el = ref(null)
      // 在挂载后才能通过 el 获取到目标元素
      onMounted(() => {
        el.value.innerHTML = '内容被修改'
      })

      // 把创建的引用 return 出去
      return {el}
  }
}
</script>

```

#### Vue 中的 defineComponent

对于一个 ts 文件，如果我们直接写

```VUE
export default {}
```

这个时候，对于编辑器而言，{} 只是一个 Object 的类型，无法有针对性的提示我们对于 vue 组件来说 {} 里应该有哪些属性。但是增加一层 defineComponet 的话

```VUE'
export default defineComponent({})
```

这时，{} 就变成了 **defineComponent 的参数**，那么对参数类型的提示，就**可以实现对 {} 中属性的提示**，外还可以进行对**参数的一些类型推导等操作**。

