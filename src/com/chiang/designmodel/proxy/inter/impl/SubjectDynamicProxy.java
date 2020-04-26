package com.chiang.designmodel.proxy.inter.impl;

import com.chiang.designmodel.proxy.inter.SubjectDynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class SubjectDynamicProxy extends DynamicProxy{
    public static <T> T newProxyInstanc(SubjectDynamic subjectDynamic){
        //获取ClassLoader
        ClassLoader loader = subjectDynamic.getClass().getClassLoader();
        //获得接口数组
        Class<?>[] classes = subjectDynamic.getClass().getInterfaces();
        //获取handler
        InvocationHandler handler = new MyInvocationHandler(subjectDynamic);
        return (T)Proxy.newProxyInstance(loader,classes,handler);
    }
}
