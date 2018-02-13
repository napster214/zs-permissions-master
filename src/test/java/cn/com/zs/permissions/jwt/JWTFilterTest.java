package cn.com.zs.permissions.jwt;

import cn.com.zs.permissions.code.Constants;
import cn.com.zs.permissions.code.jwt.ExtendsSecurityConfigurerAdapter;
import cn.com.zs.permissions.code.jwt.JWTFilter;
import cn.com.zs.permissions.code.jwt.JWTProperties;
import cn.com.zs.permissions.code.jwt.TokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Collections;

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
 * @created 2018/2/4-21:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JWTFilterTest {


    @Autowired
    private JWTProperties jwtProperties;

    @Autowired
    private TokenProvider tokenProvider;

    @Before
    public void setUp(){

    }

    @Test
    public void JWTFilterTest() throws IOException, ServletException {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                "test-user",
                "test-password",
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
        String jwt = tokenProvider.createToken(authenticationToken,false);
        MockHttpServletRequest request = new MockHttpServletRequest();
        String token = "Bearer "+jwt;
        log.debug("生成的token【"+jwt+"】");
        request.addHeader(Constants.AUTHORIZATION_HEADER,"Bearer "+jwt);
        MockHttpServletResponse response = new MockHttpServletResponse();
        MockFilterChain filterChain = new MockFilterChain();
        JWTFilter jwtFilter = new JWTFilter(jwtProperties,tokenProvider);
        jwtFilter.doFilter(request,response,filterChain);
    }
}
