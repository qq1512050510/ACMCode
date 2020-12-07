package com.chiang.designmodel.observer;

import com.chiang.designmodel.observer.inter.IUser;
import com.chiang.designmodel.observer.inter.impl.UserAssociation;

public class ClientAssociation {
    public static void main(String[] args) {
        IUser user = new UserAssociation();
        user.haveMeal();
        user.haveFun();
    }
}
