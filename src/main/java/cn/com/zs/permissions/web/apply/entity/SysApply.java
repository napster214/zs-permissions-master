package cn.com.zs.permissions.web.apply.entity;

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
 * @created 2018/2/20-0:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sys_apply")
public class SysApply extends BaseEntity<String>{

    @Id
    @Column(name = "apply_id")
    @GeneratedValue(generator = "idGenerated")
    @GenericGenerator(name = "idGenerated",strategy = "uuid")
    private String applyId;

    @Column(name = "apply_name")
    private String applyName;

    @Column(name = "apply_code")
    private String applyCode;

    @Column(name = "apply_status")
    private Integer applyStatus;

    @Column(name = "description")
    private String description;

    @Override
    public void setId(String id) {
        this.applyId = id;
    }

    @Override
    public String getId() {
        return applyId;
    }
}
