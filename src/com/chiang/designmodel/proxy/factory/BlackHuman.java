package com.chiang.designmodel.proxy.factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BlackHuman implements Human {

    @Override
    public void getColor() {
        log.info("black");
    }

    @Override
    public void talk() {
        log.info("black words");
    }

}
