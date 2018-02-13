package cn.com.zs.permissions.code.jwt;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 标题: 继承springsecurity适配器
 * <p>
 * 描述:
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/4-21:14
 */
public class ExtendsSecurityConfigurerAdapter extends SecurityConfigurerAdapter<DefaultSecurityFilterChain,HttpSecurity>{




    private final JWTProperties jwtProperties;

    private final TokenProvider tokenProvider;

    public ExtendsSecurityConfigurerAdapter(JWTProperties jwtProperties, TokenProvider tokenProvider) {
        this.jwtProperties = jwtProperties;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        JWTFilter jwtFilter = new JWTFilter(jwtProperties,tokenProvider);
        builder.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
