package com.chiang.designmodel.proxy.inter.impl;

import com.chiang.designmodel.proxy.inter.IForceGamePlayer;
import com.chiang.designmodel.proxy.inter.IGamePlayer;
import com.sun.tools.javac.util.StringUtils;
import org.apache.commons.lang.ObjectUtils;

public class ForceGamePlayer implements IForceGamePlayer {
    private String username = "";
    private IForceGamePlayer forceProxy = null;

    public ForceGamePlayer(String username) {
        this.username = username;
    }

    @Override
    public void login(String username, String password) {
        if (isProxy()) {
            System.out.printf("登录名：%s ，登录成功", username);
        } else {
            noProxyWarn();
        }
    }

    @Override
    public void killBoss() {
        if (isProxy()) {
            System.out.printf("登录名：%s, 在打怪！\n", username);
        } else {
            noProxyWarn();
        }
    }

    @Override
    public void upgrade() {
        if (this.isProxy()) {
            System.out.printf("登录名：%s，在升级！\n", username);
        } else {
            noProxyWarn();
        }
    }

    @Override
    public IForceGamePlayer getProxy() {
        this.forceProxy = new ForceGamePlayProxy(this);
        return this.forceProxy;
    }

    private boolean isProxy() {
        if (forceProxy == null) {
            return false;
        }
        return true;
    }

    private void noProxyWarn() {
        System.out.println("请使用指定的代理访问！");
    }
}
