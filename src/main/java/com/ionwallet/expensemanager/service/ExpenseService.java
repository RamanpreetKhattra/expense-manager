package com.ionwallet.expensemanager.service;

import org.springframework.stereotype.Service;

import com.ionwallet.expensemanager.entities.Expense;

public interface ExpenseService {
	
	public Expense saveExpense(Expense expense);

}
