package cn.com.zs.permissions.web.email;

import cn.com.zs.permissions.web.user.entity.SysUser;

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
 * @created 2018/2/24-21:43
 */
public interface EmailService {

    void sendEmail(String to,String subject,String content,boolean isMultipart,boolean isHtml);

    void sendEmailFromTemplate(SysUser sysUser,String templateName,String titleKey);

    void sendActivationEmail(SysUser sysUser);

    void sendCreationEmail(SysUser sysUser);

    void sendPasswordResetMail(SysUser sysUser);
}
