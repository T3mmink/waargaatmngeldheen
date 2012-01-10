package nl.arnovanoort.wgmgh.services;

import java.util.Date;
import java.util.List;

import nl.arnovanoort.wgmgh.beans.BankMutatieSummaryForCategory;
import nl.arnovanoort.wgmgh.domain.BankMutatie;
import nl.arnovanoort.wgmgh.domain.Rekening;

public interface BankMutatieService {

	BankMutatie createMutatie(Date transactieDatum, Date renteDatum,
			double beginSaldo, double eindSaldo, double transactieBedrag,
			String omschrijving);

	List<BankMutatieSummaryForCategory> getOverzichtPerCategory(Rekening rekening, Date datumVan,Date datumTot);

}
