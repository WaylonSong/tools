package com.cputech.annotation.demo.server;

import com.cputech.annotation.demo.config.CustomerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by song on 2017/9/18.
 */
//@EnableConfigurationProperties({ CustomerProperties.class})
@RestController
public class CustomerPropertiesController {
    @Autowired
    CustomerProperties customerProperties;

    @RequestMapping(path = "/annotation/server2")
    public String echo(){
        System.out.println(customerProperties.getPort());
        return "hello autoConfiguration2";
    }
}
