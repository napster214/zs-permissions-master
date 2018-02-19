package cn.com.zs.permissions.web.role.service.impl;

import cn.com.zs.permissions.web.common.repository.BaseRepository;
import cn.com.zs.permissions.web.common.service.impl.BaseServiceImpl;
import cn.com.zs.permissions.web.role.entity.SysRole;
import cn.com.zs.permissions.web.role.repository.SysRoleRepository;
import cn.com.zs.permissions.web.role.service.SysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 标题: 角色业务实现类
 * <p>
 * 描述: 角色业务实现类
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/3-22:42
 */
@Service
@Slf4j
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole,String> implements SysRoleService{

    private final SysRoleRepository sysRoleRepository;

    public SysRoleServiceImpl(SysRoleRepository sysRoleRepository) {
        this.sysRoleRepository = sysRoleRepository;
    }



    @Override
    public BaseRepository<SysRole, String> getRepository() {
        return this.sysRoleRepository;
    }

    @Override
    public Page<SysRole> serach(SysRole sysRole, Pageable pageable) {
        return null;
    }
}
