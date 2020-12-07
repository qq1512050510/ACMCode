package com.chiang.designmodel.observer.thread;

import com.chiang.designmodel.observer.inter.IObserver;
import com.chiang.designmodel.observer.inter.IUser;
import com.chiang.designmodel.observer.inter.impl.Observer;
import com.chiang.designmodel.observer.inter.impl.User;

public class Spy extends Thread{
    private User user;
    private Observer observer;
    private String type;

    public Spy(User user, Observer observer, String type) {
        this.user = user;
        this.observer = observer;
        this.type = type;
    }

    @Override
    public void run() {
        while(true){
            if(type.equals("meal")){
                if(user.isHaveMeal()){
                    observer.update("meal");
                    user.setHaveMeal(false);
                }
            }else{
                if(user.isHaveFun()){
                    observer.update("fun");
                    user.setHaveFun(false);
                }

            }

        }
    }
}
