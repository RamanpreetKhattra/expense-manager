package com.ionwallet.expensemanager.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ionwallet.expensemanager")
@EntityScan("com.ionwallet.expensemanager.entities")
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,  HibernateJpaAutoConfiguration.class})
public class ExpenseManagerApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ExpenseManagerApplication.class, args);
		System.out.println("Welcome to Expense Manager App");
	}
	
}
