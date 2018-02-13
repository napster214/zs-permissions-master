package cn.com.zs.permissions.autoconfigure;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 标题: SpringSecurity配置
 * <p>
 * 描述: SpringSecurity配置
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/3-22:27
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityAutoConfigure extends WebSecurityConfigurerAdapter{
}
