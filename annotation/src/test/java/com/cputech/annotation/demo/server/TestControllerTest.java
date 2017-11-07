package com.cputech.annotation.demo.server;

import com.cputech.annotation.demo.appWithoutAutoConfig.AnnotationApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by song on 2017/9/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
//@WebMvcTest
@SpringBootTest(classes = {AnnotationApplication.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        String name = this.restTemplate.getForObject("http://localhost:" + port + "/annotation/server",
                UserDto.class).getName();
        System.out.println(name);
    }
//    @Test
//    public void shouldReturnDefaultMessage() throws Exception {
//        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("Hello World")));
//    }

//    @Test
//    public void mockUserDTO() throws Exception {
//        this.mockMvc.perform(get("/annotation/admin")).andDo(print()).andExpect(status().isOk())
//                .andExpect(jsonPath("name").exists())
//                .andExpect(jsonPath("name").value("Admin"));
//    }
}