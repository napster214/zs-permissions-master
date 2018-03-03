package cn.com.zs.permissions.web.permissions.service.impl;

import cn.com.zs.permissions.web.common.repository.BaseRepository;
import cn.com.zs.permissions.web.common.service.impl.BaseServiceImpl;
import cn.com.zs.permissions.web.permissions.entity.SysPermissions;
import cn.com.zs.permissions.web.permissions.repository.SysPermissionsRepository;
import cn.com.zs.permissions.web.permissions.service.SysPermissionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
 * @created 2018/2/3-22:43
 */
@Service
@Slf4j
public class SysPermissionsServiceImpl extends BaseServiceImpl<SysPermissions,String> implements SysPermissionsService{

    private final SysPermissionsRepository sysPermissionsRepository;

    public SysPermissionsServiceImpl(SysPermissionsRepository sysPermissionsRepository) {
        this.sysPermissionsRepository = sysPermissionsRepository;
    }

    @Override
    public BaseRepository<SysPermissions, String> getRepository() {
        return this.sysPermissionsRepository;
    }
}
