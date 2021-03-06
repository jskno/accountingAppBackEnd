package com.jskno.ws.controller;

import com.jskno.business.service.CompanyService;
import com.jskno.persistence.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jose on 9/1/2017.
 */
@RestController
@RequestMapping("accounting/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @RequestMapping(path = "/new", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, //MediaType.APPLICATION_XML_VALUE
    })
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createCompany(@RequestBody Company company) {
        this.companyService.createCompany(company);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, //MediaType.APPLICATION_XML_VALUE
            })
    public List<Company> getCompanies() {
        return this.companyService.getAllCompanies();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Company getCompanyById(@PathVariable("id") Long id) {
        return this.companyService.getCompany(id);
    }


}
