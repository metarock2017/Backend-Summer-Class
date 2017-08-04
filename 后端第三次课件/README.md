## 关于jwt的说明

我做的这个demo使用方法大致是，你注册一个账号后，进行登录 `localhost:8000/login`。登录后会返回一个 json 字符串，里面包含了jwt

然后你复制这个 token 去访问 `localhost:8000/user?token=` `=`后填你刚才的复制的值，就能返还给你这个人在数据库中的信息。

## 作业

1. 用 composer 安装并使用 PHPUnit 
   + 至少使用 PHPUnit  中的3个方法
   + 配置 `phpunit.xml` 文件来进行 PHPUnit 的使用

2. 学习使用 [bindTo](http://php.net/manual/zh/closure.bindto.php) 方法

3. jwt

   用 jwt 的方式实现登录（登录你可以自己写，自己写的时候注意 `Config/jwt.php` 中的配置；也可以用laravel自带的，注意authenticated方法，可以帮助你不自动跳转）

   + 使用 jwt 的登录方式。即你 login 后然会给你一个 jwt（你可以使用 json 方式也可以使用 header）
   + 然后在你发送请求时带上这个 jwt，可以放在 header 里，格式参考官网给的文档，也可以是以get参数的方式（这个不推荐，你可以自己测试的时候用）`?token=xxxxx`
   + 然后获取你的用户信息

## 人员

1guixuan

2yi jun mo

3.lijiaojiao

4.ren hai wei 

5.dongyiding

6.yangruixin

7.zhangbaole

8.zhenhao

9.zhanghanlin

10.yunhan