package cn.com.zs.permissions.autoconfigure;

import cn.com.zs.permissions.code.redis.RedisProperties;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 标题: redis配置文件
 * <p>
 * 描述: redis配置文件
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/19-23:55
 */
@Configuration
@EnableCaching
public class RedisAutoConfigure {

    private final RedisProperties redisProperties;

    public RedisAutoConfigure(RedisProperties redisProperties) {
        this.redisProperties = redisProperties;
    }

    @Bean
    public RedissonClient redissonClient(){
        Config config = new Config();
        config.useSingleServer()
                .setAddress(redisProperties.getRedisAddress());
        return Redisson.create(config);
    }


    @Bean
    public CacheManager cacheManager(RedissonClient redissonClient){
        Map<String,CacheConfig> config = new HashMap<>();
        config.put("commonCache",new CacheConfig(24*60*1000,12*60*1000));
        return new RedissonSpringCacheManager(redissonClient,config);
    }

}
