package cn.com.zs.permissions.web.common;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

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
 * @created 2018/2/3-22:45
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {


    private String createUser;

    private Instant createDate = Instant.now();

    private String lastUpUser;

    private Instant lastUpDate = Instant.now();
}
