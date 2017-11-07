package com.cputech.annotation.demo.server;

import com.cputech.annotation.demo.config.AutoConfiguration;
import com.cputech.annotation.demo.config.ConditionalConfiguration;
import com.cputech.annotation.demo.config.CustomerProperties;
import com.cputech.annotation.demo.model.Test;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Created by song on 2017/9/18.
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({AutoConfiguration.class, ConditionalConfiguration.class, CustomerProperties.class
    ,Test.class})
public @interface EnableTestServer {

}
