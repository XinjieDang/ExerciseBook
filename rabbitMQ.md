### rabbitMQ

#### Vagrant 的使用

* 查看Vagrant 是否安装成功

```shell
vagrant version
```

![image-20211206203046659](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20211206203046659.png)

* 启动虚拟机

```she
vagrant up
```

![image-20211206203325413](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20211206203325413.png)

* 连接虚拟机

以`vagrant` 用户直接登入虚机中，需要 root 权限的命令可以通过在命令前添加 `sudo` 来执行，也可以执行 `sudo -i` 直接切换到 `root` 用户。

```shell
//用户名 vagrant
//密码   vagrant
vagrant ssh
```

* 停止虚拟机

```shel
vagrant halt
```

* 暂虚拟机

```shell
vagrant suspend
```

* 恢复虚拟

```shell
vagrant resume
```

#### docker中安装rabbitmq

```shell
docker pull rabbitmq:3.8.8-management
```

在docker 中运行rabbitmq

```shell
docker run -d --hostname my-rabbit -p 5672:5672 -p 15672:15672 rabbitmq:3.8.8-management
```

访问`192.168.56.10:15672`默认用户名和密码guest  

![image-20211206220751076](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20211206220751076.png)

#### 消息应答

为了保证消息发送过程中不丢失，rabbitmq引入消息应答机制，消费者在接收到消息并且处理改消息之后，告诉rabbitmq它已经处理了，rabbitmq可以把该消息删除 了。

* 自动应答：消息发送后被立即确认已经传送成功，这种模式需要在高吞吐量和数据传输安全方面做权衡，

  若是消息者那边出现连接或者channel关闭，那么消息就丢失了，也因为没有对传递的消息数据进行限制，这样有可能使得消费者这边由于接收太多来不及处理的消息，导致消息的积压，最终使得内存耗尽。

  