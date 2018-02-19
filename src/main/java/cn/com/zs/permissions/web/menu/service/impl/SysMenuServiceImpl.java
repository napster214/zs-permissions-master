package cn.com.zs.permissions.web.menu.service.impl;

import cn.com.zs.permissions.web.common.repository.BaseRepository;
import cn.com.zs.permissions.web.common.service.impl.BaseServiceImpl;
import cn.com.zs.permissions.web.menu.entity.SysMenu;
import cn.com.zs.permissions.web.menu.repository.SysMenuRepository;
import cn.com.zs.permissions.web.menu.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 标题: 业务实现类
 * <p>
 * 描述: 业务实现类
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/3-22:45
 */
@Service
@Slf4j
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu,String> implements SysMenuService{

    private final SysMenuRepository sysMenuRepository;

    public SysMenuServiceImpl(SysMenuRepository sysMenuRepository) {
        this.sysMenuRepository = sysMenuRepository;
    }

    @Override
    public BaseRepository<SysMenu, String> getRepository() {
        return this.sysMenuRepository;
    }
}
