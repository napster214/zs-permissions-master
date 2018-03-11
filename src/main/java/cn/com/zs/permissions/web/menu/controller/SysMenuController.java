package cn.com.zs.permissions.web.menu.controller;

import cn.com.zs.permissions.web.common.controller.BaseController;
import cn.com.zs.permissions.web.menu.entity.SysMenu;
import cn.com.zs.permissions.web.menu.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
 * @created 2018/2/3-22:45
 */
@RestController
@RequestMapping("/api/menu")
@Slf4j
public class SysMenuController extends BaseController{

    private final SysMenuService sysMenuService;


    @PostMapping("/save")
    public ResponseEntity<SysMenu> save(@Valid @RequestBody SysMenu sysMenu){
        sysMenuService.save(sysMenu);
        return ResponseEntity.ok(sysMenu);
    }

    @GetMapping("/delete/{menuId}")
    public ResponseEntity delete(@PathVariable String menuId){
        sysMenuService.delete(menuId);
        return new ResponseEntity(HttpStatus.OK);
    }


    public SysMenuController(SysMenuService sysMenuService) {
        this.sysMenuService = sysMenuService;
    }
}
