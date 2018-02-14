package cn.com.zs.permissions.code.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;

import java.util.ArrayList;
import java.util.List;

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
@Configuration
@ConfigurationProperties(prefix = "zs.ss",ignoreUnknownFields = false)
public class SercurityProperties {

    private final CorsConfiguration corsConfiguration = new CorsConfiguration();

    public CorsConfiguration getCorsConfiguration() {
        return corsConfiguration;
    }
}
