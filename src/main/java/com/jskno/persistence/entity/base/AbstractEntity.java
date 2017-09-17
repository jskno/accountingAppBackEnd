package com.jskno.persistence.entity.base;

import com.jskno.persistence.entity.listener.EntityListener;
import com.jskno.persistence.utils.LocalDateTimeConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Jose on 9/3/2017.
 */
@MappedSuperclass
@EntityListeners(EntityListener.class)
public abstract class AbstractEntity implements Serializable {

    @Column(name = "CREATED_BY_USER")
    private String createdByUser;

    @Column(name = "CREATED_AT")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_BY_USER")
    private String updateByUser;

    @Column(name = "UPDATED_AT")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime updatedAt;

    public String getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(String createdByUser) {
        this.createdByUser = createdByUser;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdateByUser() {
        return updateByUser;
    }

    public void setUpdateByUser(String updateByUser) {
        this.updateByUser = updateByUser;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
