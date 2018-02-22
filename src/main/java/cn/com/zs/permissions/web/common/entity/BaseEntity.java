package cn.com.zs.permissions.web.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * 标题: 实体基类
 * <p>
 * 描述: 实体基类
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/3-22:45
 */
@MappedSuperclass
@Audited
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity<PK extends Serializable> implements Persistable<PK>{

    @CreatedBy
    @Column(name = "create_user",nullable = false,updatable = false)
    @JsonIgnore
    private String createUser;

    @CreatedDate
    @Column(name = "create_date",nullable = false,updatable = false)
    @JsonIgnore
    private Date createDate;

    @LastModifiedBy
    @Column(name = "last_up_user")
    @JsonIgnore
    private String lastUpUser;

    @LastModifiedDate
    @Column(name = "last_up_date")
    @JsonIgnore
    private Date lastUpDate;


    @Override
    public boolean isNew() {
        return StringUtils.isEmpty(this.getId());
    }

    public void beforeSave(){
        if (this.isNew()){
            this.createDate = new Date();
        }
        this.lastUpDate = new Date();
    }

    public void afterSave(){

    }

    public abstract void setId(PK id);

}
