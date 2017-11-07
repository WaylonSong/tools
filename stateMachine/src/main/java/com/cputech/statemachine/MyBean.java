package com.cputech.statemachine;

import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * Created by song on 2017/9/21.
 */
@WithStateMachine(id = "sMachine")
class MyBean {
    @OnTransition(source = "S1", target = "S2")
    public void fromS1ToS2() {
        System.out.println("WithStateMachine fromS1ToS2");
    }
}