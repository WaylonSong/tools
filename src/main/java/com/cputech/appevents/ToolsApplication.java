package com.cputech.appevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@EnableTestServer
@SpringBootApplication
//@EnableUserMsg
@RestController
public class ToolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToolsApplication.class, args);
	}

	@RequestMapping("/")
	public String hello(){
		return "hello tools";
	}
}
