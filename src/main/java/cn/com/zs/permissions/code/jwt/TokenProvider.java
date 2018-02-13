package cn.com.zs.permissions.code.jwt;

import cn.com.zs.permissions.utils.DateTimeUtils;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * 标题: jwt工具类
 * <p>
 * 描述: 创建jwt,验证jwt
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/4-21:13
 */
@Slf4j
@Component
public class TokenProvider {

    private static final String AUTHORITIES_KEY = "permissions";

    private String secretKey;

    private long tokenValidTime;

    private long tokenValidTimeRememberMe;

    private final JWTProperties jwtProperties;

    public TokenProvider(JWTProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    @PostConstruct
    public void init(){
        this.secretKey = jwtProperties.getSecretKey();
        this.tokenValidTime = jwtProperties.getTokenValidTime() * 1000;
        this.tokenValidTimeRememberMe = jwtProperties.getTokenValidTimeRememberMe() * 1000;
    }

    public String createToken(Authentication authentication, boolean rememberMe){
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        long now = DateTimeUtils.convertLDTToLong();
        Date validity;
        if (rememberMe){
            validity = new Date(now + this.tokenValidTimeRememberMe);
        } else {
            validity = new Date(now + this.tokenValidTime);
        }
        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim(AUTHORITIES_KEY,authentication)
                .signWith(SignatureAlgorithm.HS512,this.secretKey)
                .setExpiration(validity)
                .compact();
    }

    public  boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e){
            log.error("token验证失败",e);
        }
        return false;
    }
}
