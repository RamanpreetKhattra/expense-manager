package com.ionwallet.expensemanager.service;

import com.ionwallet.expensemanager.dtos.ExpenseDTO;

public interface ExpenseService {
	
	public ExpenseDTO addNewExpense(ExpenseDTO expenseDTO);
	
}
