package cn.com.zs.permissions.web.user.service;

import cn.com.zs.permissions.web.common.service.BaseService;
import cn.com.zs.permissions.web.user.entity.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
 * @created 2018/2/3-22:41
 */
public interface SysUserService extends BaseService<SysUser,String>{

    Page<SysUser> serach(SysUser sysUser, Pageable pageable);
}
