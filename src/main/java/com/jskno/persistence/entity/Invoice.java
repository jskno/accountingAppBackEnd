package com.jskno.persistence.entity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

/**
 * Created by Jose on 9/3/2017.
 */
public abstract class Invoice extends AbstractEntity {

    @Column(name = "invoice_number", nullable = false)
    private String invoiceNumber;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @Column(name = "taxable_base", nullable = false)
    private Integer taxableBase;

    @Column(name = "vat_percentage", nullable = false)
    private Integer vatPercentage;

    @Column(name = "vat_amount", nullable = false)
    private Integer vatAmount;

    @Column(name = "total_invoice", nullable = false)
    private Integer totalInvoice;

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getTaxableBase() {
        return taxableBase;
    }

    public void setTaxableBase(Integer taxableBase) {
        this.taxableBase = taxableBase;
    }

    public Integer getVatPercentage() {
        return vatPercentage;
    }

    public void setVatPercentage(Integer vatPercentage) {
        this.vatPercentage = vatPercentage;
    }

    public Integer getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(Integer vatAmount) {
        this.vatAmount = vatAmount;
    }

    public Integer getTotalInvoice() {
        return totalInvoice;
    }

    public void setTotalInvoice(Integer totalInvoice) {
        this.totalInvoice = totalInvoice;
    }
}
