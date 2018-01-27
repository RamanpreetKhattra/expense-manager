package com.ionwallet.expensemanager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EXPENSE")
public class Expense {
	
	@Id
	@Column(name="EXPENSE_ID")
	private Long expenseId;
}
