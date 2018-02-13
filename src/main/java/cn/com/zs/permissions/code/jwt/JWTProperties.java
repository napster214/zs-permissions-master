package cn.com.zs.permissions.code.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

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
@ConfigurationProperties(prefix = "zs.jwt",ignoreUnknownFields = false)
public class JWTProperties {

    private String secretKey = "zs-permissions-master-secretKey";

    private long tokenValidTime = 1800;//半个小时

    private long tokenValidTimeRememberMe = 2592000;//30小时

    private List<String> excludeUrlList = new ArrayList<>();

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public long getTokenValidTime() {
        return tokenValidTime;
    }

    public void setTokenValidTime(long tokenValidTime) {
        this.tokenValidTime = tokenValidTime;
    }

    public long getTokenValidTimeRememberMe() {
        return tokenValidTimeRememberMe;
    }

    public void setTokenValidTimeRememberMe(long tokenValidTimeRememberMe) {
        this.tokenValidTimeRememberMe = tokenValidTimeRememberMe;
    }

    public List<String> getExcludeUrlList() {
        return excludeUrlList;
    }

    public void setExcludeUrlList(List<String> excludeUrlList) {
        this.excludeUrlList = excludeUrlList;
    }
}
