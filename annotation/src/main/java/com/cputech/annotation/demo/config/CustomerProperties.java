package com.cputech.annotation.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by song on 2017/9/18.
 */
@ConfigurationProperties(prefix ="waylon")
//同名配置文件会被parent覆盖
@PropertySource(value = "classpath:server.properties", ignoreResourceNotFound=true)
@Data
public class CustomerProperties {
    private String port;
}
