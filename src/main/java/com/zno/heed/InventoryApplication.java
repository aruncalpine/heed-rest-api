package com.zno.heed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableCaching
@EnableAutoConfiguration(exclude={ValidationAutoConfiguration.class})
@PropertySource("classpath:application.properties")
@PropertySource("classpath:config.properties")
public class InventoryApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
		System.out.println("---------------------------------------------------------------------------- ZNO - HEED - Started -----------------------------------------------------------------------------------------------");
	}
}
