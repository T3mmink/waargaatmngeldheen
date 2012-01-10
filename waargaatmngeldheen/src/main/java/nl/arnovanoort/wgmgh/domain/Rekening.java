package nl.arnovanoort.wgmgh.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name="rekening")
public class Rekening extends BaseEntity {

	@GeneratedValue
	@Id
	Integer id;

	Integer rekeningNummer;
	String rekeningHouder;
	
	Bank bank;
	
	@OneToMany(mappedBy="rekening")
	List<BankMutatie> bankMutaties = new ArrayList<BankMutatie>();

	@Override
	public String toString(){
		return  "id: "+ id +
				"\nrekeningNummer: " + rekeningNummer+
				"\nrekeningHouder: " + rekeningHouder;
	}
	// Getters/Setters
	public Integer getRekeningNummer() {
		return rekeningNummer;
	}

	public void setRekeningNummer(Integer rekeningNummer) {
		this.rekeningNummer = rekeningNummer;
	}

	public String getRekeningHouder() {
		return rekeningHouder;
	}

	public void setRekeningHouder(String rekeningHouder) {
		this.rekeningHouder = rekeningHouder;
	}

	public List<BankMutatie> getBankMutaties() {
		return bankMutaties;
	}

	public void setBankMutaties(List<BankMutatie> bankMutaties) {
		this.bankMutaties = bankMutaties;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
}
