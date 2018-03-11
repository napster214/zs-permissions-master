package cn.com.zs.permissions.web.org.tree;

import cn.com.zs.permissions.code.tree.TreeGenerator;
import cn.com.zs.permissions.code.tree.TreeNode;
import cn.com.zs.permissions.web.org.entity.SysOrg;
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
 * 公司: 广州点睿信息科技有限公司
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/3/11-17:40
 */
@Component
public class SysOrgTreeGenerator extends TreeGenerator<SysOrg>{

    @Override
    protected List<SysOrg> root(Map<String, Object> paramMap) {
        return null;
    }

    @Override
    protected List<SysOrg> children(Map<String, Object> paramMap, Long paramStr) {
        return null;
    }

    @Override
    protected void setRootNodeParams(Map<String, Object> paramMap, TreeNode treeNode, SysOrg sysOrg) {

    }

    @Override
    protected void setNodePrams(Map<String, Object> paramMap, TreeNode treeNode, SysOrg sysOrg) {

    }

    @Override
    protected Long getNodeId(Map<String, Object> paramMap, SysOrg sysOrg) {
        return null;
    }

    @Override
    protected String getNodeName(Map<String, Object> paramMap, SysOrg sysOrg) {
        return null;
    }

    @Override
    protected Long getNodeParentId(Map<String, Object> paramMap, SysOrg sysOrg) {
        return null;
    }

    @Override
    protected boolean hasChildrenNode(Map<String, Object> paramMap, SysOrg sysOrg) {
        return false;
    }

    @Override
    protected boolean isRootNode(Map<String, Object> paramMap, SysOrg sysOrg) {
        return false;
    }
}
