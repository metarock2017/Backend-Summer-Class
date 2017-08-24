# Dockerfile

[TOC]

Docker 可以通过读取 Dockerfile 来构建一个镜像 (Image)

1. 一个 Image 应该尽可能的小
2. 使用 `.dockerignore` 
3. 避免安装不需要的包，比如数据库的容器中不需要 `vi` 命令
4. 参数分离

## Command

#### FROM

尽量使用官方库作为你的作为你容器的基础

```basic
# FROM <Image>:<tag>
FROM ubuntu:14.04
```



#### LABEL

你可以为你的 Image 增加 Label 来帮助你组织你自己的 Image

如果值中又空格就必须用 `"` 引用，或者使用 `\` 转义

```basic
# 注释
Label com.example.version="0.0.1-beta"
```

#### RUN

为了可读性等原因，分割长货复杂的命令

##### apt-get 

最常用的命令 apt-get 注意缓存问题

```basic
RUN apt-get update & apt-get install & \
    php-fpm \
    php=1.3.*
```

通过移除 `/var/lib/apt/lists` 减少 Image 空

> 官方的 debian 和 ubuntu 系统自动执行 apt clean 明令

##### 使用管道 (PIPES)

```basic
RUN wget -O https://xxx.com | wc -l > /number
```

> `wc -l`  输出行数

Docker 可以使用 `/bin/sh -c` 来执行 RUN 后的命令，只通过执行管道中最后一行代码的返回值来判断是否成功

你可以通过 `set -o pipefail &&` 来确定每隔管道中的命令是否成功

```basic
RUN set -o pipefail && wget -O https:xxx.com | wc -l > /number
```

并不是所有的 SHELL 脚本都支持 `-o pipefail` 的，如果不支持的话，可以通过

```basic
RUN ["/bin/bash", "-c", "set -o pipefail && wget -O - https://some.site | wc -l > /number"]
```

来强制使用支持 `-o pipefail` 的脚本类型

#### CMD

用来执行你 Image 中所包含的软件

```basic
CMD [“executable”, “param1”, “param2”…]
```

#### EXPOSE

这条命令指明容器中的哪个端口会被用来监听连接, 只讲端口暴露给该容器的内部（通常当作文档提醒使用容器的人员）

#### ENV

用于更新环境变量

```basic
ENV PATH /usr/local/nginx/bin:$PATH
```

#### COPY & AND

COPY 只支持最基本的把本地的文件复制到容器中去

ADD 则还有一些别的特性，比如会将压缩文件直接解压至容器中去

`ADD xxx.tar.xz /`

大多数情况更推荐 COPY，因为 COPY 命令更 “单纯”

#### ENTRYPOINT

对该命令的最佳利用是设置 Image 的主命令,即当你运行容器后执行的第一个命令

一个 Dockerfile 中只能制定一个 ENTRYPOINT 最后一个覆盖前面的

和 CMD 命令是容器启动时最后执行的入口命令，与 CMD 命令配合时，CMD 可以只有参数，因为ENTRYPOINT 可以作为一个入口，比如 `ENTRYPOINT ["echo"]` 然后 `CMD ["foo"]` 则会输出 foo

```basic
ENTRYPOINT ["command", "param1", "param2"]
ENTRYPOINT command param1 param2
```

ENTRYPOINT 还可以执行一段脚本命令

```basic
COPY ./test.sh /root/
ENTRYPOINT "/root/test.sh"
```

#### VOLUME

用来指定本地或者其他数据库，配置，文件文件夹的存储空间

```basic
VOLUME /storage
```

#### USER

用于指定执行用户

如果执行命令不需要权限那么应当指定一个非 root 用户

创建一个其他用户

```basic
RUN groupadd -r postgres && useradd --no-log-init -r -g postgres postgres
```

#### WORKDIR

指定命令执行的路径

```basic
WORKDIR /home/user
RUN pwd
# 输出 /home/user
WORKDIR a
# 输出 /home/user/a
```

#### ONBUILD

该命令在 build Image 后执行，且该命令会在任何基于该 Image 的 Image 中执行

他会在子 Image 执行 build 之前执行

比如可以用来转换语言版本

## 构建一个基础的 Dockerfile 例子



```Bash
FROM ubuntu:16.04

LABEL test="0.1"

MAINTAINER name user@localhost

RUN apt-get update && \
    apt-get install -y nginx && \
    rm -rf /var/lib/apt/lists/* && \
    chown -R www-data:www-data /var/lib/nginx && \
    echo "\ndaemon off;" >> /etc/nginx/nginx.conf

VOLUME ["/etc/nginx/sites-enabled", "/etc/nginx/conf.d", "/var/log/nginx", "/var/www/html"]

WORKDIR /etc/nginx

CMD ["/usr/sbin/nginx"]

EXPOSE 80
```





















