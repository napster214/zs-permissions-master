package cn.com.zs.permissions.utils.validator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 标题: 验证结果类
 * <p>
 * 描述: 验证结果类
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/15-11:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidatorResult {

    private String property;
    private String message;
}
