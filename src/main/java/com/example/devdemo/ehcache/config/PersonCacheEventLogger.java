package com.example.devdemo.ehcache.config;


import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: bi
 * @createTime: 2024年03月20日 11:16:39
 * @version: 1.0
 * @Description: Perison缓存事件监听
 */
public class PersonCacheEventLogger implements CacheEventListener<Object,Object> {

    private static final Logger logger = LoggerFactory.getLogger(PersonCacheEventLogger.class);
    @Override
    public void onEvent(CacheEvent<?, ?> cacheEvent) {
        logger.info("persion caching event{} {} {} {}",
                cacheEvent.getType(),
                cacheEvent.getKey(),
                cacheEvent.getOldValue(),
                cacheEvent.getNewValue()
        );
    }
}