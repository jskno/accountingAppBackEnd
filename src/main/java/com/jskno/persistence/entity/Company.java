package com.jskno.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Jose on 9/1/2017.
 */
@Entity
@Table(name = "COMPANIES")
public class Company extends AbstractEntity implements Serializable {
    @Id
    @GeneratedValue()
    private Long id;

    @Column(name = "COMPANY_NAME", nullable = false)
    private String companyName;

    @Column(name = "CIF", nullable = false)
    private String cif;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "TELEPHONE", nullable = false)
    private String telephone;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
