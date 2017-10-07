package com.jskno;

import com.jskno.persistence.entity.Company;
import com.jskno.persistence.entity.PurchaseInvoice;
import com.jskno.persistence.entity.PurchaseInvoiceClassifData;
import com.jskno.persistence.repository.CompanyRepository;
//import com.jskno.persistence.repository.PurchaseInvoiceClassifDataRepository;
import com.jskno.persistence.repository.PurchaseInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.time.LocalDate;

@SpringBootApplication
public class AccountingAppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountingAppBackendApplication.class, args);
	}

}
