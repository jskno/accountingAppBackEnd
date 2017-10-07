package com.jskno.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Jose on 9/5/2017.
 */
@Entity
@Table(name = "EXPENSE_TYPES")
public class ExpenseType implements Serializable {

    @JsonProperty(value = "key")
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @JsonProperty(value = "value")
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
