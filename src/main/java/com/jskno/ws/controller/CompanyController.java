package com.jskno.ws.controller;

import com.jskno.business.service.CompanyService;
import com.jskno.persistence.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Jose on 9/1/2017.
 */
@RestController
@RequestMapping("accounting/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @RequestMapping(path = "/new", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createCompany(@RequestBody Company company) {
        this.companyService.createCompany(company);
    }


}
