package com.cputech.annotation.demo.server;

import com.cputech.annotation.demo.config.ApplicationProperties;
import com.cputech.annotation.demo.config.ConfigMarker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by song on 2017/9/18.
 */
@ConditionalOnBean(ConfigMarker.Marker.class)
@RestController
public class DefaultController {

    @Autowired
    ApplicationProperties applicationProperties;

    @RequestMapping(path = "/annotation/admin")
    public UserDto echo(){
        return new UserDto("Admin");
    }
    @RequestMapping(path = "/annotation")
    public String hello(){
        return "Hello Annotation Tools";
    }
}
