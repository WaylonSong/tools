package com.cputech.annotation.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by song on 2017/10/31.
 */
@Configuration
public class ConfigMarker {

    @Bean
    public Marker annotationMarkerBean() {
        return new Marker();
    }

    public class Marker {
    }
}
