package com.ionwallet.expensemanager.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.ionwallet.expensemanager.entities.Expense;
import com.ionwallet.expensemanager.service.ExpenseService;

@SpringBootApplication
@ComponentScan(basePackages={"com.ionwallet"})
@EntityScan("com.ionwallet.expensemanager.entities")
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,  HibernateJpaAutoConfiguration.class})
public class ExpenseManagerApplication {

	@Autowired
	ExpenseService expenseService;
	
	public static void main(String[] args) {
		SpringApplication.run(ExpenseManagerApplication.class, args);
		System.out.println("Welcome to Expense Manager App");
		
		Expense expense = new Expense();
		
	}
	
}
