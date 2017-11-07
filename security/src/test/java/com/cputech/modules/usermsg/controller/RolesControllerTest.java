package com.cputech.modules.usermsg.controller;

import com.cputech.modules.usermsg.app.SecurityApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;


/**
 * Created by song on 2017/9/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
//@WebMvcTest
@SpringBootTest(classes = {SecurityApplication.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RolesControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private MockMvc mockMvc;
    @Test
    @WithMockUser(username = "swl", authorities = { "ROLE_ADMIN", "ROLE_USER" })
    public void adminCall() throws Exception {
        /*this.mockMvc.perform(get("/api/admin")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Admin Role")));*/
        System.out.println("");
    }


    @Test
    @WithUserDetails("swl")
    public void getMessageWithUserDetailsCustomUsername() throws Exception {
        /*this.mockMvc.perform(get("/api/admin")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Admin Role")));*/
        System.out.println();
    }
}