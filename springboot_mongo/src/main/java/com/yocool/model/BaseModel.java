package com.yocool.model;

/**
 * Author tangzq.
 */

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseModel<ID extends Serializable> implements Persistable<ID> {
    private static final long serialVersionUID = 1L;
    @Id
    private ID id;
    @Version
    private Long version;
    @Field("create_at")
    @CreatedDate
    private Date createAt;
    @Field("update_at")
    @LastModifiedDate
    private Date updateAt;

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
