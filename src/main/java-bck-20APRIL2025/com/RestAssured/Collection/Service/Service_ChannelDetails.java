package com.RestAssured.Collection.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.RestAssured.Collection.pojo.ChannelDetails;
import com.RestAssured.Collection.pojo.ChannelParams;

public class Service_ChannelDetails {

	public ChannelDetails getChannelDetails(String channelCode, String channelParams_Name1, String channelParams_Value1, String channelParams_Name2, 
			String channelParams_Value2, String channelParams_Name3,String channelParams_Value3, String channelParams_Name4, String channelParams_Value4, 
			String channelParams_Name5, String channelParams_Value5)
	{
		
	    // Prepare ChannelParams
	    List<ChannelParams> channelParamsList = new ArrayList<>();
	    channelParamsList.add(new ChannelParams(channelParams_Name1, channelParams_Value1));
	    channelParamsList.add(new ChannelParams(channelParams_Name2, channelParams_Value2));
	    channelParamsList.add(new ChannelParams(channelParams_Name3, channelParams_Value3));
	    channelParamsList.add(new ChannelParams(channelParams_Name4, channelParams_Value4));
	    channelParamsList.add(new ChannelParams(channelParams_Name5, channelParams_Value5));

	    // Create ChannelDetails object
	    ChannelDetails objChannelDet = new ChannelDetails();
	    
	    // Set values in ChannelDetails
	    objChannelDet.setChannelCode(channelCode);
	    objChannelDet.setChannelParams(channelParamsList);


	    // Return the list
	    return objChannelDet;
		
	}
}
