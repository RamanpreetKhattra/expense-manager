package com.ionwallet.expensemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ionwallet.expensemanager.entities.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	
	

}
