package com.aip.ai4c.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Person {

	@Id
	@JsonProperty("uuIdEmailThirdParty")
	private String uuIdEmail;
	private String name;
	private String address;
	private String phoneNumber;
	private String EmailId;
	private String persistentId;

	@OneToMany(mappedBy = "uuIdEmail", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Activity> activity;

	public Person() {

	}
	
	public Person(String uuIdEmail) {
		this.uuIdEmail = uuIdEmail;
	}

	public Person(String uuIdEmail, String name, String address, String phoneNumber, String emailId,
			String persistentId) {
		super();
		this.uuIdEmail = uuIdEmail;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		EmailId = emailId;
		this.persistentId = persistentId;
	}

	

	public String getUuIdEmail() {
		return uuIdEmail;
	}

	public void setUuIdEmail(String uuIdEmail) {
		this.uuIdEmail = uuIdEmail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public String getPersistentId() {
		return persistentId;
	}

	public void setPersistentId(String persistentId) {

		this.persistentId = persistentId;
	}

	public Set<Activity> getRecord() {
		return activity;
	}

	public void setRecord(Set<Activity> record) {
		this.activity = record;
	}

	@Override
	public int hashCode() {
		return Objects.hash(EmailId, address, name, persistentId, phoneNumber, uuIdEmail);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(EmailId, other.EmailId) && Objects.equals(address, other.address)
				&& Objects.equals(name, other.name) && Objects.equals(persistentId, other.persistentId)
				&& Objects.equals(phoneNumber, other.phoneNumber)
				&& Objects.equals(uuIdEmail, other.uuIdEmail);
	}

	@Override
	public String toString() {
		return "Person [uuIdEmailThirdParty=" + uuIdEmail + ", name=" + name + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", EmailId=" + EmailId + ", persistentId=" + persistentId
				+ ", activity=" + activity + "]";
	}

}
