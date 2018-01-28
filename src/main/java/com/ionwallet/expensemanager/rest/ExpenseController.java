package com.ionwallet.expensemanager.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value="/new",method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ExpenseDTO addNewExpense(@RequestBody ExpenseDTO expenseDTO){
		/*expenseDTO.setCreatedTime(LocalDateTime.of(2000, 12, 12, 12, 12, 12));
		expenseDTO.setUpdatedTime(LocalDateTime.of(2000, 12, 12, 12, 12, 12));*/
		return expenseService.saveExpense(expenseDTO);
	}
	
	@RequestMapping(value="/get/{expenseId}",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ExpenseDTO addNewExpense(@PathVariable("expenseId") Long expenseId){
		return expenseService.getExpense(expenseId);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ExpenseDTO saveExpense(@RequestBody ExpenseDTO expenseDTO){
		return expenseService.saveExpense(expenseDTO);
	}

}
