package com.cputech.modules.usermsg.config;

/**
 * Created by song on 2017/9/25.
 */

import com.cputech.modules.usermsg.service.CustomUserDetailsService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EntityScan({"com.cputech.modules.usermsg.model"})
@EnableJpaRepositories({"com.cputech.modules.usermsg.repository"})
@EnableGlobalMethodSecurity(prePostEnabled = true) //默认是false的
@ComponentScan("com.cputech.modules.usermsg.controller")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/home").permitAll()
                    .antMatchers("/logout").hasRole("USER")
                    .antMatchers("/admin").hasRole("ADMIN")
                    .antMatchers("/somewhere").access("hasRole('ADMIN') and hasRole('USER')")
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();
    }

//    Default: Auth
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }


    @Bean
    UserDetailsService customUserDetailsService() {
        return new CustomUserDetailsService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
    }

//    @Autowired
//    SysRoleRepository sysRoleRepository;
//    @Autowired
//    SysUserRepository sysUserRepository;
//    @Autowired
//    RolesController rolesController;

//    @Bean
//    public RolesController getRolesController(){
//        return new RolesController();
//    }

}