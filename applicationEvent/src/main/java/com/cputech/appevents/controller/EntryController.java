package com.cputech.appevents.controller;

import com.cputech.appevents.model.Order;
import com.cputech.appevents.model.OrderRepository;
import com.cputech.appevents.model.PaidEvent;
import com.cputech.appevents.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by song on 2017/9/21.
 */
@RestController
public class EntryController {
    @Autowired
    EntryService entryService;
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @Resource
    OrderRepository orderRepository;

    //Test Application Event
    @RequestMapping("/event/emmit")
    public String emmitEvent(){
        applicationEventPublisher.publishEvent(new PaidEvent());
        return "hello emmitEvent";
    }

    @RequestMapping("/transaction/emmit")
    public String emmitTransaction(){
        orderRepository.save(new Order().markPaid());
        return "hello emmitTransaction";
    }
}
