package nl.arnovanoort.wgmgh.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
@Table(name="bankmutatie")
public class BankMutatie extends BaseEntity{

	@GeneratedValue
	@Id
	Integer id;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	private Date transactieDatum;
	private Date renteDatum;
	private BigDecimal beginSaldo;
	private BigDecimal eindSaldo;
	private BigDecimal transactieBedrag;
	private String omschrijving;
	
	@ManyToOne
	Category category;
	
	@ManyToOne
	Rekening rekening;
	
	
	public Date getTransactieDatum() {
		return transactieDatum;
	}
	public void setTransactieDatum(Date transactieDatum) {
		this.transactieDatum = transactieDatum;
	}
	public Date getRenteDatum() {
		return renteDatum;
	}
	public void setRenteDatum(Date renteDatum) {
		this.renteDatum = renteDatum;
	}
	public BigDecimal getBeginSaldo() {
		return beginSaldo;
	}
	public void setBeginSaldo(BigDecimal beginSaldo) {
		this.beginSaldo = beginSaldo;
	}
	public BigDecimal getEindSaldo() {
		return eindSaldo;
	}
	public void setEindSaldo(BigDecimal eindSaldo) {
		this.eindSaldo = eindSaldo;
	}
	public BigDecimal getTransactieBedrag() {
		return transactieBedrag;
	}
	public void setTransactieBedrag(BigDecimal transactieBedrag) {
		this.transactieBedrag = transactieBedrag;
	}
	public String getOmschrijving() {
		return omschrijving;
	}
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
	
	public Rekening getRekening() {
		return rekening;
	}
	public void setRekening(Rekening rekening) {
		this.rekening = rekening;
	}


	@Override
	public String toString(){
		return  "TransactieDatum: " + transactieDatum +
				"\nrentedatum: " + renteDatum +
				"\nbeginSaldo: " + beginSaldo +
				"\neindSaldo: " + eindSaldo +
				"\ntransactieBedrag: " + transactieBedrag +
				"\nomschrijving: " + omschrijving;
	}

	/*
	boolean equals(BankMutatie bankmutatie){
	 
		boolean result=false;
		if(
				this.beginSaldo.equals(bankmutatie.getBeginSaldo()) &&
				this.eindSaldo.equals(bankmutatie.getEindSaldo()) &&
				this.transactieDatum.equals(bankmutatie.getTransactieDatum()) &&
				this.renteDatum.equals(bankmutatie.getRenteDatum())){
					result=true;
				}
		return result;
	}
	
	public int hashCode(){
		return new HashCodeBuilder(17,31).append(beginSaldo)
				.append(eindSaldo)
				.append(transactieDatum)
				.append(renteDatum)
				.toHashCode();arg0
	}
	*/
	
}
