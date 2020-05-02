package com.chiang.designmodel.observer.inter.impl;

import com.chiang.designmodel.observer.inter.IObserver;
import com.chiang.designmodel.observer.inter.IObserverUpdate;
import com.chiang.designmodel.observer.inter.IUser;
import com.chiang.designmodel.observer.inter.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class UserUpdate implements IUser, Observable {

    private List<IObserverUpdate> observerList = new ArrayList<IObserverUpdate>();


    @Override
    public void addObserver(IObserverUpdate observer) {
        observerList.add(observer);
    }

    @Override
    public void deleteObserver(IObserverUpdate observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(String context) {
        observerList.forEach(observer -> {
            observer.update(context);
        });
    }

    @Override
    public void haveMeal() {
        System.out.println("用户在吃饭");
        notifyObservers("通知用户在吃饭");
    }

    @Override
    public void haveFun() {
        System.out.println("用户在娱乐");
        notifyObservers("通知用户在娱乐");
    }
}
