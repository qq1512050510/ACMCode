package com.chiang.designmodel.observer.inter.impl;

import com.chiang.designmodel.observer.inter.IObserver;
import com.chiang.designmodel.observer.inter.IUser;

public class UserAssociation implements IUser {

    private IObserver observer = new Observer();
    @Override
    public void haveMeal() {
        System.out.println("用户在吃饭");
        observer.update("监控到用户在吃饭");

    }

    @Override
    public void haveFun() {
        System.out.println("用户在娱乐");
        observer.update("监控到用户在娱乐");
    }
}
