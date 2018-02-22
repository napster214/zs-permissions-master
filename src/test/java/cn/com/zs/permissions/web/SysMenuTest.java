package cn.com.zs.permissions.web;

import cn.com.zs.permissions.web.menu.controller.SysMenuController;
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
 * @created 2018/2/14-22:10
 */
@SpringBootTest
@RunWith(SpringRunner.class )
public class SysMenuTest {

    @Autowired
    private SysMenuController sysMenuController;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(sysMenuController).build();
    }

    @Test
    public void saveTest(){

    }

    @Test
    public void deleteTest(){

    }

    @Test
    public void serachTest(){

    }
}
