package com.jskno.business.service;

import com.jskno.persistence.entity.PurchaseInvoice;
import com.jskno.persistence.repository.PurchaseInvoiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jose on 9/1/2017.
 */
@Service
public class PurchaseInvoiceService {

    private static final Logger log = LoggerFactory.getLogger(PurchaseInvoiceService.class);

    @Autowired PurchaseInvoiceRepository purchaseInvoiceRepository;

    public void createPurchaseInvoice(PurchaseInvoice purchaseInvoice) {
        this.purchaseInvoiceRepository.save(purchaseInvoice);
    }

    public PurchaseInvoice getPurchaseInvoice(Long id) { return this.purchaseInvoiceRepository.findOne(id); }

    public void updatePurchaseInvoice(PurchaseInvoice purchaseInvoice) { this.purchaseInvoiceRepository.save(purchaseInvoice); }

    public void deletePurchaseInvoice(Long id) { this.purchaseInvoiceRepository.delete(id); }

    public List<PurchaseInvoice> getAllPurchaseInvoices() {
        return this.purchaseInvoiceRepository.findAll();
    }

}
