package com.hteiktan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.hteiktan.dto.AddressDTO;

@Entity
@Table(name="address")
@GenericGenerator(name = "gen", strategy = "increment")
public class AddressEntity {
	@Id
	@Column
	@GeneratedValue(generator = "gen")
	private int addressId;
	@Column
	private String streetName;
	@Column
	private String city;
	@Column
	private String pincode;
	
	public AddressEntity() {
	}
	
	
	public AddressEntity(String streetName, String city, String pincode) {
		super();
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
	
	public static AddressDTO prepareAddressDTO(AddressEntity addressEntity) {
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setAddressId(addressEntity.getAddressId());
		addressDTO.setCity(addressEntity.getCity());
		addressDTO.setPincode(addressEntity.getPincode());
		addressDTO.setStreetName(addressEntity.getStreetName());
		return addressDTO;
	}
}