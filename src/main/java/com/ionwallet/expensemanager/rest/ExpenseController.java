package com.ionwallet.expensemanager.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ionwallet.expensemanager.dtos.ExpenseDTO;
import com.ionwallet.expensemanager.service.ExpenseService;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@RequestMapping(value="/new",method=RequestMethod.POST)
	public ExpenseDTO addNewExpense(@RequestBody ExpenseDTO expenseDTO){
		expenseDTO.setCreatedTime(LocalDateTime.of(2000, 12, 12, 12, 12, 12));
		expenseDTO.setUpdatedTime(LocalDateTime.of(2000, 12, 12, 12, 12, 12));
		return expenseService.addNewExpense(expenseDTO);
	}

}
