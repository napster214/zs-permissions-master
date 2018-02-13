package cn.com.zs.permissions.autoconfigure;

import cn.com.zs.permissions.code.jwt.ExtendsSecurityConfigurerAdapter;
import cn.com.zs.permissions.code.jwt.JWTProperties;
import cn.com.zs.permissions.code.jwt.TokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;
import org.zalando.problem.spring.web.advice.security.SecurityProblemSupport;

import javax.annotation.PostConstruct;

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
@Slf4j
@Configuration
@Import(SecurityProblemSupport.class)
@EnableWebSecurity
public class SpringSecurityAutoConfigure extends WebSecurityConfigurerAdapter{

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    private final UserDetailsService userDetailsService;

    private final CorsFilter corsFilter;

    private final SecurityProblemSupport problemSupport;

    private final TokenProvider tokenProvider;

    private final JWTProperties jwtProperties;



    @PostConstruct
    public void init(){
        try {
            authenticationManagerBuilder
                    .userDetailsService(userDetailsService)
                    .passwordEncoder(passwordEncoder());
        } catch (Exception e) {
            throw new BeanInitializationException("权限配置初始化异常",e);
        }
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
            .exceptionHandling()
            .authenticationEntryPoint(problemSupport)
            .accessDeniedHandler(problemSupport)
        .and()
            .csrf()
            .disable()
            .headers()
            .frameOptions()
            .disable()
        .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)//取消session
        .and()
            .authorizeRequests()
            .antMatchers("/api/**").permitAll()
        .and()
            .apply(securityConfigurerAdapter());

    }

    private ExtendsSecurityConfigurerAdapter securityConfigurerAdapter(){
        return new ExtendsSecurityConfigurerAdapter(jwtProperties,tokenProvider);
    }

    public SpringSecurityAutoConfigure(AuthenticationManagerBuilder authenticationManagerBuilder, UserDetailsService userDetailsService, CorsFilter corsFilter, SecurityProblemSupport problemSupport, TokenProvider tokenProvider, JWTProperties jwtProperties) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userDetailsService = userDetailsService;
        this.corsFilter = corsFilter;
        this.problemSupport = problemSupport;
        this.tokenProvider = tokenProvider;
        this.jwtProperties = jwtProperties;
    }
}
