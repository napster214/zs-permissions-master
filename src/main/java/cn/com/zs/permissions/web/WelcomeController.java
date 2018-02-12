package cn.com.zs.permissions.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
 * @created 2018/2/3-20:10
 */
@RestController
public class WelcomeController {

    @GetMapping("/helloword")
    public String helloword(){
        return "helloword";
    }
}
