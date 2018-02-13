package cn.com.zs.permissions.web.user;

import cn.com.zs.permissions.web.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
 * @created 2018/2/3-22:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "sys_user")
public class SysUser extends BaseEntity<String>{

    @Id
    @Column(name = "user_id")
    private String userId;

    @Override
    public void setId(String id) {
        this.userId = id;
    }

    @Nullable
    @Override
    public String getId() {
        return this.userId;
    }
}
