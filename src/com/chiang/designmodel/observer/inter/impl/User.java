package com.chiang.designmodel.observer.inter.impl;

import com.chiang.designmodel.observer.inter.IUser;

public class User implements IUser {
    private boolean haveMeal = false;
    private boolean haveFun = false;

    public boolean isHaveMeal() {
        return haveMeal;
    }

    public void setHaveMeal(boolean haveMeal) {
        this.haveMeal = haveMeal;
    }

    public boolean isHaveFun() {
        return haveFun;
    }

    public void setHaveFun(boolean haveFun) {
        this.haveFun = haveFun;
    }

    @Override
    public void haveMeal() {
        System.out.println("用户在吃饭");
        setHaveMeal(true);
    }

    @Override
    public void haveFun() {
        System.out.println("用户在娱乐");
        setHaveFun(true);
    }
}
