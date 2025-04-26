package com.RestAssured.Collection;

public class EmpAddress {

	private String street;
	private String suite;
	private String city;
	private String zipcode;
	
	EmpAddress_GeoCode geo;
	
	public EmpAddress()
	{
		
	}
	public EmpAddress(String street,String suite,String city,String zipcode,EmpAddress_GeoCode geo)
	{
		this.street=street;
		this.suite=suite;
		this.city=city;
		this.zipcode=zipcode;
		this.geo=geo;
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public EmpAddress_GeoCode getGeo() {
		return geo;
	}

	public void setGeo(EmpAddress_GeoCode geo) {
		this.geo = geo;
	}

	
}
