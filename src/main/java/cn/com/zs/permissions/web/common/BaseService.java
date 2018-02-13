package cn.com.zs.permissions.web.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * 标题: 基类service接口
 * <p>
 * 描述: 基类service接口
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/3-22:46
 */
public interface BaseService<T extends BaseEntity,ID extends Serializable> {

    T save(T t);

    <S extends T> List<S> save(Iterable<S> var1);

    T saveAndFlush(T t);

    void delete(ID id);

    boolean exists(ID id);

    Optional<T> findOne(ID id);

    Optional<T> findOne(Specification<T> specification);

    List<T> findAll(Specification<T> specification);

    Page<T> findAll(Specification<T> specification, Pageable pageable);

    long count(Specification<T> specification);


}
