package cn.com.zs.permissions.autoconfigure;

import cn.com.zs.permissions.code.jpa.BaseJpaRepositoryFactory;
import cn.com.zs.permissions.code.jpa.BaseSimpleJpaRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/**
 * 标题: SpringDataJpa配置
 * <p>
 * 描述: SpringDataJpa配置
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/3-22:26
 */
@Configuration
@EnableJpaRepositories(repositoryBaseClass = BaseSimpleJpaRepository.class,
basePackages = "cn.com.zs.permissions.web.*.repository")
@EnableSpringDataWebSupport
public class SpringDataJpaAutoConfigure {
}
