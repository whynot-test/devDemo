//package com.example.devdemo.ehcache.config;
//
//import java.util.concurrent.TimeUnit;
//
//import javax.cache.CacheManager;
//import javax.cache.configuration.MutableConfiguration;
//import javax.cache.expiry.Duration;
//import javax.cache.expiry.TouchedExpiryPolicy;
//
//import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//import lombok.extern.slf4j.Slf4j;
//
///**
// * @Author: bi
// * @createTime: 2024年03月19日 23:07:37
// * @version: 1.0
// * @Description: Ehcache缓存配置类:缓存策略10s
// */
//@Slf4j
//@Component
//public class EhcacheConfig implements JCacheManagerCustomizer {
//
//
//    @Override
//    public void customize(CacheManager cacheManager) {
//        cacheManager.createCache("person",new MutableConfiguration<>()
//                .setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(TimeUnit.SECONDS,10)))
//                .setStoreByValue(false)
//                .setStatisticsEnabled(true)
//        );
//    }
//}