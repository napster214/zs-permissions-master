package cn.com.zs.permissions.web.email;

import cn.com.zs.permissions.web.user.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
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
 * @created 2018/2/24-21:44
 */
@Service
@Slf4j
public class EmailServiceImpl implements EmailService{

    @Override
    public void sendEmail(String to, String subject, String content, boolean isMultipart, boolean isHtml) {

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
