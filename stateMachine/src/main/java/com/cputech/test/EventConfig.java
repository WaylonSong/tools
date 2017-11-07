package com.cputech.test;

import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * Created by song on 2017/9/22.
 */
@WithStateMachine(id = "testMachine")
public class EventConfig {

    @OnTransition(source = "UNCONNECTED", target = "CONNECTED")
    public void connect() {
        System.out.println("///////////////////");
        System.out.println("连接事件, 未连接 -> 已连接");
        System.out.println("///////////////////");
    }

    @OnTransition(source = "CONNECTED", target = "REGISTERING")
    public void register() {
        System.out.println("///////////////////");
        System.out.println("注册事件, 已连接 -> 注册中");
        System.out.println("///////////////////");
    }

    @OnTransition(source = "REGISTERING", target = "REGISTERED")
    public void registerSuccess() {
        System.out.println("///////////////////");
        System.out.println("注册成功事件, 注册中 -> 已注册");
        System.out.println("///////////////////");
    }

    @OnTransition(source = "REGISTERED", target = "UNCONNECTED")
    public void unRegister() {
        System.out.println("///////////////////");
        System.out.println("注销事件, 已注册 -> 未连接");
        System.out.println("///////////////////");
    }
}