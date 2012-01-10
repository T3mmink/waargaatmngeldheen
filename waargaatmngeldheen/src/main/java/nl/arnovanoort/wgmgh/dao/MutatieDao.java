package nl.arnovanoort.wgmgh.dao;

import java.util.Date;
import java.util.List;

import nl.arnovanoort.wgmgh.beans.BankMutatieSummaryForCategory;
import nl.arnovanoort.wgmgh.domain.BankMutatie;
import nl.arnovanoort.wgmgh.domain.Category;
import nl.arnovanoort.wgmgh.domain.Rekening;

public interface MutatieDao {

	boolean exists(BankMutatie bankMutatie, Rekening rekening);

	void persist(BankMutatie bankMutatie);

	public List<BankMutatieSummaryForCategory> calculateGemiddelde(Rekening rekening, Date datumVan,Date datumTot);
	
	public List<BankMutatie> getMutatiesForPeriodAndCategory(Rekening rekening, Category category, Date datumVan, Date datumTot);

}
