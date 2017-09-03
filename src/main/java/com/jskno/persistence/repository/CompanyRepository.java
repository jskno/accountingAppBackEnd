package com.jskno.persistence.repository;

import com.jskno.persistence.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jose on 9/1/2017.
 */

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
