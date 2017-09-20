package com.jskno.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jskno.persistence.entity.base.AbstractEntity;
import com.jskno.persistence.utils.LocalDateConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by Jose on 9/3/2017.
 */
@MappedSuperclass
public abstract class Invoice extends AbstractEntity implements Serializable {

    @Column(name = "INVOICE_NUMBER", nullable = false)
    private String invoiceNumber;

    @Column(name = "DATE", nullable = false)
    @Convert(converter = LocalDateConverter.class)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "id")
    private Company company;

    @JsonProperty(value = "amount")
    @Column(name = "TAXABLE_BASE", nullable = false)
    private Integer taxableBase;

    @Column(name = "VAT_PERCENTAGE", nullable = false)
    private Integer vatPercentage;

    @Column(name = "VAT_AMOUNT", nullable = false)
    private Integer vatAmount;

    @Column(name = "TOTAL_INVOICE", nullable = false)
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
