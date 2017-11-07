package com.cputech.annotation.demo.config;

import com.cputech.annotation.demo.server.CustomerPropertiesController;
import com.cputech.annotation.demo.server.DefaultController;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by song on 2017/9/18.
 */

@Configuration
@EntityScan("com.cputech.annotation.demo.model")
public class AutoConfiguration {
    @Bean
    public DefaultController getDefaultController() {
        System.out.println("new TestController");
        return new DefaultController();
    }

    @Bean
    public CustomerPropertiesController getCustomerPropertiesController() {
        System.out.println("new TestController2");
        return new CustomerPropertiesController();
    }
    @Bean
    public ApplicationProperties getConnectionSettings(){
        return new ApplicationProperties();
    }
}

