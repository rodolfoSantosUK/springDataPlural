package com.rasmoo.cliente.escola.gradecurricular.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "BANK")
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BANK_ID")
	private Long bankId;

	@Column(name = "NAME")
	private String name;

	@Embedded
	@AttributeOverrides({@AttributeOverride(name="addressLine1", column=@Column(name="BANCO_ADDRESS_LINE_1")),
			@AttributeOverride(name="addressLine2", column=@Column(name="BANCO_ADDRESS_LINE_2"))})
	private Address address;

	public String getAddressLine1() { return address.getAddressLine1(); }

	public void setAddressLine1(String addressLine1) {
		this.address.setAddressLine1(addressLine1);
	}

	public String getAddressLine2() {
		return address.getAddressLine2();
	}

	public void setAddressLine2(String addressLine2) {
		this.address.setAddressLine2(addressLine2);
	}

	@Column(name = "IS_INTERNATIONAL")
	private boolean international;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

	@Column(name = "LAST_UPDATED_BY")
	private String lastUpdatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@ElementCollection
	@CollectionTable(name = "BANK_CONTACT", joinColumns = @JoinColumn(name = "BANK_ID"))
	@Column(name = "NAME")
	private Collection<String> contacts = new ArrayList<String>();

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return address.getCity();
	}

	public void setCity(String city) {
		this.address.setCity(city);
	}

	public String getState() {
		return address.getState();
	}

	public void setState(String state) {
		this.address.setState(state);
	}

	public String getZipCode() {
		return address.getZipCode();
	}

	public void setZipCode(String zipCode) {
		this.address.setZipCode(zipCode);
	}

	public boolean isInternational() {
		return international;
	}

	public void setInternational(boolean international) {
		this.international = international;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public Collection<String> getContacts(){
		return this.contacts;
	}

	public void setContacts(Collection<String> contacts){
	   this.contacts = contacts;
        }

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
