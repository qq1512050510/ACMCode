package com.chiang.designmodel.proxy;

import com.chiang.designmodel.proxy.inter.IGamePlayer;
import com.chiang.designmodel.proxy.inter.impl.GamePlayIH;
import com.chiang.designmodel.proxy.inter.impl.GamePlayer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ClientDynamic {
    public static void main(String[] args) {
        IGamePlayer gamePlayer = new GamePlayer("王者");
        //定义一个handler
        InvocationHandler handler = new GamePlayIH(gamePlayer);
        System.out.println("开始");
        //获得类的class loader
        ClassLoader cl = gamePlayer.getClass().getClassLoader();
        //动态产生一个代理者
        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(cl, new Class[]{IGamePlayer.class}, handler);
        //登录
        proxy.login("王者","password");
        proxy.killBoss();
        proxy.upgrade();
        System.out.println("结束");
    }
}
