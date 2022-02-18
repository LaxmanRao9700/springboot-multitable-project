package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "employee_tab")
@SecondaryTables({@SecondaryTable(name="perminent_address_tab"), @SecondaryTable(name="mailing_address_tab")})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmloyeeEO {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="current_address")
	private String currentAddress;
	@Column(name="perminent_address",table = "perminent_address_tab")
	private String perminentAddress;
	@Column(name="mailing_address", table="mailing_address_tab")
	private String mailingAddress;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCurrentAddress() {
		return currentAddress;
	}
	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
	public String getPerminentAddress() {
		return perminentAddress;
	}
	public void setPerminentAddress(String perminentAddress) {
		this.perminentAddress = perminentAddress;
	}
	public String getMailingAddress() {
		return mailingAddress;
	}
	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}
	@Override
	public String toString() {
		return "EmloyeeEO [id=" + id + ", name=" + name + ", currentAddress=" + currentAddress + ", perminentAddress="
				+ perminentAddress + ", mailingAddress=" + mailingAddress + "]";
	}
	
	

}
