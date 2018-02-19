package cn.com.zs.permissions.web.role.service;

import cn.com.zs.permissions.web.common.service.BaseService;
import cn.com.zs.permissions.web.role.entity.SysRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

/**
 * 标题: 角色service
 * <p>
 * 描述: 角色service
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/3-22:42
 */
public interface SysRoleService extends BaseService<SysRole,String>{

    Page<SysRole> serach(SysRole sysRole,Pageable pageable);
}
