package com.chiang.designmodel.observer.inter.impl;

import com.chiang.designmodel.observer.inter.IObserverUpdate;

public class ObserverUpdate2 implements IObserverUpdate {
    @Override
    public void update(String context) {
        System.out.println("观察者2发现用户活动，："+context);
        report(context);
    }

    @Override
    public void report(String context) {
        System.out.println("观察者2报告，："+context);
    }
}
