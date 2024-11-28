package com.RestAssured.Collection.Service;

import java.util.ArrayList;
import java.util.List;

import com.RestAssured.Collection.pojo.SubscriptionDetails;

public class Service_SubscriptionDetails {

	public List<SubscriptionDetails> getSubscriptionDetails(String subscriptionDetails_Name1, String subscriptionDetails_Value1, String subscriptionDetails_Name2, 
			String subscriptionDetails_Value2, String subscriptionDetails_Name3, String subscriptionDetails_Value3, String subscriptionDetails_Name4, 
			String subscriptionDetails_Value4, String subscriptionDetails_Name5, String subscriptionDetails_Value5)
	{
		List<SubscriptionDetails> SubscriptionDetailsList=new ArrayList<>();
		SubscriptionDetailsList.add(new SubscriptionDetails(subscriptionDetails_Name1,subscriptionDetails_Value1));
		SubscriptionDetailsList.add(new SubscriptionDetails(subscriptionDetails_Name2,subscriptionDetails_Value2));
		SubscriptionDetailsList.add(new SubscriptionDetails(subscriptionDetails_Name3,subscriptionDetails_Value3));
		SubscriptionDetailsList.add(new SubscriptionDetails(subscriptionDetails_Name4,subscriptionDetails_Value4));
		SubscriptionDetailsList.add(new SubscriptionDetails(subscriptionDetails_Name5,subscriptionDetails_Value5));
	
		return SubscriptionDetailsList;
		
	}
}
