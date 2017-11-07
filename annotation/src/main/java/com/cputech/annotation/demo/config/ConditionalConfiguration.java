package com.cputech.annotation.demo.config;

/**
 * Created by song on 2017/9/18.
 */

import com.cputech.annotation.demo.server.DefaultController;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ConditionalOnBean(DefaultController.class)
public class ConditionalConfiguration extends WebMvcConfigurerAdapter {
    @Bean
    public String getName(){
        System.out.println("ConditionalConfiguration");
        return "name";
    }
}
