package com.cputech.modules.usermsg.repository;

import com.cputech.modules.usermsg.app.SecurityApplication;
import com.cputech.modules.usermsg.model.SysRole;
import com.cputech.modules.usermsg.model.SysUser;
import com.cputech.modules.usermsg.service.CustomUserDetailsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by song on 2017/9/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@AutoConfigureMockMvc
@SpringBootTest(classes = {SecurityApplication.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SysUserRepositoryTest {
    @Autowired
    CustomUserDetailsService customUserDetailsService;
    @Autowired
    SysRoleRepository sysRoleRepository;
    @Test
    public void addRoles() throws Exception {
        SysRole sysRole = new SysRole();
        sysRole.setName("ROLE_ADMIN");
        sysRoleRepository.save(sysRole);
        sysRole = new SysRole();
        sysRole.setName("ROLE_USER");
        sysRoleRepository.save(sysRole);
    }
    @Test
    public void createAdminAndUser() throws Exception {

        SysUser user = new SysUser();
        user.setUsername("swl");
        user.setPassword("123456");
        List<SysRole> sysRoleList = new ArrayList<>();
        sysRoleList.add(sysRoleRepository.findOne(1L));
        sysRoleList.add(sysRoleRepository.findOne(2L));
        user.setRoles(sysRoleList);
        customUserDetailsService.create(user);
    }

    @Test
    public void createUser() throws Exception {
        SysUser user = new SysUser();
        user.setUsername("swl2");
        user.setPassword("123456");
        List<SysRole> sysRoleList = new ArrayList<>();
        sysRoleList.add(sysRoleRepository.findOne(2L));
        user.setRoles(sysRoleList);
        customUserDetailsService.create(user);
    }
}