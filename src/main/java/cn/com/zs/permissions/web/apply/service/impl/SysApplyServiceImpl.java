package cn.com.zs.permissions.web.apply.service.impl;

import cn.com.zs.permissions.web.apply.entity.SysApply;
import cn.com.zs.permissions.web.apply.repository.SysApplyRepository;
import cn.com.zs.permissions.web.apply.service.SysApplyService;
import cn.com.zs.permissions.web.common.repository.BaseRepository;
import cn.com.zs.permissions.web.common.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
 * @created 2018/2/20-0:44
 */
@Service
@Slf4j
public class SysApplyServiceImpl extends BaseServiceImpl<SysApply,String> implements SysApplyService{


    private final SysApplyRepository sysApplyRepository;

    public SysApplyServiceImpl(SysApplyRepository sysApplyRepository) {
        this.sysApplyRepository = sysApplyRepository;
    }

    @Override
    public BaseRepository<SysApply, String> getRepository() {
        return this.sysApplyRepository;
    }

    @Override
    public Page<SysApply> serach(SysApply sysApply, Pageable pageable) {
        return null;
    }
}
