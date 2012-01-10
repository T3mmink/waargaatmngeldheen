package nl.arnovanoort.wgmgh.services;

import java.util.Date;
import java.util.List;

import nl.arnovanoort.wgmgh.domain.BankMutatie;
import nl.arnovanoort.wgmgh.domain.Category;
import nl.arnovanoort.wgmgh.domain.Rekening;
import nl.arnovanoort.wgmgh.dto.CategoryTotalAmountAndPercentage;

public interface CategoryService {

	public List<Category> getCategories();

	public List<CategoryTotalAmountAndPercentage>  getCategoriesWithValuesAndPercentage(Rekening rekening,	Date datumVan, Date datumTot);

	public List<Category> getCategories(Rekening rekening, Date startDate, Date endDate);

}
