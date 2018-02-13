package cn.com.zs.permissions.web.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * 标题: 基类service实现类
 * <p>
 * 描述: 基类service实现类
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/3-22:46
 */
@Service
public abstract class BaseServiceImpl<T extends BaseEntity,ID extends Serializable>
        implements BaseService<T,ID> {

    @Override
    public T save(T t) {
        return this.getRepository().save(t);
    }

    @Override
    public <S extends T> List<S> save(Iterable<S> iterable) {
        return this.getRepository().saveAll(iterable);
    }

    @Override
    public T saveAndFlush(T t) {
        return this.getRepository().saveAndFlush(t);
    }

    @Override
    public void delete(ID id) {
        this.getRepository().deleteById(id);
    }

    @Override
    public boolean exists(ID id) {
        return this.getRepository().existsById(id);
    }

    @Override
    public Optional<T> findOne(ID id) {
        return this.getRepository().findById(id);
    }

    @Override
    public Optional<T> findOne(Specification<T> specification) {
        return this.getRepository().findOne(specification);
    }

    @Override
    public List<T> findAll(Specification<T> specification) {
        return this.findAll(specification);
    }

    @Override
    public Page<T> findAll(Specification<T> specification, Pageable pageable) {
        return this.findAll(specification,pageable);
    }

    @Override
    public long count(Specification<T> specification) {
        return 0;
    }

    public abstract BaseRepository<T,ID> getRepository();
}
