package com.jskno.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Jose on 9/1/2017.
 */
@Entity
@Table(name = "PURCHASE_INVOICES")
public class PurchaseInvoice extends Invoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @JsonProperty(value = "purchaseInvClassifData")
    @OneToOne(mappedBy = "purchaseInvoice", cascade = CascadeType.ALL)
    private PurchaseInvoiceClassifData purchaseInvoiceClassifData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PurchaseInvoiceClassifData getPurchaseInvoiceClassifData() {
        return purchaseInvoiceClassifData;
    }

    public void setPurchaseInvoiceClassifData(PurchaseInvoiceClassifData purchaseInvoiceClassifData) {
        this.purchaseInvoiceClassifData = purchaseInvoiceClassifData;
        purchaseInvoiceClassifData.setPurchaseInvoice(this);
    }
}
