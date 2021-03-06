package com.jskno.persistence.repository;

import com.jskno.persistence.entity.SalesInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Jose on 9/1/2017.
 */
@Repository
public interface SalesInvoiceRepository extends JpaRepository<SalesInvoice, Long> {
}
