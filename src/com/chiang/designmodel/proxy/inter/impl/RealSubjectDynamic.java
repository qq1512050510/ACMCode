package com.chiang.designmodel.proxy.inter.impl;

import com.chiang.designmodel.proxy.inter.SubjectDynamic;

public class RealSubjectDynamic implements SubjectDynamic {
    @Override
    public void doSomething(String str) {
        System.out.println("do something!---->" + str);
    }
}
