package cn.com.zs.permissions.jwt;

import cn.com.zs.permissions.code.jwt.TokenProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.junit4.SpringRunner;

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
 * @created 2018/2/13-10:29
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TokenTest {

    @Autowired
    private TokenProvider tokenProvider;

    @Test
    public void createTokenTest(){
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(
                        "test-user",
                        "test-password");
        tokenProvider.createToken(token,false);
    }

    @Test
    public void validateTokenTest(){
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(
                        "test-user",
                        "test-password",
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
        String tokenStr = tokenProvider.createToken(token,false);
        boolean isSuccess = tokenProvider.validateToken(tokenStr);
        System.out.println("验证是否成功："+isSuccess);
    }
}
