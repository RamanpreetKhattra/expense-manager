package com.ionwallet.expensemanager.mappers;

import org.springframework.stereotype.Component;

import com.ionwallet.expensemanager.dtos.ExpenseDTO;
import com.ionwallet.expensemanager.entities.Expense;
import com.ionwallet.mapper.base.AbstractMapper;

@Component
public class ExpenseMapper extends AbstractMapper<ExpenseDTO, Expense> {

}
