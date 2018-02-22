package cn.com.zs.permissions.code.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 标题:
 * <p>
 * 描述:
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/20-1:07
 */
@Configuration
@ConfigurationProperties(prefix = "permissions.redis",ignoreInvalidFields = false)
@Data
public class RedisProperties {

    private String redisAddress = "redis://127.0.0.1:3306";
}
