package nl.arnovanoort.wgmgh.dao.result;

import java.math.BigDecimal;

import nl.arnovanoort.wgmgh.domain.Category;

/**
 * Helper class for easier handling of query result.
 *
 */
public class GetTotalAmountResult{
	BigDecimal amount;
	Category category;
	
	public GetTotalAmountResult(BigDecimal amount, Category category){
		this.amount=amount;
		this.category=category;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}