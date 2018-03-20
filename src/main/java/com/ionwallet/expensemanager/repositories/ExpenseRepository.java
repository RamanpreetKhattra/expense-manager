package com.ionwallet.expensemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ionwallet.expensemanager.entities.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

	Expense findByExpenseId(Long expenseId);
	
	

}
