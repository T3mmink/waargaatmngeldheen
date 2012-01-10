package nl.arnovanoort.wgmgh.beans;

import java.math.BigDecimal;

import nl.arnovanoort.wgmgh.domain.Category;

public class BankMutatieSummaryForCategory {

	Category category;
	BigDecimal amount;
	
	public BankMutatieSummaryForCategory(Category category, BigDecimal amount){
		this.category = category;
		this.amount = amount;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
}
