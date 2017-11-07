package com.cputech.modules.usermsg.annotation;

import com.cputech.modules.usermsg.config.UsrMsgConfig;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;

import java.lang.annotation.*;

/**
 * Created by song on 2017/9/26.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({UsrMsgConfig.class})
@EnableGlobalAuthentication
public @interface EnableUserMsg {
}
