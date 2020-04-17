package com.chiang.designmodel.proxy;

import com.chiang.designmodel.proxy.inter.IGamePlayer;
import com.chiang.designmodel.proxy.inter.impl.GamePlayer;

import java.util.Date;

public class ClientOne {
    public static void main(String[] args) {
        IGamePlayer gamePlayer = new GamePlayer("张三");
        System.out.println(new Date(System.currentTimeMillis()));
    }

}
