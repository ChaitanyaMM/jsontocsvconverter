package com.example.demo.entity;

public class Emerland {

	private long addressEffectiveEndDt;
	private long addressEffectiveStartDt;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String addressTypeCode;
	private String city;
	private String countryTypeCode;
	private String countyTypeCode;
	private String postalCode;
	private String stateTypeCode;

	public long getAddressEffectiveEndDt() {
		return addressEffectiveEndDt;
	}

	public void setAddressEffectiveEndDt(long addressEffectiveEndDt) {
		this.addressEffectiveEndDt = addressEffectiveEndDt;
	}

	public long getAddressEffectiveStartDt() {
		return addressEffectiveStartDt;
	}

	public void setAddressEffectiveStartDt(long addressEffectiveStartDt) {
		this.addressEffectiveStartDt = addressEffectiveStartDt;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getAddressTypeCode() {
		return addressTypeCode;
	}

	public void setAddressTypeCode(String addressTypeCode) {
		this.addressTypeCode = addressTypeCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountryTypeCode() {
		return countryTypeCode;
	}

	public void setCountryTypeCode(String countryTypeCode) {
		this.countryTypeCode = countryTypeCode;
	}

	public String getCountyTypeCode() {
		return countyTypeCode;
	}

	public void setCountyTypeCode(String countyTypeCode) {
		this.countyTypeCode = countyTypeCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStateTypeCode() {
		return stateTypeCode;
	}

	public void setStateTypeCode(String stateTypeCode) {
		this.stateTypeCode = stateTypeCode;
	}

	@Override
	public String toString() {
		return "Emerland [addressEffectiveEndDt=" + addressEffectiveEndDt + ", addressEffectiveStartDt="
				+ addressEffectiveStartDt + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", addressLine3=" + addressLine3 + ", addressTypeCode=" + addressTypeCode + ", city=" + city
				+ ", countryTypeCode=" + countryTypeCode + ", countyTypeCode=" + countyTypeCode + ", postalCode="
				+ postalCode + ", stateTypeCode=" + stateTypeCode + "]";
	}

}
