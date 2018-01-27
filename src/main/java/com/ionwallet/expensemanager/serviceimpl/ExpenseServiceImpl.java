package com.ionwallet.expensemanager.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ionwallet.expensemanager.entities.Expense;
import com.ionwallet.expensemanager.repositories.ExpenseRepository;
import com.ionwallet.expensemanager.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	ExpenseRepository expenseRepository;

	@Override
	public Expense saveExpense(Expense expense) {
		// TODO Auto-generated method stub
		return null;
	}

}
