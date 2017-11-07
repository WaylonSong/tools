package com.cputech.appevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ApplicationEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationEventApplication.class, args);
	}
}
