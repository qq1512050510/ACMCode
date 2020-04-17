package com.chiang.designmodel.proxy.inter.impl;

import com.chiang.designmodel.proxy.inter.IGamePlayer;

public class GamePlayer implements IGamePlayer {
    private String username;

    public GamePlayer(String username) {
        this.username = username;
    }

    @Override
    public void login(String username, String password) {
        this.username = username;
    }

    @Override
    public void killBoss() {
        System.out.println(this.username + "在打怪！");
    }

    @Override
    public void upgrade() {
        System.out.println(this.username + "在升级！");
    }
}
