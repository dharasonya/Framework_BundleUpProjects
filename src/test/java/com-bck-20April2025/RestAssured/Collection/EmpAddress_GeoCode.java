package com.RestAssured.Collection;

public class EmpAddress_GeoCode {

	private String lat;
	private String lng;
	
	public EmpAddress_GeoCode()
	{
		
	}
	
	public EmpAddress_GeoCode(String lat,String lng)
	{
		this.lat=lat;
		this.lng=lng;
	}
	
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}

}
