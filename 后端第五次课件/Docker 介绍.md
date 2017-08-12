## Docker

[Docker](www.docker.com) 是一款容器平台。开发者使用 Docker 来消除合作时编写代码时遇到的“机器差别问题” (Works on my machine)。运营商使用 Docker 在分离的容器中同时运行和管理应用以达到更好的计算性能。企业使用 Docker 在 windows 和 Linux 上建立软件传输管道，来达到快速和安全的传输。

## Container 容器

使用容器，将一个软件所要运行的一切都打包在一个单独分离的容器中。和虚拟机不同的是 Docker 不需要绑定一整个系统，只要求软件运行所需要的库和设置即可。![group_5622_0](/Users/yancheng/Unreliable-Notes/Computer/Docker/group_5622_0.png)

## 下载

### Ubuntu

[教程](https://docs.docker.com/engine/installation/linux/docker-ce/ubuntu/#install-using-the-repository) 按里面的一条一条敲命令即可

### Windows 10 

[下载链接](https://www.docker.com/docker-windows) 

如果不是 win10 就在最下面找 docker toolbox

### macOs

[下载链接](https://www.docker.com/docker-mac) 

直接安装



## 测试

```basic
$ docker version
$ docker run hello-world
```

## Docker 镜像服务

1. 阿里云的 Docker 服务[地址](cr.console.aliyun.com)
2. DaoCloud
3. 网易蜂巢

会给出一个你的专有加速地址

如果你是一个应用，那么在应用的 daemon 中就可以配置

在 linux 中/etc/docker/daemon.json 中配置 registry-mirrors

win 中 %programdata%\docker\config\daemon.json

```json
{
    "registry-mirrors" : [
        "你的转悠加速地址"
    ]
}
```

