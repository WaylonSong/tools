package com.cputech.modules.usermsg.service;

import com.cputech.modules.usermsg.model.SysUser;
import com.cputech.modules.usermsg.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

/**
 * Created by song on 2017/9/26.
 */
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    SysUserRepository sysUserRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List userList = sysUserRepository.findByUsername(s);
        if (userList.size() == 0 ) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return (UserDetails) userList.get(0);
    }

    public SysUser create(SysUser sysUser) {
        //进行加密
        if(sysUserRepository.findByUsername(sysUser.getUsername()).size() == 0){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            sysUser.setPassword(encoder.encode(sysUser.getPassword().trim()));
            sysUserRepository.save(sysUser);
        }
        return sysUser;
    }
}
