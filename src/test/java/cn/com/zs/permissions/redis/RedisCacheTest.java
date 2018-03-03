package cn.com.zs.permissions.redis;

import cn.com.zs.permissions.web.user.entity.SysUser;
import cn.com.zs.permissions.web.user.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RedissonClient;
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
@Slf4j
public class RedisCacheTest {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void cacheTest(){
        SysUser sysUser = sysUserService.findByUserName("zhangsan1235");
        System.out.println(sysUser.getUserName());
    }

    @Test
    public void listTest(){

    }

    @Test
    public void stringTest(){

    }

    @Test
    public void setTest(){

    }

    @Test
    public void hashTest(){

    }
}
