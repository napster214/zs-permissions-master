package cn.com.zs.permissions.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 标题: 登录控制器
 * <p>
 * 描述: 登录控制器
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/14-10:48
 */
@RestController
@RequestMapping
public class LoginController {

    public ResponseEntity login(@Valid @RequestBody LoginVo loginVo){
        return new ResponseEntity(HttpStatus.OK);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class LoginVo{
        private String userName;
        private String password;
    }
}
