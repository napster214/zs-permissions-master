package cn.com.zs.permissions.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 标题:
 * <p>
 * 描述:
 * <p>
 * 版权: Copyright (c) 2017
 * <p>
 * 公司: 广州点睿信息科技有限公司
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2017/12/27-10:16
 */
@RestController
public class IndexController {

    @GetMapping("/helloword")
    public String helloword(){
        return "helloword";
    }
}
