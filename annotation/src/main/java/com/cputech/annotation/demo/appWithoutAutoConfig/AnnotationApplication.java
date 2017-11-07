package com.cputech.annotation.demo.appWithoutAutoConfig;

import com.cputech.annotation.demo.server.EnableMarker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableMarker
@SpringBootApplication
public class AnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnotationApplication.class, args);
	}
}
