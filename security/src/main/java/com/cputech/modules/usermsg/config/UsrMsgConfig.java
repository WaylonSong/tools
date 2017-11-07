package com.cputech.modules.usermsg.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by song on 2017/9/27.
 */
@Configuration
@Import({WebSecurityConfig.class, UsrMsgPagesConfig.class})
public class UsrMsgConfig {
    static {
        System.out.println("UsrMsgConfig");
    }
}
