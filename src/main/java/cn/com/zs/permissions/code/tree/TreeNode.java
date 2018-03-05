package cn.com.zs.permissions.code.tree;

import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 标题: 树节点
 * <p>
 * 描述: 树节点
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/20-1:14
 */
public class TreeNode implements Serializable{

    private Long id;//树ID
    private Long value;//树ID
    private String label;//菜单名称
    private String displayName;//菜单名称
    private boolean open;//是否展开
    private boolean checked;//是否选中
    private boolean isParent;//是否父节点
    private String iconSkin;//图标
    private List<TreeNode> children;
    private Map<String,Object> params;

    public TreeNode(Long id, String name, boolean open,boolean checked, boolean isParent)
    {
        this.id = id;
        this.value = id;
        this.label = name;
        this.displayName = name;
        this.open = open;
        this.checked = checked;
        this.isParent = isParent;
    }

    public TreeNode(Long id, String name, boolean open,boolean checked, boolean isParent, List<TreeNode> children)
    {
        this(id, name, open, checked, isParent);
        this.children = children;
    }

    public TreeNode setParam(String name, Object value)
    {
        if (value != null)
        {
            if (this.params == null) {
                this.params = Maps.newHashMap();
            }
            this.params.put(name, value);
        }
        return this;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }


    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }

    public String getIconSkin() {
        return iconSkin;
    }

    public void setIconSkin(String iconSkin) {
        this.iconSkin = iconSkin;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
