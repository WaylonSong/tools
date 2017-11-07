package com.cputech.appevents.service;

import com.cputech.appevents.model.PaidEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by song on 2017/9/21.
 */
@Transactional
@Service
public class EntryService {
    public void fireTransaction(){
        new PaidEvent();
    }
}
