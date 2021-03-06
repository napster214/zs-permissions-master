package cn.com.zs.permissions.web.role.entity;

import cn.com.zs.permissions.web.apply.entity.SysApply;
import cn.com.zs.permissions.web.common.entity.BaseEntity;
import cn.com.zs.permissions.web.org.entity.SysOrg;
import cn.com.zs.permissions.web.user.entity.SysUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 标题: 角色实体
 * <p>
 * 描述: 角色实体
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/3-22:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sys_role")
public class SysRole extends BaseEntity<String> {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator",strategy = "uuid")
    private String roleId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "status")
    private Integer status;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "roleSet")
    private Set<SysUser> userSet = new HashSet<>();

    @OneToOne(targetEntity = SysOrg.class)
    @JoinColumn(name = "org_id")
    private SysOrg sysOrg;

    @OneToOne(targetEntity = SysApply.class)
    @JoinColumn(name = "apply_id")
    private SysApply sysApply;

    @Override
    public void setId(String id) {
        this.roleId = id;
    }

    @Override
    public String getId() {
        return this.roleId;
    }
}
