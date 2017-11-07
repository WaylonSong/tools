package com.example.demo;

/**
 * Created by song on 2017/10/24.
 */

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
@CacheConfig(cacheNames = "test")
public class CacheService {
//注意方法一定要是public
    @Cacheable
    public int query(int key) {
        // ...
        System.out.println(key + " not in Cache");
        return key;
    }
}
