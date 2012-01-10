package nl.arnovanoort.wgmgh.dto;

import java.math.BigDecimal;

import nl.arnovanoort.wgmgh.domain.Category;

public class CategoryTotalAmountAndPercentage {

	Category category;
	BigDecimal total;
	BigDecimal percentage;
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public BigDecimal getPercentage() {
		return percentage;
	}
	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}
	
	
}
