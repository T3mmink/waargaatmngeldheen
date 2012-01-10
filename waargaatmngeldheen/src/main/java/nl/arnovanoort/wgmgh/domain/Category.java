package nl.arnovanoort.wgmgh.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category extends BaseEntity{

	@GeneratedValue
	@Id
	Integer id;

	@OneToMany(mappedBy="category", fetch=FetchType.EAGER)
	List<BankMutatie> bankMutaties = new ArrayList<BankMutatie>();

	String naam;
	boolean vasteLasten;
	
	// Getters/Setters
	public String getName() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public boolean isVasteLasten() {
		return vasteLasten;
	}
	public void setVasteLasten(boolean vasteLasten) {
		this.vasteLasten = vasteLasten;
	}
	
	public String toString(){
		return getName();
	}
	public List<BankMutatie> getBankMutaties() {
		return bankMutaties;
	}
	public void setBankMutaties(List<BankMutatie> bankMutaties) {
		this.bankMutaties = bankMutaties;
	}
	
}
