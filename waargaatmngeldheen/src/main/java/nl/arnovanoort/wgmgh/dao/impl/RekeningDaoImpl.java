package nl.arnovanoort.wgmgh.dao.impl;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import nl.arnovanoort.wgmgh.dao.RekeningDao;
import nl.arnovanoort.wgmgh.domain.Rekening;

@Named("rekeningDao")
public class RekeningDaoImpl implements RekeningDao {

	private static final String getRekeningenHQL = "from Rekening";

	@PersistenceContext(unitName = "waargaatmngeldheen")
	private EntityManager em;

	//Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Rekening merge(Rekening rekening) {
		return em.merge(rekening);
	}

	public List<Rekening> getRekeningen(String username) {
		Query query = em.createQuery(getRekeningenHQL);
		List<Rekening> rekeningen = query.getResultList();
		return rekeningen;
	}

	public Rekening get(String rekeningId) {
		return em.find(Rekening.class, rekeningId);
	}

}
