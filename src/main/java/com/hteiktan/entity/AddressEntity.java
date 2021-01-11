package com.hteiktan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="address")
@GenericGenerator(name = "gen", strategy = "increment")
public class AddressEntity {
	@Id
	@Column(name="address_id")
	@GeneratedValue(generator = "gen")
	private int addressId;
	@Column(name="street_name")
	private String streetName;
	private String city;
	private String pincode;
	public AddressEntity() {
		
	}

	
	public AddressEntity(int addressId, String streetName, String city, String pincode) {
		super();
		this.addressId = addressId;
		this.streetName = streetName;
		this.city = city;
		this.pincode = pincode;
	}


	public String getStreetName() {
		return streetName;
	}


	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}


	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}