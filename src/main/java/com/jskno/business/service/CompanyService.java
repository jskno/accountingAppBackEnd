package com.jskno.business.service;

import com.jskno.persistence.entity.Company;
import com.jskno.persistence.repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jose on 9/1/2017.
 */
@Service
public class CompanyService {

    private static final Logger log = LoggerFactory.getLogger(CompanyService.class);

    @Autowired
    CompanyRepository companyRepository;

    public void createCompany(Company company) {
        this.companyRepository.save(company);
    }
}
