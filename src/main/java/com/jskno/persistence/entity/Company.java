package com.jskno.persistence.entity;

import javax.persistence.*;

/**
 * Created by Jose on 9/1/2017.
 */
@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue()
    private Long id;

    @Column(name = "companyname", nullable = false)
    private String companyName;

    @Column(name = "cif", nullable = false)
    private String cif;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "telephone", nullable = false)
    private String telephone;

    @Column(name = "email", nullable = false)
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
