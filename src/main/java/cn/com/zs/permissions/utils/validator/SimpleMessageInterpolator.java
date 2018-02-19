package cn.com.zs.permissions.utils.validator;

import cn.com.zs.permissions.web.user.entity.SysUser;
import org.hibernate.validator.messageinterpolation.AbstractMessageInterpolator;

import javax.validation.MessageInterpolator;
import java.util.Locale;

/**
 * 标题: 验证消息实现类
 * <p>
 * 描述: 验证消息实现类
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/15-11:45
 */
public class SimpleMessageInterpolator extends AbstractMessageInterpolator{

    @Override
    public String interpolate(Context context, Locale locale, String message) {
        return message;
    }
}
