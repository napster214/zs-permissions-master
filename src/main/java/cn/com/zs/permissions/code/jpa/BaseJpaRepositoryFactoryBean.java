package cn.com.zs.permissions.code.jpa;

import cn.com.zs.permissions.web.common.BaseEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;


import javax.persistence.EntityManager;
import java.io.Serializable;

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
 * @created 2018/2/4-21:29
 */
public class BaseJpaRepositoryFactoryBean<T extends Repository<S,ID>,
        S extends BaseEntity,ID extends Serializable> extends JpaRepositoryFactoryBean<T,S,ID>{

    public BaseJpaRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new BaseJpaRepositoryFactory(entityManager);
    }
}
