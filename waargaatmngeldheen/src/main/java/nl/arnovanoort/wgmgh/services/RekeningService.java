package nl.arnovanoort.wgmgh.services;

import java.util.List;

import nl.arnovanoort.wgmgh.domain.BankMutatie;
import nl.arnovanoort.wgmgh.domain.Rekening;

public interface RekeningService {

	void add(BankMutatie bankMutatie, Rekening rekening);

	List<Rekening> getRekeningen(String username);

	Rekening get(String rekeningId);

	
}
