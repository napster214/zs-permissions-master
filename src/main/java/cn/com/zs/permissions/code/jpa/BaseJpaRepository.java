package cn.com.zs.permissions.code.jpa;

import cn.com.zs.permissions.web.common.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * 标题: BaseJpaRepository
 * <p>
 * 描述: BaseJpaRepository
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/4-21:29
 */
@NoRepositoryBean
public interface BaseJpaRepository<T extends BaseEntity,ID extends Serializable> extends JpaRepository<T,ID> {
}
