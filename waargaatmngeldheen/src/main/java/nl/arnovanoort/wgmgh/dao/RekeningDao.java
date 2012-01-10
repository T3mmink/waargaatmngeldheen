package nl.arnovanoort.wgmgh.dao;

import java.util.List;

import nl.arnovanoort.wgmgh.domain.Rekening;

public interface RekeningDao {

	List<Rekening> getRekeningen(String username);

	Rekening get(String rekeningId);

	Rekening merge(Rekening rekening);

}
