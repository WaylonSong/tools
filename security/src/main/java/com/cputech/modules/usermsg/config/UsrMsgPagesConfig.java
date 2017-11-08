package com.cputech.modules.usermsg.config;

/**
 * Created by song on 2017/9/25.
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class UsrMsgPagesConfig extends WebMvcConfigurerAdapter {
    static {
        System.out.println("WebMvcConfigurerAdapter");
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("usr/home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/logout").setViewName("usr/hello");
        registry.addViewController("/admin").setViewName("usr/hello");
        registry.addViewController("/login").setViewName("usr/login");
    }
}