package com.jskno.ws.controller;

import com.jskno.business.service.SalesInvoiceService;
import com.jskno.persistence.entity.SalesInvoice;
import com.jskno.persistence.repository.SalesInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.*;

/**
 * Created by Jose on 9/1/2017.
 */
@RestController
@RequestMapping("accounting/invoice/sales")
public class SalesInvoiceController {

    @Autowired
    private SalesInvoiceService salesInvoiceService;

    @RequestMapping(path = "/new", method = RequestMethod.POST,
                    consumes = { MediaType.APPLICATION_JSON_VALUE},
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public void createSalesInvoice(@RequestBody SalesInvoice salesInvoice) {
        this.salesInvoiceService.createSalesInvoice(salesInvoice);
    }

    public java.util.List<SalesInvoice> getSalesInvoices() {
        return this.salesInvoiceService.getAllSalesInvoices();
    }
}
