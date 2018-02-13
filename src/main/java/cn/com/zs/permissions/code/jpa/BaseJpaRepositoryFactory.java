package cn.com.zs.permissions.code.jpa;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.RepositoryMetadata;

import javax.persistence.EntityManager;

/**
 * 标题: BaseJpaRepositoryFactory
 * <p>
 * 描述: BaseJpaRepositoryFactory
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/4-21:29
 */
public class BaseJpaRepositoryFactory extends JpaRepositoryFactory{


    public BaseJpaRepositoryFactory(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
        return BaseSimpleJpaRepository.class;
    }
}
