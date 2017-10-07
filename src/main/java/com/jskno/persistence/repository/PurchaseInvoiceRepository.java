package com.jskno.persistence.repository;

import com.jskno.persistence.entity.PurchaseInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Jose on 9/1/2017.
 */
@Repository
public interface PurchaseInvoiceRepository extends JpaRepository<PurchaseInvoice, Long> {

    @Query("SELECT d FROM PurchaseInvoice d WHERE d.invoiceNumber = :invoiceNumber") List<PurchaseInvoice> getPurchaseInvoiceByInvoiceNumber(
            @Param("invoiceNumber") String invoiceNumber);

    @Query("SELECT d FROM PurchaseInvoice d WHERE d.date BETWEEN :startdate AND :enddate")
    List<PurchaseInvoice> getPurchaseInvoicesByDates(
            @Param("startdate")Date startdate,
            @Param("enddate") Date enddate);

    @Query(value = "SELECT FIRST 100 * FROM PURCHASE_INVOICES d WHERE d.DATE BETWEEN ?1 AND ?2",
            nativeQuery = true)
    List<PurchaseInvoice> get100PurchaseInvoicesByDates(
            @Param("startdate")Date startdate,
            @Param("enddate") Date enddate);
}
