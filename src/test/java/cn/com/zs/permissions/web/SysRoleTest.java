package cn.com.zs.permissions.web;

import cn.com.zs.permissions.web.apply.entity.SysApply;
import cn.com.zs.permissions.web.apply.service.SysApplyService;
import cn.com.zs.permissions.web.org.entity.SysOrg;
import cn.com.zs.permissions.web.org.service.SysOrgService;
import cn.com.zs.permissions.web.role.controller.SysRoleController;
import cn.com.zs.permissions.web.role.entity.SysRole;
import cn.com.zs.permissions.web.role.service.SysRoleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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
 * @created 2018/2/14-22:09
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SysRoleTest {

    @Autowired
    private SysRoleController sysRoleController;

    @Autowired
    private SysOrgService sysOrgService;

    @Autowired
    private SysApplyService sysApplyService;

    @Autowired
    private SysRoleService sysRoleService;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(sysRoleController).build();
    }

    @Test
    public void saveTest(){
        SysApply sysApply = sysApplyService.save(buildApply());
        SysOrg sysOrg = sysOrgService.save(buildOrg());
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("创建角色");
        sysRole.setStatus(1);
        sysRole.setDescription("角色");
        sysRole.setSysApply(sysApply);
        sysRole.setSysOrg(sysOrg);
        sysRoleService.save(sysRole);
    }

    @Test
    public void deleteTest(){

    }

    @Test
    public void serachTest(){

    }

    private SysOrg buildOrg(){
        SysOrg sysOrg = new SysOrg();
        sysOrg.setOrgName("权限系统");
        sysOrg.setOrgCode("qxxt");
        sysOrg.setOrgStatus(1);
        sysOrg.setOrgType(1);
        sysOrg.setDescription("权限系统");
        return sysOrg;
    }

    private SysApply buildApply(){
        SysApply sysApply = new SysApply();
        sysApply.setApplyName("权限系统");
        sysApply.setApplyCode("qxxt");
        sysApply.setApplyStatus(1);
        return sysApply;
    }


}
