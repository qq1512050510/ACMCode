package com.chiang.designmodel.proxy.inter.impl;

import com.chiang.designmodel.proxy.inter.IForceGamePlayer;
import com.chiang.designmodel.proxy.inter.IGamePlayer;
import com.chiang.designmodel.proxy.inter.IProxy;

public class ForceGamePlayProxy implements IForceGamePlayer, IProxy {
    private ForceGamePlayer gamePlayer = null;

    public ForceGamePlayProxy(ForceGamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    @Override
    public void login(String username, String password) {
        this.gamePlayer.login(username, password);
    }

    @Override
    public void killBoss() {
        this.gamePlayer.killBoss();
    }

    @Override
    public void upgrade() {
        this.gamePlayer.upgrade();
    }

    @Override
    public IForceGamePlayer getProxy() {
        return this;
    }

    @Override
    public void count() {
        System.out.println("费用：¥200");
    }
}
