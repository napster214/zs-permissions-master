package cn.com.zs.permissions.web.user.entity;

import cn.com.zs.permissions.web.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

/**
 * 标题: 用户信息实体
 * <p>
 * 描述: 用户信息实体
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
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator",strategy = "uuid")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "real_name")
    private String realName;

    @Column(name = "sex")
    private Integer sex;

    @Column(name = "status")
    private Integer status;//0:禁用,1:正常,2:锁定

    @Column(name = "user_type")
    private Integer userType;//1:管理员,2:普通用户

    @Column(name = "email")
    private String email;

    @Column(name = "job_no")
    private String jobNo;

    @Column(name = "last_login_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;

    @Column(name = "description")
    private String description;

    @Override
    public void setId(String id) {
        this.userId = id;
    }


    @Override
    public String getId() {
        return this.userId;
    }
}
