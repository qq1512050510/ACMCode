package com.chiang.designmodel.proxy.factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class YellowHuman implements Human {

    @Override
    public void getColor() {
        log.info("yellow");
    }

    @Override
    public void talk() {
        log.info("yellow words");
    }
}
