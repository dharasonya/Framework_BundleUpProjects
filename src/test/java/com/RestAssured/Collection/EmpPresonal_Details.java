package com.RestAssured.Collection;

public class EmpPresonal_Details {
	
	
	private String name;
	private String username;
	private String email;
	
	EmpAddress address;
	
	public EmpPresonal_Details()
	{
		
	}
	public EmpPresonal_Details(String name,String username,String email,EmpAddress address)
	{
		this.name=name;
		this.username=username;
		this.email=email;
		this.address=address;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EmpAddress getAddress() {
		return address;
	}

	public void setAddress(EmpAddress address) {
		this.address = address;
	}

	
	
}
