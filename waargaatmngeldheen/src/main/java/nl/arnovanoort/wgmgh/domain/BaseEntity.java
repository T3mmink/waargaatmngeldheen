package nl.arnovanoort.wgmgh.domain;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public abstract class BaseEntity {

	@GeneratedValue
	@Id
	Integer id;


	Date createdDate;
	Date modifiedDate;
	
	
	// Getters/Setters
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
}
