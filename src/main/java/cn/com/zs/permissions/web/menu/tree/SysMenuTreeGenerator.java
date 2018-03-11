package cn.com.zs.permissions.web.menu.tree;

import cn.com.zs.permissions.code.tree.TreeGenerator;
import cn.com.zs.permissions.code.tree.TreeNode;
import cn.com.zs.permissions.web.menu.entity.SysMenu;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

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
 * @created 2018/3/11-17:39
 */
@Component
public class SysMenuTreeGenerator extends TreeGenerator<SysMenu>{

    @Override
    protected List<SysMenu> root(Map<String, Object> paramMap) {
        return null;
    }

    @Override
    protected List<SysMenu> children(Map<String, Object> paramMap, Long paramStr) {
        return null;
    }

    @Override
    protected void setRootNodeParams(Map<String, Object> paramMap, TreeNode treeNode, SysMenu sysMenu) {

    }

    @Override
    protected void setNodePrams(Map<String, Object> paramMap, TreeNode treeNode, SysMenu sysMenu) {

    }

    @Override
    protected Long getNodeId(Map<String, Object> paramMap, SysMenu sysMenu) {
        return null;
    }

    @Override
    protected String getNodeName(Map<String, Object> paramMap, SysMenu sysMenu) {
        return null;
    }

    @Override
    protected Long getNodeParentId(Map<String, Object> paramMap, SysMenu sysMenu) {
        return null;
    }

    @Override
    protected boolean hasChildrenNode(Map<String, Object> paramMap, SysMenu sysMenu) {
        return false;
    }

    @Override
    protected boolean isRootNode(Map<String, Object> paramMap, SysMenu sysMenu) {
        return false;
    }
}
