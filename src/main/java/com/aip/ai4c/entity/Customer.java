package com.aip.ai4c.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	private String name;
	private String contact;
	
	public Customer() {
	}

	public Customer(String name, String contact) {
		super();
		this.name = name;
		this.contact = contact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contact, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(contact, other.contact) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", contact=" + contact + "]";
	}
	
	
}
