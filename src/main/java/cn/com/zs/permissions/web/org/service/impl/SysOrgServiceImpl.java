package cn.com.zs.permissions.web.org.service.impl;

import cn.com.zs.permissions.web.common.repository.BaseRepository;
import cn.com.zs.permissions.web.common.service.impl.BaseServiceImpl;
import cn.com.zs.permissions.web.org.entity.SysOrg;
import cn.com.zs.permissions.web.org.repository.SysOrgRepository;
import cn.com.zs.permissions.web.org.service.SysOrgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 标题: 机构业务实现类
 * <p>
 * 描述: 机构业务实现类
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/3-22:44
 */
@Service
@Slf4j
public class SysOrgServiceImpl extends BaseServiceImpl<SysOrg,String> implements SysOrgService{

    private final SysOrgRepository sysOrgRepository;

    public SysOrgServiceImpl(SysOrgRepository sysOrgRepository) {
        this.sysOrgRepository = sysOrgRepository;
    }


    @Override
    public BaseRepository<SysOrg, String> getRepository() {
        return this.sysOrgRepository;
    }
}
