package com.RestAssured.Collection.pojo;

public class ChannelParams {

	public ChannelParams() {
		super();
	}
	public ChannelParams(String name, String value) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.value=value;
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
	
}
