package cn.com.zs.permissions.web.permissions.entity;

import cn.com.zs.permissions.web.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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
 * @created 2018/2/3-22:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sys_permissions")
public class SysPermissions extends BaseEntity<String>{

    @Id
    @Column(name = "permission_id")
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator",strategy = "uuid")
    private String permissionId;

    @Column(name = "permission_name")
    private String permissionName;

    @Column(name = "permission_code")
    private String permissionCode;

    @Column(name = "permission_type")
    private Integer permissionType;

    @Override
    public void setId(String id) {
        this.permissionId = id;
    }

    @Override
    public String getId() {
        return this.permissionId;
    }
}
