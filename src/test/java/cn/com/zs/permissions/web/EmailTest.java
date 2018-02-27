package cn.com.zs.permissions.web;

import cn.com.zs.permissions.web.email.EmailService;
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
 * @created 2018/2/24-22:50
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class EmailTest {

    @Autowired
    private EmailService emailService;

    @Test
    public void sendEmailTest(){
        emailService.sendEmail("1","1","1",false,false);
    }
}
