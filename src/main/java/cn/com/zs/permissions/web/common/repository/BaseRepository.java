package cn.com.zs.permissions.web.common.repository;


import cn.com.zs.permissions.code.jpa.BaseJpaRepository;
import cn.com.zs.permissions.web.common.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * 标题: BaseRepository
 * <p>
 * 描述: BaseRepository
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/3-22:45
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity,ID extends Serializable>
        extends BaseJpaRepository<T,ID>,JpaSpecificationExecutor<T>{
}
