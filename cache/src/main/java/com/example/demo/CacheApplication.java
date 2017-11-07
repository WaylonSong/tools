package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableCaching
@RestController
@SpringBootApplication
public class CacheApplication {

	@Autowired
	private CacheService cacheService;
	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(CacheApplication.class, args);
	}

	@RequestMapping(value = "/cache/{key}")
	public int hello(@PathVariable int key){
		return cacheService.query(key);
	}
	@RequestMapping(value = "/country/{key}")
	public Country country(@PathVariable String key){
		return countryRepository.findByCode(key);
	}
}
