package cn.com.zs.permissions.code.tree;


import cn.com.zs.permissions.utils.CollectionUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 标题: 树型生成器
 * <p>
 * 描述: 所有树型需要继承此类
 * <p>
 * 版权: Copyright (c) 2017
 * <p>
 * 公司: 广州点睿信息科技有限公司
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2017/12/9-0:08
 */
public abstract class TreeGenerator<T> {

    private static final String PARENT_ID_RARAM_NAME = "parentId";

    private Map<String, Object> defaultNodeParams = Maps.newHashMap();

    protected abstract List<T> root(Map<String, Object> paramMap);

    protected abstract List<T> children(Map<String, Object> paramMap, Long paramStr);

    protected abstract void setRootNodeParams(Map<String, Object> paramMap, TreeNode treeNode, T t);

    protected abstract void setNodePrams(Map<String, Object> paramMap, TreeNode treeNode, T t);

    protected abstract Long getNodeId(Map<String, Object> paramMap, T t);

    protected abstract String getNodeName(Map<String, Object> paramMap, T t);

    protected abstract Long getNodeParentId(Map<String, Object> paramMap, T t);

    protected abstract boolean hasChildrenNode(Map<String, Object> paramMap, T t);

    protected abstract boolean isRootNode(Map<String, Object> paramMap, T t);

    private boolean isNotRootNode(Map<String, Object> paramMap, T t) {
        return !isRootNode(paramMap, t);
    }


    public final List<TreeNode> genFullTree(boolean nodeOpen, List<Long> checkIdList) {
        return genFullTree(nodeOpen, defaultNodeParams, checkIdList);
    }

    public final List<TreeNode> genFullTree(boolean nodeOpen, Map<String, Object> paramMap, List<Long> checkIdList) {
        List<T> rootList = root(paramMap);
        if (CollectionUtils.isNotEmpty(rootList)) {
            List<TreeNode> treeNodeList = Lists.newArrayList();
            for (T t : rootList) {
                List<T> childrenList = children(paramMap, getNodeId(paramMap, t));
                boolean isParent = checkRootNodeIsParent(paramMap, childrenList);
                boolean checked = checkIdList.contains(getNodeId(paramMap, t));
                TreeNode treeNode = new TreeNode(getNodeId(paramMap, t), getNodeName(paramMap, t), nodeOpen, checked, isParent,
                        genChildrenNode(childrenList, nodeOpen, paramMap, checkIdList));
                treeNode.setParams(this.defaultNodeParams);
                treeNode.setParam("parentId", getNodeParentId(paramMap, t));
                setRootNodeParams(paramMap, treeNode, t);
                treeNodeList.add(treeNode);
            }
            return treeNodeList;
        }
        return CollectionUtils.emptyList();
    }

    private boolean checkRootNodeIsParent(Map<String, Object> paramMap, List<T> childrenList) {
        int childrenSize = childrenList.size();
        return (childrenSize > 1) || ((childrenSize == 1) && isNotRootNode(paramMap, childrenList.get(0)));
    }

    private List<TreeNode> genChildrenNode(List<T> nodeList, boolean nodeOpen, Map<String, Object> paramMap, List<Long> checkIdList) {
        if (CollectionUtils.isEmpty(nodeList)) {
            return CollectionUtils.emptyList();
        }
        List<TreeNode> treeNodeList = Lists.newArrayList();
        for (T t : nodeList) {
            if (isNotRootNode(paramMap, t)) {
                List<T> children = children(paramMap, getNodeId(paramMap, t));
                boolean checked = checkIdList.contains(getNodeId(paramMap, t));
                if (CollectionUtils.isEmpty(children)) {
                    TreeNode treeNode = new TreeNode(getNodeId(paramMap, t), getNodeName(paramMap, t), true, checked, false);
                    treeNode.setParams(this.defaultNodeParams);
                    treeNode.setParam("parentId", getNodeParentId(paramMap, t));
                    setNodePrams(paramMap, treeNode, t);
                    treeNodeList.add(treeNode);
                } else {
                    TreeNode treeNode = new TreeNode(getNodeId(paramMap, t), getNodeName(paramMap, t),
                            nodeOpen, checked, true,
                            genChildrenNode(children, nodeOpen, paramMap, checkIdList));
                    treeNode.setParams(this.defaultNodeParams);
                    treeNode.setParam("parentId", getNodeParentId(paramMap, t));
                    setNodePrams(paramMap, treeNode, t);
                    treeNodeList.add(treeNode);
                }
            }
        }
        return treeNodeList;
    }


    public final List<TreeNode> genAsyncTree(Long parentId, List<Long> checkIdList) {
        return genAsyncTree(parentId, defaultNodeParams, checkIdList);
    }

    private List<TreeNode> genAsyncTree(Long parentId, Map<String, Object> paramMap, List<Long> checkIdList) {

        List<T> rootList = root(paramMap);
        List<TreeNode> treeNodeList = Lists.newArrayList();
        T t;
        if (parentId != null) {
            if (CollectionUtils.isNotEmpty(rootList)) {
                for (Iterator localIterator = rootList.iterator(); localIterator.hasNext(); ) {
                    t = (T) localIterator.next();
                    boolean checked = checkIdList.contains(getNodeId(paramMap, t));
                    TreeNode treeNode = new TreeNode(getNodeId(paramMap, t), getNodeName(paramMap, t),
                            false, checked, true);
                    treeNode.setParams(this.defaultNodeParams);
                    treeNode.setParam("parentId", getNodeParentId(paramMap, t));
                    setRootNodeParams(paramMap, treeNode, t);
                    treeNodeList.add(treeNode);
                }
                return treeNodeList;
            }
        } else {
            List<T> childrenList = children(paramMap, parentId);
            for (T children : childrenList) {
                if (isNotRootNode(paramMap, children)) {
                    boolean checked = checkIdList.contains(getNodeId(paramMap, children));
                    TreeNode treeNode = new TreeNode(getNodeId(paramMap, children),
                            getNodeName(paramMap, children), false, checked, true);
                    treeNode.setParams(this.defaultNodeParams);
                    treeNode.setParam("parentId", getNodeParentId(paramMap, children));
                    setRootNodeParams(paramMap, treeNode, children);
                    treeNodeList.add(treeNode);

                }
            }
            return treeNodeList;
        }
        return treeNodeList;
    }

    public Map<String, Object> getDefaultNodeParams() {
        return defaultNodeParams;
    }

    public void setDefaultNodeParams(Map<String, Object> defaultNodeParams) {
        this.defaultNodeParams = defaultNodeParams;
    }
}
