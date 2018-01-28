package com.ionwallet.expensemanager.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages={"com.ionwallet"})
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,  HibernateJpaAutoConfiguration.class})
@EnableJpaRepositories("com.ionwallet.expensemanager.repositories")
public class ExpenseManagerApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ExpenseManagerApplication.class, args);
		System.out.println("Welcome to Expense Manager App");
	}
	
}
