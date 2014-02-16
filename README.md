puppet
======

## puppet 是一个工具箱

## 安装
curl -sLk https://raw.github.com/chengtongda/puppet/master/install.sh > install.sh;sh install.sh;rm -rf install.sh

## 工具列表：
- cssh: 到目标服务器执行命令并返回打印结果

  参数：
    $1: 目标服务器ip
    $2: 需要执行的命令

  示例:

```
>>>./cssh 10.232.12.114 uptime
===============10.232.12.114===============
 18:52:02 up 129 days,  8:13,  0 users,  load average: 0.09, 0.06, 0.07
```
