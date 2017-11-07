package com.cputech.modules.usermsg.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by song on 2017/9/28.
 */
@RestController
public class RolesController {
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/security/admin")
    public String adminCall(){
        return "Admin Role";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping("/security/user")
    public String userCall(){
        return "User Role";
    }
}
