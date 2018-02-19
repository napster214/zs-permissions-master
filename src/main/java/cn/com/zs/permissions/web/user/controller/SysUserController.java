package cn.com.zs.permissions.web.user.controller;

import cn.com.zs.permissions.web.common.controller.BaseController;
import cn.com.zs.permissions.web.user.service.SysUserService;
import cn.com.zs.permissions.web.user.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 标题: 用户控制器
 * <p>
 * 描述: 用户控制器
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/3-22:41
 */
@RestController
@RequestMapping("/api/user")
@Slf4j
public class SysUserController extends BaseController{

    private final SysUserService sysUserService;

    @PostMapping("/save")
    public ResponseEntity<SysUser> save(@RequestBody SysUser sysUser){
        return ResponseEntity.ok(sysUserService.save(sysUser));
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity delete(@PathVariable String userId){
        sysUserService.delete(userId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/serach")
    public ResponseEntity<Page<SysUser>> serach(SysUser sysUser,Pageable pageable){
        System.out.println("*************成功************");
        return null;
    }



    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }
}
