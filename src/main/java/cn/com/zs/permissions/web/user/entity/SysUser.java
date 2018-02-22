package cn.com.zs.permissions.web.user.entity;

import cn.com.zs.permissions.web.common.entity.BaseEntity;
import cn.com.zs.permissions.web.role.entity.SysRole;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

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

    @Size(max = 50,min = 1,message = "用户名需在1~50长度之间")
    @Column(name = "user_name")
    private String userName;

    @Size(max = 100,min = 6,message = "密码需在6~100长度之间")
    @Column(name = "password")
    private String password;

    @Size(max = 50,min = 1,message = "真实姓名需在1~50长度之间")
    @Column(name = "real_name")
    private String realName;

    @NotNull(message = "性别不能为空")
    @Column(name = "sex")
    private Integer sex;

    @NotNull(message = "状态不能为空")
    @Column(name = "status")
    private Integer status;//0:禁用,1:正常,2:锁定

    @NotNull(message = "用户类型不能为空")
    @Column(name = "user_type")
    private Integer userType;//1:管理员,2:普通用户

    @Email(message = "邮箱格式错误")
    @Size(max = 30,min = 1,message = "邮箱长度需在1~30之间")
    @Column(name = "email")
    private String email;

    @Size(max = 20,min = 1,message = "工号长度需在1~20之间")
    @Column(name = "job_no")
    private String jobNo;

    @Column(name = "last_login_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;

    @Size(max = 255,min = 0,message = "用户描述长度需在0~255之间")
    @Column(name = "description")
    private String description;


    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE})
    @JoinTable(name = "sys_user_role",joinColumns =
            @JoinColumn(name = "user_id"),inverseJoinColumns =
            @JoinColumn(name = "role_id"))
    private Set<SysRole> roleSet =  new HashSet<>();

    @Override
    public void setId(String id) {
        this.userId = id;
    }


    @Override
    public String getId() {
        return this.userId;
    }
}
