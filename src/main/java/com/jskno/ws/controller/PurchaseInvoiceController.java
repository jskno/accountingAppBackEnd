package com.jskno.ws.controller;

import com.jskno.business.service.PurchaseInvoiceService;
import com.jskno.persistence.entity.PurchaseInvoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jose on 9/1/2017.
 */
@RestController
@RequestMapping("accounting/invoice/purchase")
public class PurchaseInvoiceController {

    @Autowired
    private PurchaseInvoiceService purchaseInvoiceService;

    @RequestMapping(path = "/new", method = RequestMethod.POST,
                    consumes = {MediaType.APPLICATION_JSON_VALUE},
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createPurchaseInvoice(@RequestBody PurchaseInvoice purchaseInvoice) {
        if(!invoiceAlreadyExists(purchaseInvoice)) {
            this.purchaseInvoiceService.createPurchaseInvoice(purchaseInvoice);
        } else {

        }
    }

    private boolean invoiceAlreadyExists(PurchaseInvoice purchaseInvoice) {
        return purchaseInvoiceService.invoiceAlreadyExists(purchaseInvoice);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET,
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<PurchaseInvoice> getPurchaseInvoices() {
        return this.purchaseInvoiceService.getAllPurchaseInvoices();
    }
}
