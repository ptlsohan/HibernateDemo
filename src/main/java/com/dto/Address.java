package com.dto;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	public Address() {
		// TODO Auto-generated constructor stub
	}
	private String city;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + "]";
	}

}
