package com.jskno.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Jose on 9/1/2017.
 */
@Entity
@Table(name = "purchase_invoices")
public class PurchaseInvoice {

    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
