package com.ionwallet.expensemanager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EXPENSE")
public class Expense extends AbstractEntity{
	
	@Id
	@Column(name="EXPENSE_ID")
	@SequenceGenerator(name = "EXPENSE_SEQ", sequenceName = "EXPENSE_SEQ",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXPENSE_SEQ")
	private Long expenseId;
	
	@Column(name="AMOUNT")
	private Long amount;
	
	@Column(name="CURRENCY")
	private String currency;
	
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="CATEGORY")
	private String category;
	
	public void setExpenseId(Long expenseId) {
		this.expenseId = expenseId;
	}
	
	public Long getExpenseId() {
		return expenseId;
	}
}
