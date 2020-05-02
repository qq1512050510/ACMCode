package com.chiang.designmodel.observer.inter.impl;

import com.chiang.designmodel.observer.inter.IObserver;

public class Observer implements IObserver {
    @Override
    public void update(String context) {
        System.out.println("观察到用户开始行动");
        report(context);
        System.out.println("汇报行动结束");
    }

    private void report(String context) {
        System.out.println("汇报内容：" + context);
    }
}
