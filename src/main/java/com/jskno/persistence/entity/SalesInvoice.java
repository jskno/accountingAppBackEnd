package com.jskno.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Jose on 9/1/2017.
 */
@Entity
@Table(name = "SALES_INVOICES")
public class SalesInvoice extends Invoice implements Serializable {

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
