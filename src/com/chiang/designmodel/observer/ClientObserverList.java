package com.chiang.designmodel.observer;

import com.chiang.designmodel.observer.inter.IObserverUpdate;
import com.chiang.designmodel.observer.inter.IUser;
import com.chiang.designmodel.observer.inter.Observable;
import com.chiang.designmodel.observer.inter.impl.ObserverUpdate1;
import com.chiang.designmodel.observer.inter.impl.ObserverUpdate2;
import com.chiang.designmodel.observer.inter.impl.UserUpdate;

public class ClientObserverList {
    public static void main(String[] args) {
        IObserverUpdate observerUpdate1 = new ObserverUpdate1();
        IObserverUpdate observerUpdate11 = new ObserverUpdate1();
        IObserverUpdate observerUpdate2 = new ObserverUpdate2();
        UserUpdate user = new UserUpdate();
        user.addObserver(observerUpdate1);
        user.addObserver(observerUpdate11);
        user.addObserver(observerUpdate2);
        user.haveFun();
        user.haveMeal();
    }
}
