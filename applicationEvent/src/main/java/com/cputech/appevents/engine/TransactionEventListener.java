package com.cputech.appevents.engine;

import com.cputech.appevents.model.PaidEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * Created by song on 2017/9/21.
 */
@Slf4j
@Service
@AllArgsConstructor
class TransactionEventListener {

    @Async
    @TransactionalEventListener
    public void handleOrderPaidEvent(PaidEvent event) {
        LOG.info("+++++++Starting Transaction to process event {}.", event);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LOG.info("+++++++Finished Transaction processing event {}.", event);
    }
}

