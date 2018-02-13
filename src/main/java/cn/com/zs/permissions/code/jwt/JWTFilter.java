package cn.com.zs.permissions.code.jwt;

import cn.com.zs.permissions.code.Constants;
import cn.com.zs.permissions.utils.GsonUtils;
import cn.com.zs.permissions.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 标题: jwt过滤器
 * <p>
 * 描述: jwt过滤器
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/3-22:50
 */
public class JWTFilter extends GenericFilterBean{

    private final JWTProperties jwtProperties;

    private final TokenProvider tokenProvider;

    public JWTFilter(JWTProperties jwtProperties, TokenProvider tokenProvider) {
        this.jwtProperties = jwtProperties;
        this.tokenProvider = tokenProvider;
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String accessUrlStr = request.getRequestURI();
        boolean isMatch = jwtProperties.getExcludeUrlList().stream()
                .filter(excludeUrl -> excludeUrl.equals(accessUrlStr))
                .findAny()
                .isPresent();
        if (!isMatch){
            String token = getToken(request);
            boolean validToken = tokenProvider.validateToken(token);
            if (!validToken){
                String jsonStr = GsonUtils.toJson(ResponseEntity.status(HttpStatus.FORBIDDEN)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .body("token验证失败，请重新登录"));
                WebUtils.writeJson(response,jsonStr.getBytes());
                return;
            }
        }
        filterChain.doFilter(request,response);
    }


    private String getToken(HttpServletRequest request){
        String bearerToken = request.getHeader(Constants.AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearerToken)
                && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7,bearerToken.length());
        }
        return null;
    }

}
