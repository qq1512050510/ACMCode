package com.chiang.designmodel.proxy;

import com.chiang.designmodel.proxy.inter.IForceGamePlayer;
import com.chiang.designmodel.proxy.inter.impl.ForceGamePlayer;

public class ClientForce {
    public static void main(String[] args) {
        IForceGamePlayer player = new ForceGamePlayer("王者");
        IForceGamePlayer proxy = player.getProxy();
        System.out.println("开始");
        proxy.killBoss();
        proxy.upgrade();
        System.out.println("结束");
    }
}
