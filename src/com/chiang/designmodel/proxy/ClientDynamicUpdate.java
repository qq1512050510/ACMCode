package com.chiang.designmodel.proxy;

import com.chiang.designmodel.proxy.inter.SubjectDynamic;
import com.chiang.designmodel.proxy.inter.impl.MyInvocationHandler;
import com.chiang.designmodel.proxy.inter.impl.RealSubjectDynamic;
import com.chiang.designmodel.proxy.inter.impl.SubjectDynamicProxy;

import java.lang.reflect.InvocationHandler;

public class ClientDynamicUpdate {
    public static void main(String[] args) {
        //定义一个主题
        SubjectDynamic subjectDynamic = new RealSubjectDynamic();
        //定义主题的代理
        SubjectDynamic proxy = SubjectDynamicProxy.newProxyInstanc(subjectDynamic);
        //代理行为
        proxy.doSomething("test");
    }
}
