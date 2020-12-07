package com.chiang.designmodel.proxy.factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WhiteHuman implements Human {

    @Override
    public void getColor() {
        log.info("white");
    }

    @Override
    public void talk() {
        log.info("white words");
    }
}
