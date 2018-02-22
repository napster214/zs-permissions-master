package cn.com.zs.permissions.autoconfigure;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
public class RedisAutoConfigure {

    @Bean
    public RedissonClient redissonClient(){
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://47.52.207.143:6379");
        return Redisson.create(config);
    }

}
