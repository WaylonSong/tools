package com.cputech.statemachine;

/**
 * Created by song on 2017/9/21.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;

@Configuration
public class StateMachineConfig {

    @Bean
    public StateMachineLogListener stateMachineLogListener() {
        return new StateMachineLogListener();
    }
    @Autowired
    private StateMachineLogListener stateMachineLogListener;

    @Autowired
    private ApplicationContext appContext;
    @Bean
    public StateMachine<String, String> getStateMachine() throws Exception {
        StateMachineBuilder.Builder<String, String> builder = StateMachineBuilder.builder();
        builder.configureConfiguration()
                .withConfiguration().machineId("sMachine").beanFactory(appContext.getAutowireCapableBeanFactory())
                .autoStartup(true)
                .listener(stateMachineLogListener);
        builder.configureStates()
                .withStates().initial("S1")
                    .state("S2", null, (c) -> {System.out.println("hello1");})
                    .state("S3", (c) -> {System.out.println("hello2");}, null);
        builder.configureTransitions()
                .withExternal()
                    .source("S1").target("S2").event("E1")
                    .action((c) -> {System.out.println("hello3");})
                    .and()
                .withExternal()
                    .source("S2").target("S3").event("E2")
                    .and()
                .withExternal()
                    .source("S3").target("S1").event("E3")
        ;
        StateMachine<String, String> stateMachine = builder.build();
        return stateMachine;
    }

}