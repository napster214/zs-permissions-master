package cn.com.zs.permissions.redis;

import cn.com.zs.permissions.web.user.entity.SysUser;
import cn.com.zs.permissions.web.user.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
 * @created 2018/2/22-21:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisCacheTest {

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void cacheTest(){
        SysUser sysUser = sysUserService.findByUserName("zhangsan123");
        System.out.println(sysUser.getUserName());
    }
}
