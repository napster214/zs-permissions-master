package cn.com.zs.permissions.web;

import cn.com.zs.permissions.utils.GsonUtils;
import cn.com.zs.permissions.web.menu.controller.SysMenuController;
import cn.com.zs.permissions.web.org.controller.SysOrgController;
import cn.com.zs.permissions.web.role.controller.SysRoleController;
import cn.com.zs.permissions.web.role.entity.SysRole;
import cn.com.zs.permissions.web.role.service.SysRoleService;
import cn.com.zs.permissions.web.user.entity.SysUser;
import cn.com.zs.permissions.web.user.controller.SysUserController;
import cn.com.zs.permissions.web.user.service.SysUserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
 * @created 2018/2/13-23:01
 */
@RunWith(SpringRunner.class)
//@WebMvcTest({SysUserController.class, SysRoleController.class
//        , SysMenuController.class, SysOrgController.class})
//@AutoConfigureRestDocs(outputDir = "target/snippets")
@SpringBootTest
public class SysUserTest {

    @Autowired
    private SysUserController sysUserController;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(sysUserController)
                .setCustomArgumentResolvers(pageableArgumentResolver).build();
    }


    @Test
    public void saveTest() throws Exception {
        String json = GsonUtils.toJson(buildSysUser());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/save")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcRestDocumentation.document("home"));
    }

    @Test
    public void deleteTest() throws Exception {
       SysUser sysUser = sysUserService.save(buildSysUser());
       mockMvc.perform(MockMvcRequestBuilders.delete("/api/user/delete/{userId}",sysUser.getUserId()))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andDo(MockMvcRestDocumentation.document("home"));
    }

    @Test
    public void serachTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/serach"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcRestDocumentation.document("home"));
    }


    @Test
    public void roleSaveTest(){
        sysRoleService.save(buildSysRole());
    }


    private SysUser buildSysUser(){
        SysUser sysUser = new SysUser();
        sysUser.setDescription("创建用户");
        sysUser.setEmail("616394599@qq.com");
        sysUser.setJobNo("20180214");
        sysUser.setLastLoginTime(new Date());
        sysUser.setPassword("123456");
        sysUser.setRealName("张三");
        sysUser.setSex(1);
        sysUser.setUserName("zhangsan123");
        sysUser.setUserType(2);
        sysUser.setStatus(1);
        Set<SysRole> roleSet = new HashSet<>();
        roleSet.add(buildSysRole());
        sysUser.setRoleSet(roleSet);
        return sysUser;
    }

    private SysRole buildSysRole(){
        SysRole sysRole = new SysRole();
        sysRole.setDescription("1");
        sysRole.setRoleName("1");
        sysRole.setStatus(1);
        sysRoleService.save(sysRole);
        return sysRole;
    }


}
