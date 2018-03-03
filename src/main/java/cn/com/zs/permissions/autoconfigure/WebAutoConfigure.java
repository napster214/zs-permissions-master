package cn.com.zs.permissions.autoconfigure;

import cn.com.zs.permissions.code.security.SercurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 标题: web配置
 * <p>
 * 描述: web配置
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/13-14:22
 */
@Configuration
public class WebAutoConfigure {

    private final SercurityProperties sercurityProperties;

    public WebAutoConfigure(SercurityProperties sercurityProperties) {
        this.sercurityProperties = sercurityProperties;
    }


    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = sercurityProperties.getCorsConfiguration();
        if (corsConfiguration.getAllowedOrigins() != null
                && !corsConfiguration.getAllowedOrigins().isEmpty()){
            source.registerCorsConfiguration("/api/**",corsConfiguration);
        }
        return new CorsFilter(source);
    }
}
