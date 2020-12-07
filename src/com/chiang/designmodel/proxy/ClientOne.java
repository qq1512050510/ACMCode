package com.chiang.designmodel.proxy;

import com.chiang.designmodel.proxy.inter.IGamePlayer;
import com.chiang.designmodel.proxy.inter.impl.GamePlayer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientOne {
    public static void main(String[] args) {
        IGamePlayer gamePlayer = new GamePlayer("张三");
        System.out.println("开始时间：" + new SimpleDateFormat("YYYY-MM-dd hh:mm:ss").format(new Date(System.currentTimeMillis())));
        gamePlayer.login("ZhangSan","password");
        gamePlayer.killBoss();
        gamePlayer.upgrade();
        System.out.printf("结束时间：%s",new SimpleDateFormat("YYYY-MM-dd hh:mm:ss").format(new Date()));
    }

}
