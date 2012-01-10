package nl.arnovanoort.wgmgh.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import nl.arnovanoort.wgmgh.dao.result.GetTotalAmountResult;
import nl.arnovanoort.wgmgh.domain.Category;
import nl.arnovanoort.wgmgh.domain.Rekening;

public interface CategoryDao {

	List<Category> list();

	List<GetTotalAmountResult> getTotalAmountForPeriodPerCategory(Rekening rekening, Date datumVan, Date datumTot);

	BigDecimal getTotalAmountForPeriod(Rekening rekening, Date datumVan, Date datumTot);

	List<Category> getCategories(Rekening rekening, Date startDate, Date endDate);

	
}
