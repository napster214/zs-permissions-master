package cn.com.zs.permissions.web.email;

import cn.com.zs.permissions.web.user.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.SpringTemplateLoader;

import javax.mail.internet.MimeMessage;

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
 * @created 2018/2/24-21:44
 */
@Service
@Slf4j
public class EmailServiceImpl implements EmailService{

    private final JavaMailSender javaMailSender;

    private final MessageSource messageSource;

    private final SpringTemplateLoader templateLoader;

    public EmailServiceImpl(JavaMailSender javaMailSender, MessageSource messageSource, SpringTemplateLoader templateLoader) {
        this.javaMailSender = javaMailSender;
        this.messageSource = messageSource;
        this.templateLoader = templateLoader;
    }

    @Override
    public void sendEmail(String to, String subject, String content, boolean isMultipart, boolean isHtml) {
        log.debug("Send email[multipart '{}' and html '{}'] to '{}' with subject '{}' and content={}",
                isMultipart,isHtml,to,subject,content);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
        try {
            message.setTo(to);
            message.setFrom("");
            message.setSubject(subject);
            message.setText(content,isHtml);
            javaMailSender.send(mimeMessage);
            log.debug("Sent email to User '{}'",to);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void sendEmailFromTemplate(SysUser sysUser, String templateName, String titleKey) {

    }

    @Override
    public void sendActivationEmail(SysUser sysUser) {

    }

    @Override
    public void sendCreationEmail(SysUser sysUser) {

    }

    @Override
    public void sendPasswordResetMail(SysUser sysUser) {

    }
}
