package com.example.practise.hibernatepractise.config.cache;


import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class CacheConfig extends CachingConfigurerSupport {


    @Bean
    public net.sf.ehcache.CacheManager ehCacheManager(){

        //Read values from properties or some file -> hardcoded for now
        CacheConfiguration configuration = new CacheConfiguration();
        configuration.setName("movie-cache");
        configuration.setMemoryStoreEvictionPolicy("LRU");
        configuration.setMaxEntriesLocalHeap(1000);
        configuration.setTimeToLiveSeconds(20);

        CacheConfiguration actorConfig = new CacheConfiguration();
        actorConfig.setName("actor-cache");
        actorConfig.setMemoryStoreEvictionPolicy("LRU");
        actorConfig.setMaxEntriesLocalHeap(1000);
        actorConfig.setTimeToLiveSeconds(20);

        net.sf.ehcache.config.Configuration config =  new net.sf.ehcache.config.Configuration();
        config.addCache(configuration);
        config.addCache(actorConfig);
        return  net.sf.ehcache.CacheManager.newInstance(config);
    }

    @Bean
    @Override
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheManager());
    }
}
