package nl.arnovanoort.wgmgh.dao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import nl.arnovanoort.wgmgh.dao.CategoryDao;
import nl.arnovanoort.wgmgh.dao.result.GetTotalAmountResult;
import nl.arnovanoort.wgmgh.domain.BankMutatie;
import nl.arnovanoort.wgmgh.domain.Category;
import nl.arnovanoort.wgmgh.domain.Rekening;

@Named("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	@PersistenceContext(unitName = "waargaatmngeldheen")
	private EntityManager em;

	String retrieveListQuery = "" +
			"From Category c";
	
	String totalsForPeriodPerCategory = "" +
			" SELECT new nl.arnovanoort.wgmgh.dao.result.GetTotalAmountResult(SUM(bankMutatie.transactieBedrag), bankMutatie.category)" +
			" FROM BankMutatie bankMutatie" +
			" WHERE bankMutatie.rekening.rekeningNummer=:rekeningNummer" +
			" AND bankMutatie.renteDatum > :datumVan" +
			" AND bankMutatie.renteDatum <= :datumTot" +
			" AND bankMutatie.category is not null" +
			" GROUP BY bankMutatie.category.naam" ;
	
	String totalsForPeriod= "" +
			" SELECT SUM(bankMutatie.transactieBedrag)" +
			" FROM BankMutatie bankMutatie" +
			" WHERE bankMutatie.rekening.rekeningNummer=:rekeningNummer" +
			" AND bankMutatie.renteDatum > :datumVan" +
			" AND bankMutatie.renteDatum <= :datumTot" +
			" AND bankMutatie.category is not null";
	
	String categoriesForPeriodHQL = "" +
			" SELECT bankMutatie.category" +
			" FROM BankMutatie bankMutatie" +
			" WHERE bankMutatie.rekening.rekeningNummer=:rekeningNummer" +
			" AND bankMutatie.renteDatum > :datumVan" +
			" AND bankMutatie.renteDatum <= :datumTot" +
			" AND bankMutatie.category is not null" +
			" GROUP BY bankMutatie.category" ;
	
	public List<Category>list() {
		Query query = em.createQuery(retrieveListQuery, Category.class);
		return query.getResultList();
	}

	public List<GetTotalAmountResult> getTotalAmountForPeriodPerCategory(Rekening rekening, Date datumVan,Date datumTot) {
		Query query = em.createQuery(totalsForPeriodPerCategory, GetTotalAmountResult.class);
		query.setParameter("rekeningNummer" , rekening.getRekeningNummer());
		query.setParameter("datumVan", datumVan);
		query.setParameter("datumTot", datumTot);
		return query.getResultList();
	}

	public BigDecimal getTotalAmountForPeriod(Rekening rekening, Date datumVan, Date datumTot) {
		Query query = em.createQuery(totalsForPeriod, BigDecimal.class);
		query.setParameter("rekeningNummer" , rekening.getRekeningNummer());
		query.setParameter("datumVan", datumVan);
		query.setParameter("datumTot", datumTot);

		BigDecimal result =(BigDecimal)query.getSingleResult();
		return result;
	}

	public List<Category> getCategories(Rekening rekening, Date startDate, Date endDate) {
		Query query = em.createQuery(categoriesForPeriodHQL, Category.class);
		query.setParameter("rekeningNummer" , rekening.getRekeningNummer());
		query.setParameter("datumVan", startDate);
		query.setParameter("datumTot", endDate);
		List result = query.getResultList(); 
		return result;
	}




}
