package cn.com.zs.permissions.web.menu.entity;

import cn.com.zs.permissions.web.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;

/**
 * 标题: 菜单实体
 * <p>
 * 描述: 菜单实体
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/3-22:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sys_menu")
public class SysMenu extends BaseEntity<String>{

    @Id
    @Column(name = "menu_id")
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator",strategy = "uuid")
    private String menuId;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_order")
    private Integer menuOrder;

    @Column(name = "menu_level")
    private Integer menuLevel;

    @Column(name = "parent_id")
    private String parentId;

    @Column(name = "icon")
    private String icon;

    @Column(name = "menu_url")
    private String menuUrl;

    @Column(name = "menu_status")
    private Integer menuStatus;

    @Override
    public void setId(String id) {
        this.menuId = id;
    }


    @Override
    public String getId() {
        return this.menuId;
    }
}
