package cn.com.zs.permissions.code.security;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;

/**
 * 标题: 权限配置
 * <p>
 * 描述: 权限配置
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/13-14:15
 */
@Configuration
@ConfigurationProperties(prefix = "zs.security",ignoreUnknownFields = false)
@Getter
public class SecurityProperties {

    private final CorsConfiguration corsConfiguration = new CorsConfiguration();
}
