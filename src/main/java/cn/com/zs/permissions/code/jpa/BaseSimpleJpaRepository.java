package cn.com.zs.permissions.code.jpa;

import cn.com.zs.permissions.web.common.BaseEntity;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

/**
 * 标题: BaseSimpleJpaRepository
 * <p>
 * 描述: BaseSimpleJpaRepository
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/4-21:29
 */
@NoRepositoryBean
public class BaseSimpleJpaRepository<T extends BaseEntity,ID extends Serializable>
        extends SimpleJpaRepository<T,ID> implements BaseJpaRepository<T,ID>{

    public BaseSimpleJpaRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    public BaseSimpleJpaRepository(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }

    @Override
    public <S extends T> S save(S entity) {
        entity.beforeSave();
        S s = super.save(entity);
        entity.afterSave();
        return s;
    }

    @Override
    public <S extends T> S saveAndFlush(S entity) {
        entity.beforeSave();
        S s = super.saveAndFlush(entity);
        entity.afterSave();
        return s;
    }

    @Override
    public <S extends T> List<S> saveAll(Iterable<S> entities) {
        entities.forEach(s -> {
            s.beforeSave();
        });
        Object list = super.saveAll(entities);
        entities.forEach(s -> {
            s.afterSave();
        });
        return (List<S>) list;
    }
}
