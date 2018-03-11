package cn.com.zs.permissions.web.org.controller;

import cn.com.zs.permissions.web.common.controller.BaseController;
import cn.com.zs.permissions.web.org.entity.SysOrg;
import cn.com.zs.permissions.web.org.service.SysOrgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 标题: 机构控制器
 * <p>
 * 描述: 机构控制器
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/3-22:44
 */
@RestController
@RequestMapping("/api/org")
@Slf4j
public class SysOrgController extends BaseController{

    private final SysOrgService sysOrgService;


    @PostMapping("/save")
    public ResponseEntity<SysOrg> save(@Valid @RequestBody SysOrg sysOrg){
        sysOrgService.save(sysOrg);
        return ResponseEntity.ok(sysOrg);
    }

    @GetMapping("/delete/{orgId}")
    public ResponseEntity delete(@PathVariable String orgId){
        sysOrgService.delete(orgId);
        return new ResponseEntity(HttpStatus.OK);
    }

    public SysOrgController(SysOrgService sysOrgService) {
        this.sysOrgService = sysOrgService;
    }


}
