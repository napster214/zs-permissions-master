package cn.com.zs.permissions.email;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
 * @created 2018/2/28-22:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailTest {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Test
    public void sendSimpleMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(sender);
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        javaMailSender.send(message);
    }
}
