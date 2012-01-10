package nl.arnovanoort.wgmgh.readers.impl;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import nl.arnovanoort.wgmgh.domain.BankMutatie;

@Named("triodosReader")
public class TriodosReader {
	
	@PersistenceContext(unitName="waargaatmngeldheen")
	private EntityManager em;

	public TriodosReader() {
	}
	
	public String toString(){
		
		BankMutatie mutatie = new BankMutatie();
		mutatie.setId(6);
		em.persist(mutatie);
		Query query = em.createQuery("from nl.arnovanoort.wgmgh.domain.BankMutatie");
		List result = query.getResultList();
		return "reading triodos...";

	}

}
