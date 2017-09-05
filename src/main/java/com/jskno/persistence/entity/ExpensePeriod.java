package com.jskno.persistence.entity;

import javax.persistence.*;

/**
 * Created by Jose on 9/5/2017.
 */
@Entity
@Table(name = "EXPENSE_PERIOD")
public class ExpensePeriod {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DEFAULT_VALUE")
    private Boolean defaultValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Boolean defaultValue) {
        this.defaultValue = defaultValue;
    }
}
