package cn.com.zs.permissions.web.org.entity;

import cn.com.zs.permissions.web.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;

/**
 * 标题: 机构实体
 * <p>
 * 描述: 机构实体
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
@Table(name = "sys_org")
public class SysOrg extends BaseEntity<String>{

    @Id
    @Column(name = "org_id")
    @GeneratedValue(generator = "idGenerated")
    @GenericGenerator(name = "idGenerated",strategy = "uuid")
    private String orgId;

    @Column(name = "org_name")
    private String orgName;

    @Column(name = "org_code")
    private String orgCode;

    @Column(name = "org_type")
    private Integer orgType;

    @Column(name = "org_status")
    private Integer orgStatus;

    @Column(name = "parent_id")
    private String parentId;

    @Column(name = "desc")
    private String desc;


    @Override
    public void setId(String id) {
        this.orgId = id;
    }


    @Override
    public String getId() {
        return this.orgId;
    }
}
