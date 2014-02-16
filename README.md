puppet
======

## puppet 是一个工具箱

## 通用参数：
- t: 选用的工具,目前支持[cssh]

## 目前支持工具：
- cssh: 到目标服务器执行命令并返回打印结果

  参数
    u: 用户名
    p: 密码
    i: 目标服务器ip地址


  示例
  
```
>>java -jar puppet.jar -u username -p passwd -t cssh -i 10.232.12.114 -c
uptime
===============10.232.12.114===============
 17:16:07 up 129 days,  6:37,  0 users,  load average: 0.07, 0.11, 0.10
```
