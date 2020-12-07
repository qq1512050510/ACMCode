package com.chiang.designmodel.proxy.inter;
public interface IGamePlayer {
    //登录游戏
    public void login(String username,String password);
    //杀怪，网络游戏主要特色
    public void killBoss();
    //升级
    public void upgrade();
}
