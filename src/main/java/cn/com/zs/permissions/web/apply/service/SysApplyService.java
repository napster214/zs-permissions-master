package cn.com.zs.permissions.web.apply.service;

import cn.com.zs.permissions.web.apply.entity.SysApply;
import cn.com.zs.permissions.web.common.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;

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
 * @created 2018/2/20-0:44
 */
public interface SysApplyService extends BaseService<SysApply,String>{

    Page<SysApply> serach(@Valid SysApply sysApply, Pageable pageable);
}
