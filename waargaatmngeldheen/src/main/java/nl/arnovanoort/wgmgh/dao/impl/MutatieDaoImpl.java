package nl.arnovanoort.wgmgh.dao.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import nl.arnovanoort.wgmgh.beans.BankMutatieSummaryForCategory;
import nl.arnovanoort.wgmgh.dao.MutatieDao;
import nl.arnovanoort.wgmgh.domain.BankMutatie;
import nl.arnovanoort.wgmgh.domain.Category;
import nl.arnovanoort.wgmgh.domain.Rekening;

@Named("mutatieDao")
public class MutatieDaoImpl implements MutatieDao {

	@PersistenceContext(unitName = "waargaatmngeldheen")
	private EntityManager em;

	String existsQuery = "From BankMutatie bm " +
			"where bm.transactieDatum=:transactieDatum " +
			"and bm.renteDatum=:renteDatum " +
			"and bm.beginSaldo=:beginSaldo " +
			"and bm.eindSaldo=:eindSaldo " +
			"and bm.rekening=:rekening";
	
	String calculateExpensesForCategory = "" +
			"SELECT new nl.arnovanoort.wgmgh.beans.BankMutatieSummaryForCategory(bankmutatie.category, SUM(bankmutatie.transactieBedrag)) " +
			"FROM BankMutatie bankmutatie " +
			"WHERE transactieDatum > :datumVan " +
			"AND transactieDatum < :datumTot " +
			"and bankmutatie.rekening.rekeningNummer=:rekeningNummer " +
			"GROUP BY bankmutatie.category ";

	
	String mutatiesForPeriodAndCategoryHQL = "" +
			"FROM BankMutatie bankmutatie " +
			"WHERE transactieDatum > :datumVan " +
			"AND transactieDatum < :datumTot " +
			"and bankmutatie.rekening.rekeningNummer=:rekeningNummer ";

	public boolean exists(BankMutatie bankMutatie, Rekening rekening) {
		boolean result = false;
		Query query = em.createQuery(existsQuery, BankMutatie.class);
		query.setParameter("transactieDatum", bankMutatie.getTransactieDatum());
		query.setParameter("renteDatum", bankMutatie.getRenteDatum());
		query.setParameter("beginSaldo", bankMutatie.getBeginSaldo());
		query.setParameter("eindSaldo", bankMutatie.getEindSaldo());
		query.setParameter("rekening", rekening);
		if(! query.getResultList().isEmpty()){
			result = true;
		}
		return result;
	}

	public void persist(BankMutatie bankMutatie) {
		em.persist(bankMutatie);
		
	}

	public List<BankMutatieSummaryForCategory> calculateGemiddelde(Rekening rekening, Date datumVan, Date datumTot) {
		Query query = em.createQuery(calculateExpensesForCategory);
		query.setParameter("datumVan", datumVan);
		query.setParameter("datumTot", datumTot);
		query.setParameter("rekeningNummer", rekening.getRekeningNummer());
		return (List<BankMutatieSummaryForCategory>)query.getResultList();
	}
	
	public List<BankMutatie> getMutatiesForPeriodAndCategory(Rekening rekening, Category category, Date datumVan, Date datumTot){
		Query query = em.createQuery(mutatiesForPeriodAndCategoryHQL);
		query.setParameter("datumVan", datumVan);
		query.setParameter("datumTot", datumTot);
		query.setParameter("rekeningNummer", rekening.getRekeningNummer());
		return (List<BankMutatie>)query.getResultList();
		
	}


}
