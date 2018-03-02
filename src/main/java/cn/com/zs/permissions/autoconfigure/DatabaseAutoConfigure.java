package cn.com.zs.permissions.autoconfigure;

import cn.com.zs.permissions.code.liquibase.AsyncSpringLiquibase;
import liquibase.integration.spring.SpringLiquibase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
 * @created 2018/3/2-23:15
 */
@Configuration
@EnableTransactionManagement
@Slf4j
public class DatabaseAutoConfigure {

    @Bean
    public SpringLiquibase liquibase(){
        SpringLiquibase liquibase = new AsyncSpringLiquibase();
        return liquibase;
    }
}
