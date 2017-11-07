package com.cputech.annotation.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by song on 2017/9/18.
 */
@Component
@ConfigurationProperties(prefix="connection")
@Data
public class ApplicationProperties {
    private String username;
    private String remoteAddress;
    private String password ;
}