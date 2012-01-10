package nl.arnovanoort.wgmgh.services.impl;

import java.math.BigDecimal;


import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import nl.arnovanoort.wgmgh.beans.BankMutatieSummaryForCategory;
import nl.arnovanoort.wgmgh.dao.MutatieDao;
import nl.arnovanoort.wgmgh.domain.BankMutatie;
import nl.arnovanoort.wgmgh.domain.Rekening;
import nl.arnovanoort.wgmgh.services.BankMutatieService;

import org.springframework.stereotype.Component;

@Named("bankMutatieService")
public class BankMutatieServiceImpl implements BankMutatieService{

	@Inject
	MutatieDao mutatieDao;
	
	public BankMutatie createMutatie(Date transactieDatum, Date renteDatum,	double beginSaldo, double eindSaldo, double transactieBedrag, String omschrijving) {
		BigDecimal beginSaldoBD = new BigDecimal(beginSaldo).setScale(2,BigDecimal.ROUND_HALF_DOWN);
		BigDecimal eindSaldoBD = new BigDecimal(eindSaldo).setScale(2,BigDecimal.ROUND_HALF_DOWN);
		BigDecimal transactieBedragBD = new BigDecimal(transactieBedrag).setScale(2,BigDecimal.ROUND_HALF_DOWN);
		
		return createMutatie(transactieDatum, renteDatum,	beginSaldoBD, eindSaldoBD,transactieBedragBD, omschrijving);
	}

	private BankMutatie createMutatie(Date transactieDatum, Date renteDatum, BigDecimal beginSaldo, BigDecimal eindSaldo, BigDecimal transactieBedrag, String omschrijving) {
		BankMutatie bankMutatie = new BankMutatie();
		bankMutatie.setBeginSaldo(beginSaldo);
		bankMutatie.setEindSaldo(eindSaldo);
		bankMutatie.setOmschrijving(omschrijving);
		bankMutatie.setRenteDatum(renteDatum);
		bankMutatie.setTransactieBedrag(transactieBedrag);
		bankMutatie.setTransactieDatum(transactieDatum);
		return bankMutatie;
	}


	public List<BankMutatieSummaryForCategory> getOverzichtPerCategory(Rekening rekening, 
			Date datumVan, Date datumTot) {
		return mutatieDao.calculateGemiddelde(rekening, datumVan, datumTot); 
	}
}
