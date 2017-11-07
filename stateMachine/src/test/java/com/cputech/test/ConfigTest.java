package com.cputech.test;

import com.cputech.StateMachineApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by song on 2017/9/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {StateMachineApplication.class})
@WebAppConfiguration
public class ConfigTest {
    @Autowired
    StateMachine<RegStatusEnum, RegEventEnum> stateMachine;

    @Test
    public void out(){
        stateMachine.start();
        System.out.println(stateMachine.getInitialState());
        stateMachine.sendEvent(RegEventEnum.CONNECT);
        System.out.println(stateMachine.getState());
        stateMachine.stop();
        System.out.println("test");
    }
}