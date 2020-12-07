package com.chiang.designmodel.proxy.factory;

import org.mortbay.jetty.security.HashUserRealm;

public abstract class AbstractHumanFactory {
    public abstract <T extends Human> T createHuman(Class<T> c);
}
