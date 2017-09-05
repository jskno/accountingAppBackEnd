package com.jskno.persistence.entity;

import javax.persistence.*;

/**
 * Created by Jose on 9/3/2017.
 */
@Entity
@Table(name = "PURCHASE_INVOICE_CLASS_DATA")
public class PurchaseInvoiceClassifData {

    @Column(name = "INVOICE_ID", nullable = false, unique = true)
    private Long invoiceId;

    @ManyToOne
    @JoinColumn(name = "EXPENSE_TYPE_ID", referencedColumnName = "ID")
    private ExpenseType expenseType;

    @Column(name = "VAT_APPLICABLE")
    private Boolean vatApplicable;

    @Column(name = "APPLICABLE_TAX_PERCENTAGE")
    private Double applicableTaxPercentage;

    @ManyToOne
    @JoinColumn(name = "EXPENSE_PERIOD_ID", referencedColumnName = "ID")
    private ExpensePeriod expensePeriod;

    @Column(name = "AMORTIZATION_POLICY")
    private String amortizationPolicy;

    @Column(name = "AMORTIZATION_ANNUAL_PERCENTAGE")
    private Double amortizationAnnualPercentage;

    private PurchaseInvoice purchaseInvoice;

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public PurchaseInvoice getPurchaseInvoice() {
        return purchaseInvoice;
    }

    public void setPurchaseInvoice(PurchaseInvoice purchaseInvoice) {
        this.purchaseInvoice = purchaseInvoice;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public Boolean getVatApplicable() {
        return vatApplicable;
    }

    public void setVatApplicable(Boolean vatApplicable) {
        this.vatApplicable = vatApplicable;
    }

    public Double getApplicableTaxPercentage() {
        return applicableTaxPercentage;
    }

    public void setApplicableTaxPercentage(Double applicableTaxPercentage) {
        this.applicableTaxPercentage = applicableTaxPercentage;
    }

    public ExpensePeriod getExpensePeriod() {
        return expensePeriod;
    }

    public void setExpensePeriod(ExpensePeriod expensePeriod) {
        this.expensePeriod = expensePeriod;
    }

    public String getAmortizationPolicy() {
        return amortizationPolicy;
    }

    public void setAmortizationPolicy(String amortizationPolicy) {
        this.amortizationPolicy = amortizationPolicy;
    }

    public Double getAmortizationAnnualPercentage() {
        return amortizationAnnualPercentage;
    }

    public void setAmortizationAnnualPercentage(Double amortizationAnnualPercentage) {
        this.amortizationAnnualPercentage = amortizationAnnualPercentage;
    }
}