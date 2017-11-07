package com.cputech.appevents.engine;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Service;

/**
 * Created by song on 2017/9/21.
 */
@Service
@Slf4j
@RequiredArgsConstructor
class ApplicationInitializer {
    @org.springframework.context.event.EventListener
    public void init(ApplicationReadyEvent event) {
        LOG.info("+++++++ApplicationReadyEvent", event);
    }
}
