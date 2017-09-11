package com.jskno.business.service;

import com.jskno.persistence.entity.PurchaseInvoice;
import com.jskno.persistence.entity.SalesInvoice;
import com.jskno.persistence.repository.SalesInvoiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jose on 9/1/2017.
 */
@Service
public class SalesInvoiceService {

    private static final Logger log = LoggerFactory.getLogger(SalesInvoiceService.class);

    @Autowired SalesInvoiceRepository salesInvoiceRepository;

    public void createSalesInvoice(SalesInvoice salesInvoice) {
        this.salesInvoiceRepository.save(salesInvoice);
    }

    public SalesInvoice getSalesInvoice(Long id) { return this.salesInvoiceRepository.findOne(id); }

    public void updateSalesInvoice(SalesInvoice salesInvoice) { this.salesInvoiceRepository.save(salesInvoice); }

    public void deleteSalesInvoicee(Long id) { this.salesInvoiceRepository.delete(id); }
}
