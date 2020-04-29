# ACMCode
# java
gag_evt_202001-12_v00.fits 
location: 百度网盘 链接：https://pan.baidu.com/s/1GA4ovefxDlilxg_3l-GjQw 
提取码：b98z
# git
new Branch

# hadoop
## hadoop environment
Hadoop version 2.8.5
注：Hadoop 2.7以及之后的版本，至少需要JDK7；
  Hadoop 2.6以及之前的版本，支持JDK6；
（
Hadoop Java Versions
Version 2.7 and later of Apache Hadoop requires Java 7. It is built and tested on both OpenJDK and Oracle(HotSpot)'s JDK/JRE.Earlier version(2.6 and earlier) support Java 6.
）
Hadoop 2.8.5采用的JDK版本为JDK8  

Hadoop 1.x.x版本，只需引入1个jar：
```hadoop-core```

Hadoop 2.x.x版本需要引入4个jar：
```
hadoop-common
hadoop-hdfs
hadoop-mapreduce-client-core
hadoop-client
```

[maven download](https://mvnrepository.com/) 
# 设计模式
## 代理模式
com.chiang.designmodel.proxy;\
代理模式(Proxy Pattern)是一个使用频率非常高的模式。
定义如下
Provide a surrogate or placeholder for another object to control access to it.\
强制代理模式\
强制代理的角色只能通过代理进行接口调用/
```
com.chiang.designmodel.proxy.inter.impl.ForceGamePlayer
```
ForceGamePlayer类是强制代理角色。
个性代理 
### 动态代理
动态代理是在实现阶段不用关心谁代理谁，而在运行阶段才指定代理哪个对象。\
相对来说，之前的代理类的方式都是静态代理。\
AOP（Aspect Oriented Programming）面向切面编程核心采用动态代理机制。 \
AOP编程没有使用什么新的技术，但是它对我们的设计、编程有很大的提升。\
对于日志、事务、权限等都可以在系统设计阶段不用考虑，而在设计后通过AOP的方式切过去。


## 原型模式
```
com.chiang.prototype
```


