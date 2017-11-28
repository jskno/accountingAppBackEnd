package com.jskno.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jskno.persistence.entity.base.AbstractEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Jose on 9/3/2017.
 */
@Entity
@Table(name = "PURCHASE_INVOICE_CLASS_DATA")
public class PurchaseInvoiceClassifData extends AbstractEntity implements Serializable {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INVOICE_ID", referencedColumnName = "ID")
    @JsonIgnore
    private PurchaseInvoice purchaseInvoice;

    @ManyToOne
    @JoinColumn(name = "EXPENSE_TYPE_ID", referencedColumnName = "ID")
    private ExpenseType expenseType;

    @Column(name = "VAT_APPLICABLE")
    private Boolean vatApplicable;

    @Column(name = "VAT_PERCENTAGE_APPLICABLE")
    private Double vatPercentageApplicable;

    @ManyToOne
    @JoinColumn(name = "EXPENSE_PERIOD_ID", referencedColumnName = "ID")
    private ExpensePeriod expensePeriod;

    @Column(name = "AMORTIZATION_POLICY")
    private String amortizationPolicy;

    @JsonProperty(value = "annualAmortPercentage")
    @Column(name = "ANNUAL_AMORTIZATION_PERCENTAGE")
    private Double annualAmortizationPercentage;

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

    public Double getVatPercentageApplicable() {
        return vatPercentageApplicable;
    }

    public void setVatPercentageApplicable(Double vatPercentageApplicable) {
        this.vatPercentageApplicable = vatPercentageApplicable;
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

    public Double getAnnualAmortizationPercentage() {
        return annualAmortizationPercentage;
    }

    public void setAnnualAmortizationPercentage(Double annualAmortizationPercentage) {
        this.annualAmortizationPercentage = annualAmortizationPercentage;
    }
}
