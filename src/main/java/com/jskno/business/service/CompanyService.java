package com.jskno.business.service;

import com.jskno.persistence.entity.Company;
import com.jskno.persistence.repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Company getCompany(Long id) { return this.companyRepository.findOne(id); }

    public void updateCompany(Company company) { this.companyRepository.save(company); }

    public void deleteCompany(Long id) { this.companyRepository.delete(id); }

    public Page<Company> getAllCompanies(Integer page, Integer size) {
        Page<Company> pageOfCompanies = companyRepository.findAll(new PageRequest(page, size));
        // example of adding to the /metrics
        if (size > 50) {
            log.info("Large Page Size for getAllPersons");
//            counterService.increment("com.rollingstone.PersonService.getAll.largePayload");
        }
        return pageOfCompanies;
    }

    public List<Company> getAllCompanies() {
        return this.companyRepository.findAll();
    }

}
