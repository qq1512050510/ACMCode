package com.chiang.designmodel.proxy.inter;

public interface IForceGamePlayer {
    public void login(String username,String password);
    public void killBoss();
    public void upgrade();
    public IForceGamePlayer getProxy();
}
