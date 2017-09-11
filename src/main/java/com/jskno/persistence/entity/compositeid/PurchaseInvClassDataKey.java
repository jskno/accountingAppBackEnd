package com.jskno.persistence.entity.compositeid;

import com.jskno.persistence.entity.PurchaseInvoice;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * Created by Jose on 9/6/2017.
 */
@Embeddable
public class PurchaseInvClassDataKey implements Serializable {

    @OneToOne
    @JoinColumn(name = "PURCHASE_INVOICE_CLASS_DATA_ID")
    private PurchaseInvoice purchaseInvoice;
}
