package com.cputech.annotation.demo.server;

import com.cputech.annotation.demo.config.ConfigMarker;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Created by song on 2017/10/31.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ConfigMarker.class})
public @interface EnableMarker {
}
