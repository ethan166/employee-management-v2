package com.hteiktan.dto;

import com.hteiktan.entity.AddressEntity;

public class AddressDTO {
	private int addressId;
	private String streetName;
	
	private String city;
	private String pincode;
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public AddressDTO() {
		
	}
	public AddressDTO(String streetName, String city, String pincode) {
		super();
		this.streetName = streetName;
		this.city = city;
		this.pincode = pincode;
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
	
	public static AddressEntity prepareAddressEntity(AddressDTO addressDTO) {
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setCity(addressDTO.getCity());
		addressEntity.setStreetName(addressDTO.getStreetName());
		addressEntity.setPincode(addressDTO.getPincode());
		return addressEntity;
	}

}