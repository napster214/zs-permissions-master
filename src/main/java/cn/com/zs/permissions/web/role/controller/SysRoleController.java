package cn.com.zs.permissions.web.role.controller;

import cn.com.zs.permissions.web.role.entity.SysRole;
import cn.com.zs.permissions.web.role.service.SysRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 标题: 角色控制器
 * <p>
 * 描述: 角色控制器
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/3-22:42
 */
@RestController
@RequestMapping("/api/role")
public class SysRoleController {

    private final SysRoleService sysRoleService;

    @PostMapping("/save")
    public ResponseEntity<SysRole> save(@Valid @RequestBody SysRole sysRole){
        sysRoleService.save(sysRole);
        return ResponseEntity.ok(sysRole);
    }

    @GetMapping("/delete/{roleId}")
    public ResponseEntity delete(String roleId){
        sysRoleService.delete(roleId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/serach")
    public ResponseEntity<Page<SysRole>> serach(SysRole sysRole,@PageableDefault Pageable pageable){
        Page<SysRole> page = sysRoleService.serach(sysRole,pageable);
        return ResponseEntity.ok(page);
    }

    public SysRoleController(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }


}
