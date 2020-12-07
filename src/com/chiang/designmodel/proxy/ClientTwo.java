package com.chiang.designmodel.proxy;

import com.chiang.designmodel.proxy.inter.IGamePlayer;
import com.chiang.designmodel.proxy.inter.impl.GamePlayer;
import com.chiang.designmodel.proxy.inter.impl.GamePlayerProxy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientTwo {
    private static void printCurrentTime(String pre){
        System.out.println(pre + new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()));
    }
    public static void main(String[] args) {
        IGamePlayer player = new GamePlayer("王者");
        IGamePlayer proxy = new GamePlayerProxy(player);
        printCurrentTime("开始时间：");
        proxy.login("WangZhe","password");
        proxy.killBoss();
        proxy.upgrade();
        printCurrentTime("结束时间：");
    }
}
