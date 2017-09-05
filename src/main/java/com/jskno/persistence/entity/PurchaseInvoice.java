package com.jskno.persistence.entity;

import javax.persistence.*;

/**
 * Created by Jose on 9/1/2017.
 */
@Entity
@Table(name = "PURCHASE_INVOICES")
public class PurchaseInvoice {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
