package com.ionwallet.expensemanager.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ionwallet.expensemanager.dtos.ExpenseDTO;
import com.ionwallet.expensemanager.entities.Expense;
import com.ionwallet.expensemanager.mappers.ExpenseMapper;
import com.ionwallet.expensemanager.repositories.ExpenseRepository;
import com.ionwallet.expensemanager.service.ExpenseService;

@Service("expenseService")
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	ExpenseRepository expenseRepository;
	
	@Autowired
	ExpenseMapper expenseMapper;

	@Override
	public ExpenseDTO saveExpense(ExpenseDTO expenseDTO) {
		Expense savedExpense = expenseRepository.save(expenseMapper.convertToEntity(expenseDTO));
		ExpenseDTO savedExpenseDTO = expenseMapper.covertToDto(savedExpense);
		return savedExpenseDTO;
	}
	
	@Override
	public ExpenseDTO getExpense(Long expenseId) {
		Expense expense = expenseRepository.findByExpenseId(expenseId);
		ExpenseDTO savedExpenseDTO = expenseMapper.covertToDto(expense);
		return savedExpenseDTO;
	}

}
