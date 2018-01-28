package com.ionwallet.expensemanager.service;

import com.ionwallet.expensemanager.dtos.ExpenseDTO;

public interface ExpenseService {
	
	public ExpenseDTO saveExpense(ExpenseDTO expenseDTO);
	
	public ExpenseDTO getExpense(Long expenseId);
	
}
