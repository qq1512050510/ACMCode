package com.chiang.designmodel.proxy.factory;

public class Client {
    public static void main(String[] args) {
        AbstractHumanFactory humanFactory = new HumanFactory();
        Human whiteMan = humanFactory.createHuman(WhiteHuman.class);
        whiteMan.getColor();
        whiteMan.talk();
        Human yellowMan = humanFactory.createHuman(YellowHuman.class);
        yellowMan.getColor();
        yellowMan.talk();
    }
}
