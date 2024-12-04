package com.RestAssured.Collection.ResponseAction;

import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import static org.junit.Assert.assertThat;
import org.hamcrest.CoreMatchers;

import com.RestAssured.Collection.response.AdditionalInformation;
import com.RestAssured.Collection.response.epay_ResponseData;


public class epay_Validate_AdditionalInfoArray{

	epay_ResponseData responseData;
	AdditionalInformation info=new AdditionalInformation();
	  
	public epay_Validate_AdditionalInfoArray(epay_ResponseData responseData) {
		// TODO Auto-generated constructor stub
		this.responseData=responseData;
	}
	
	public void Validate_AdditionalInfoSize()
	{
		assertThat("EuronetRefNo is not a string!", responseData.getEuronetRefNo(), CoreMatchers.instanceOf(String.class));
	      
	}
	  
	public void Validate_AdditionalInfoStructure()
	{
		assertThat("Additional Information Size Check", responseData.getAdditionalInformation(), hasSize(9));
		//		validateAddArray.Validate_AdditionalInformationArray();
		
		List<AdditionalInformation> additionalInformation = responseData.getAdditionalInformation();

	    // Extract the names from AdditionalInformation objects
		  List<String> names = additionalInformation.stream()
	                .map(AdditionalInformation::getName)
	                .collect(Collectors.toList());

	    // Assert that the names are in the correct order (ignoring exact sequence but ensuring all are present)
	    assertThat("AdditionalInformation is not as expected", names, containsInAnyOrder(
	            "a", 
	            "a b", 
	            "a b c", 
	            "a b c d", 
	            "a b c d e", 
	            "BillNumber", 
	            "BillPeriod", 
	            "DueDate", 
	            "BillDate"
	    ));
	}

	       
}
	
	
	
	

