package com.cputech.demo.jdk8;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

/**
 * Created by song on 2017/9/23.
 */
public class OptionalDemoTest {
    @Test
    public void testOptional(){
        User user = null;
        //  Throw exception
        //  User userOptional = Optional.of(user);
        //  orElse 存在即返回,否则返回()中的
        /*User userOptional = Optional.ofNullable(user).orElse(new User("la","la"));
        System.out.println(userOptional.getName());

        List<String> arr = null;
        System.out.println(Optional.ofNullable(arr).orElse(Collections.emptyList()).size());*/

    }
    @Data
    @AllArgsConstructor
    class User{
        String name;
        String pwd;
    }
}