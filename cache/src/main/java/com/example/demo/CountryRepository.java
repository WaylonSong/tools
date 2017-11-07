package com.example.demo;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Created by song on 2017/10/24.
 */
@Component
@CacheConfig(cacheNames = "countries")
public class CountryRepository {

    @Cacheable
    public Country findByCode(String code) {
        System.out.println("---> Loading country with code '" + code + "'");
        return new Country(code);
    }

}
