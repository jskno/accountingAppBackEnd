//@formatter:off
/**
 *  $$Id$$
 *       . * .
 *     * RRRR  *    Copyright (c) 2017 EUIPO: European Union Intellectual
 *   .   RR  R   .  Property Office (trade marks and designs)
 *   *   RRR     *
 *    .  RR RR  .   ALL RIGHTS RESERVED
 *     * . _ . *
 */
//@formatter:on
package com.jskno.persistence.entity.listener;

import com.jskno.persistence.entity.base.AbstractEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

/**
 * Created by Jose on 9/13/2017.
 */
public class EntityListener {

    @PrePersist
    public void onCreate(final AbstractEntity entity) {
        final String currentUserId = "SYSTEM"; //getCurrentUID();
        final LocalDateTime currentDate = LocalDateTime.now();
        entity.setCreatedAt(currentDate);
        entity.setCreatedByUser(currentUserId);
        entity.setUpdatedAt(currentDate);
        entity.setUpdateByUser(currentUserId);
    }

    @PreUpdate
    public void onUpdate(final AbstractEntity entity) {
        final LocalDateTime currentDate = LocalDateTime.now();
        final String currentUserId = "SYSTEM"; //getCurrentUID();
        entity.setUpdatedAt(currentDate);
        entity.setUpdateByUser(currentUserId);
    }
}
