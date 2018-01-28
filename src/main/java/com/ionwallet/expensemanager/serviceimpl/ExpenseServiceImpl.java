package com.ionwallet.expensemanager.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ionwallet.expensemanager.dtos.ExpenseDTO;
import com.ionwallet.expensemanager.entities.Expense;
import com.ionwallet.expensemanager.repositories.ExpenseRepository;
import com.ionwallet.expensemanager.service.ExpenseService;

@Service("expenseService")
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	ExpenseRepository expenseRepository;

	@Override
	public ExpenseDTO addNewExpense(ExpenseDTO expenseDTO) {
		// TODO Auto-generated method stub
		Expense expense = new Expense();
		expense.setAmount(expenseDTO.getAmount());
		expense.setCategory(expenseDTO.getCategory());
		expense.setCurrency(expenseDTO.getCurrency());
		expense.setUserId(expenseDTO.getUserId());
		
		expense.setCreatedBy(expenseDTO.getCreatedBy());
		expense.setUpdatedBy(expenseDTO.getUpdatedBy());
		expense.setCreatedTime(expenseDTO.getCreatedTime());
		expense.setUpdatedTime(expenseDTO.getUpdatedTime());
		expense.setVersion(expenseDTO.getVersion());
		
		Expense savedExpense = expenseRepository.save(expense);
		
		ExpenseDTO savedExpenseDTO = new ExpenseDTO();
		savedExpenseDTO.setAmount(savedExpense.getAmount());
		savedExpenseDTO.setCategory(savedExpense.getCategory());
		savedExpenseDTO.setCurrency(savedExpense.getCurrency());
		savedExpenseDTO.setUserId(savedExpense.getUserId());
		
		savedExpenseDTO.setCreatedBy(savedExpense.getCreatedBy());
		savedExpenseDTO.setUpdatedBy(savedExpense.getUpdatedBy());
		savedExpenseDTO.setCreatedTime(savedExpense.getCreatedTime());
		savedExpenseDTO.setUpdatedTime(savedExpense.getUpdatedTime());
		savedExpenseDTO.setVersion(savedExpense.getVersion());
		
		
		return savedExpenseDTO;
	}

}
