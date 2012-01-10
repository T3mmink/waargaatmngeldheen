package nl.arnovanoort.wgmgh.services.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import nl.arnovanoort.wgmgh.dao.CategoryDao;
import nl.arnovanoort.wgmgh.dao.result.GetTotalAmountResult;
import nl.arnovanoort.wgmgh.domain.BankMutatie;
import nl.arnovanoort.wgmgh.domain.Category;
import nl.arnovanoort.wgmgh.domain.Rekening;
import nl.arnovanoort.wgmgh.dto.CategoryTotalAmountAndPercentage;
import nl.arnovanoort.wgmgh.services.CategoryService;

@Named("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Inject
	CategoryDao categoryDao;
	
	public List<Category> getCategories(){
		return categoryDao.list();
	}

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public List<CategoryTotalAmountAndPercentage> getCategoriesWithValuesAndPercentage(
			Rekening rekening, Date datumVan, Date datumTot) {
		List<CategoryTotalAmountAndPercentage> result = new ArrayList<CategoryTotalAmountAndPercentage>();

		// get total transactionAmount for this period. Used to calculate percentage
		BigDecimal totalAmountForPeriod = categoryDao.getTotalAmountForPeriod(rekening, datumVan, datumTot);

		if (totalAmountForPeriod.compareTo(new BigDecimal(0))==-1) {
			// get totals per category for this period
			List<GetTotalAmountResult> totalsList = categoryDao.getTotalAmountForPeriodPerCategory(rekening, datumVan,datumTot);
			// calculate percentage and create wrapper
			for (GetTotalAmountResult totalAmountResult : totalsList) {
				CategoryTotalAmountAndPercentage categoryTotal = new CategoryTotalAmountAndPercentage();
				categoryTotal.setCategory(totalAmountResult.getCategory());
				categoryTotal.setTotal(totalAmountResult.getAmount());
				BigDecimal percentage = categoryTotal.getTotal().divide(totalAmountForPeriod, 2, RoundingMode.HALF_DOWN).multiply(new BigDecimal(100)); 
				categoryTotal.setPercentage(percentage);
				result.add(categoryTotal);
			}
		}
		return result;
	}

	public List<Category> getCategories(Rekening rekening, Date startDate, Date endDate) {
		List<Category> mutaties = categoryDao.getCategories(rekening, startDate, endDate);
		return mutaties;
	}	
	
}
