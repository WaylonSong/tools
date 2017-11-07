package com.cputech.appevents.engine;

import com.cputech.appevents.model.PaidEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by song on 2017/9/21.
 */
@Slf4j
@Service
@AllArgsConstructor
class EventListener {

    @Async
    @org.springframework.context.event.EventListener
    public void handleOrderPaidEvent(PaidEvent event) {
        LOG.info("+++++++Starting to process event {}.", event);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        LOG.info("+++++++Finished processing event {}.", event);
    }
}

