package nl.arnovanoort.wgmgh.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	
	String naam;
	
	@OneToMany
	List<Rekening> rekeningen = new ArrayList<Rekening>();
	
	
	// Getters/Setters
	
	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public List<Rekening> getRekeningen() {
		return rekeningen;
	}

	public void setRekeningen(List<Rekening> rekeningen) {
		this.rekeningen = rekeningen;
	}}
