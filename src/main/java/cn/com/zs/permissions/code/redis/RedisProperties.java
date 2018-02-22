package cn.com.zs.permissions.code.redis;

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
@ConfigurationProperties(prefix = "zs.redis",ignoreInvalidFields = false)
public class RedisProperties {
}
