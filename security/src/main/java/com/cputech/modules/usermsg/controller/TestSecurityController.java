package com.cputech.modules.usermsg.controller;

import com.cputech.modules.usermsg.repository.TestModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by song on 2017/11/3.
 */
@RestController
public class TestSecurityController {

    @Autowired
    TestModelRepository testModelRepository;
    @RequestMapping("/security/test")
    public String test(){
        return testModelRepository.toString();
    }
}
