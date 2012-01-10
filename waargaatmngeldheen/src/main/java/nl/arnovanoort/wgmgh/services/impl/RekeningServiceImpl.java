package nl.arnovanoort.wgmgh.services.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import nl.arnovanoort.wgmgh.dao.MutatieDao;
import nl.arnovanoort.wgmgh.dao.RekeningDao;
import nl.arnovanoort.wgmgh.domain.BankMutatie;
import nl.arnovanoort.wgmgh.domain.Rekening;
import nl.arnovanoort.wgmgh.log.Logger;
import nl.arnovanoort.wgmgh.services.RekeningService;

@Named("rekeningService")
public class RekeningServiceImpl implements RekeningService{

	@Inject
	MutatieDao mutatieDao;

	@Inject
	RekeningDao rekeningDao;
	
	@Logger
	Log log;

	@PersistenceContext(unitName = "waargaatmngeldheen")
	private EntityManager em;

	@Transactional
	public void add(BankMutatie bankMutatie, Rekening rekening) {
		if(! mutatieDao.exists(bankMutatie, rekening)){
			mutatieDao.persist(bankMutatie);
			rekening = em.merge(rekening);
//			rekening = rekeningDao.merge(rekening);
			log.info("adding mutatie " + bankMutatie + "to rekening: " + rekening );
			log.info("rekening has " + rekening.getBankMutaties().size() + " mutaties" );
			
			rekening.getBankMutaties().add(bankMutatie);
		}
	}

	public List<Rekening> getRekeningen(String username) {
		List<Rekening> rekeningen = rekeningDao.getRekeningen(username);
		return rekeningen;
	}

	public Rekening get(String rekeningId) {
		return rekeningDao.get(rekeningId);
	}

}
