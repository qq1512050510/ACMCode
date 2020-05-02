package com.chiang.designmodel.observer;

import com.chiang.designmodel.observer.inter.IObserver;
import com.chiang.designmodel.observer.inter.IUser;
import com.chiang.designmodel.observer.inter.impl.Observer;
import com.chiang.designmodel.observer.inter.impl.User;
import com.chiang.designmodel.observer.thread.Spy;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        User user = new User();
        Observer observer = new Observer();
        Spy spyMeal = new Spy(user,observer,"meal");
        spyMeal.start();
        Spy spyFun = new Spy(user,observer,"fun");
        spyFun.start();
        Thread.sleep(1000);
        user.haveMeal();
        Thread.sleep(1000);
        user.haveFun();
        Thread.sleep(1000);
        user.haveMeal();
    }
}
