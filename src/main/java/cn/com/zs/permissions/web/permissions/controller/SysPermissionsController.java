package cn.com.zs.permissions.web.permissions.controller;

import cn.com.zs.permissions.web.common.controller.BaseController;
import cn.com.zs.permissions.web.permissions.service.SysPermissionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
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
 * @created 2018/2/3-22:43
 */
@RestController
@RequestMapping("/permissions")
@Slf4j
public class SysPermissionsController extends BaseController{

    private final SysPermissionsService sysPermissionsService;

    public SysPermissionsController(SysPermissionsService sysPermissionsService) {
        this.sysPermissionsService = sysPermissionsService;
    }
}
