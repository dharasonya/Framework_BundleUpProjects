package com.RestAssured.Collection.Service;

import java.util.ArrayList;
import java.util.List;

import com.RestAssured.Collection.pojo.ChannelDetails;
import com.RestAssured.Collection.pojo.customerProfile;

public class Service_CustomerProfile {

	public List<customerProfile> getCustomerProfile()
	{
		List<customerProfile> customerProfileList=new ArrayList<>();
		customerProfileList.add(new customerProfile("MOBILE","N6aeAZ76ZIgz36Tl5jIh9Q=="));
		customerProfileList.add(new customerProfile("EMAIL","2GqSrdtRgkF7UxaQPOfV71cZmwLCKz7tYMu5ZmvO1Y0="));
		
		
		return customerProfileList;
		
		
	}
}
