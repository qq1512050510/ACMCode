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

#设计模式
##代理模式
com.chiang.designmodel.proxy;\
代理模式(Proxy Pattern)是一个使用频率非常高的模式。
定义如下
Provide a surrogate or placeholder for another object to control access to it.\
强制代理模式\
强制代理的角色只能通过代理进行接口调用

