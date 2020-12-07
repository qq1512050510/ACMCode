package com.chiang.designmodel.proxy.inter.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxy<T> {

    public static <T> T newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) {
        return (T) Proxy.newProxyInstance(loader, interfaces, h);
    }
}
