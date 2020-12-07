package com.chiang.designmodel.proxy.factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HumanFactory extends AbstractHumanFactory {
    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        Human human = null;
        try {
            human = (Human) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            log.info("error");
        }
        return (T) human;
    }
}
