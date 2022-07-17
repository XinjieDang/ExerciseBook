## jwt和shiro整合相关

### jwt生成

* token生成模块，缓存redis
* token验证模块，需要使用redis进行续期。
* token获取信息模块

> * 根据用户信息创建token
> * 生成token 携带自定义信息+签名
> * 将token存入redis，键为自定义前缀+ 随机uuuiId，值为生成的token，并设置redis过期时间和jwt缓存时间一致。

校验token是否正确

* 先从redis 中取出token，匹配是否相同。
* 再对redisToken 进行解密，成功则放行，对token进行续期