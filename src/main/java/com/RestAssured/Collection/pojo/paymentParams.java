package com.RestAssured.Collection.pojo;

public class paymentParams {

	public paymentParams() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	private String name;
	private String value;
	
	public paymentParams(String name,String value)
	{
		this.name=name;
		this.value=value;
	}
}
