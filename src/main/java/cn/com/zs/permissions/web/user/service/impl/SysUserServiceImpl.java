package cn.com.zs.permissions.web.user.service.impl;

import cn.com.zs.permissions.web.common.repository.BaseRepository;
import cn.com.zs.permissions.web.common.service.impl.BaseServiceImpl;
import cn.com.zs.permissions.web.user.entity.SysUser;
import cn.com.zs.permissions.web.user.repository.SysUserRepository;
import cn.com.zs.permissions.web.user.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 标题: 用户service实现类
 * <p>
 * 描述: 用户service实现类
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/3-22:41
 */
@Service
@Slf4j
public class SysUserServiceImpl extends BaseServiceImpl<SysUser,String> implements SysUserService {

    private final SysUserRepository sysUserRepository;

    public SysUserServiceImpl(SysUserRepository sysUserRepository) {
        this.sysUserRepository = sysUserRepository;
    }

    @Override
    public BaseRepository<SysUser, String> getRepository() {
        return sysUserRepository;
    }


    @Cacheable(value = "commonCaches")
    @Override
    public SysUser findByUserName(String userName) {
        return sysUserRepository.findByUserName(userName);
    }

    @Override
    public Page<SysUser> serach(SysUser sysUser, Pageable pageable) {
        return this.findAll(null,new PageRequest(pageable.getPageNumber(),
                pageable.getPageSize()));
    }
}
