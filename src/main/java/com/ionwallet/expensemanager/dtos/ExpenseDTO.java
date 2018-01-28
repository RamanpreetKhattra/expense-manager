package com.ionwallet.expensemanager.dtos;

import java.io.Serializable;

public class ExpenseDTO extends AbstractDTO implements Serializable{
	
	private Long expenseId;
	
	private Long amount;
	
	private String currency;
	
	private Integer userId;
	
	private String category;
	
	public void setExpenseId(Long expenseId) {
		this.expenseId = expenseId;
	}
	
	public Long getExpenseId() {
		return expenseId;
	}
	
	public Long getAmount() {
		return amount;
	}
	
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
