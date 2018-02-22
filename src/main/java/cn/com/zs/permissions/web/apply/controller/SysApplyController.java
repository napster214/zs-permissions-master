package cn.com.zs.permissions.web.apply.controller;

import cn.com.zs.permissions.utils.GsonUtils;
import cn.com.zs.permissions.web.apply.entity.SysApply;
import cn.com.zs.permissions.web.apply.service.SysApplyService;
import cn.com.zs.permissions.web.common.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
 * @created 2018/2/20-0:44
 */
@RestController
@RequestMapping("/api/apply")
@Slf4j
public class SysApplyController extends BaseController{

    private final SysApplyService sysApplyService;

    @PostMapping("/save")
    public ResponseEntity<SysApply> save(@Valid @RequestBody SysApply sysApply){
        log.debug("新增应用{}", GsonUtils.toJson(sysApply));
        sysApplyService.save(sysApply);
        return ResponseEntity.ok(sysApply);
    }

    @GetMapping("/delete/{applyId}")
    public ResponseEntity delete(@PathVariable String applyId){
        sysApplyService.delete(applyId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/serach")
    public ResponseEntity<Page<SysApply>> serach(@Valid SysApply sysApply, Pageable pageable){
        Page<SysApply> page = sysApplyService.serach(sysApply,pageable);
        return ResponseEntity.ok(page);
    }

    public SysApplyController(SysApplyService sysApplyService) {
        this.sysApplyService = sysApplyService;
    }
}
