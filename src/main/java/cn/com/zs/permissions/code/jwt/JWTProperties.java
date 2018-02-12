package cn.com.zs.permissions.code.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 标题: jwt配置
 * <p>
 * 描述: jwt配置
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/9-14:55
 */
@Data
@ConfigurationProperties(prefix = "zs.jwt",ignoreUnknownFields = false)
public class JWTProperties {

    private String secretKey;

    private long tokenValidityInMilliseconds;

    private long tokenValidityInMillisecondsForRememberMe;

}
