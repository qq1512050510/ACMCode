package com.chiang.designmodel.observer.inter.impl;

import com.chiang.designmodel.observer.inter.IObserverUpdate;

public class ObserverUpdate1 implements IObserverUpdate {
    @Override
    public void update(String context) {
        System.out.println("观察者1发现用户活动，："+context);
        report(context);
    }

    @Override
    public void report(String context) {
        System.out.println("观察者1报告，："+context);
    }
}
