package com.RestAssured;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Post_PayloadReq_File {

	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	Response res;
	
	@BeforeTest
	public void HitEndPoint_Setup()
	{
		RequestSpecBuilder builder=new RequestSpecBuilder();
		ResponseSpecBuilder respBuilder=new ResponseSpecBuilder();
		
		   // Setup request specification
        requestSpecification = builder
            .setBaseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io")
            .addHeader("x-mock-Response", "200")
            .setContentType(ContentType.JSON)  // Ensure you specify the Content-Type
            .setAccept(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();
				
        // Setup response specification
        responseSpecification = respBuilder
            .expectStatusCode(200)
            .expectContentType(ContentType.JSON)
            .log(LogDetail.ALL) // Log details of the response
            .build();
	}
	
	  @Test
	    public void VerifyStatusCode() {
	    
		 // String payload="{\r\n  \"RequestType\": \"Service\",\r\n  \"MerchantServiceRequestDetails\": {\r\n    \"RequestType\": \"Service\",\r\n    \"MerchantCode\": \"IDF\",\r\n    \"MerchantRefNo\": \"SUBHPAYMENT00020002001\",\r\n    \"UserName\": \"IDF_01\",\r\n    \"UserPass\": \"IDF_01\",\r\n    \"AgentId\": \"IF01IF01519515584138\",\r\n    \"RequesterIP\": \"10.10.10.10\",\r\n    \"EuronetRefNo\": \"100000000829\",\r\n    \"EntransID\": 0,\r\n    \"StoreCode\": \"IDF_01\",\r\n    \"Amount\": \"5000000\",\r\n    \"Txnamount\": 0,\r\n    \"BillerId\": \"SUBH00000NAT5O\",\r\n    \"BillPaymentToken\": \"UFETIF01100000000829718238741651621\",\r\n    \"SplitPay\": \"NO\",\r\n    \"SplitPayAmount\": \"\",\r\n    \"ChannelDetails\": {\r\n      \"ChannelCode\": \"INT\",\r\n      \"ChannelParams\": [\r\n        {\"name\":\"MAC\",\"value\":\"01-23-45-67-89-ab\"},{\"name\":\"INITIATING_CHANNEL\",\"value\":\"INT\"},{\"name\":\"IP\",\"value\":\"10.13.139.44\"}\r\n      ]\r\n    },\r\n    \"CustomerProfile\": [\r\n      {\r\n        \"name\": \"MOBILE\",\r\n        \"value\": \"mb8nXbM70khgqAMspxXOhQ==\"\r\n      },\r\n      {\r\n        \"name\": \"EMAIL\",\r\n        \"value\": \"raU9Zf4EpM8FTWU50ugpnA==\"\r\n      }\r\n    ],\r\n    \"SubscriptionDetails\": [\r\n{\r\n                \"Name\": \"Loan Number\",\r\n                \"Value\": \"111320\"\r\n            }],\r\n    \"PaymentInformation\": {\r\n      \"PaymentMode\": \"Internet Banking\",\r\n      \"PaymentParams\": [\r\n        {\r\n          \"name\": \"IFSC|AccountNo\",\r\n          \"value\": \"eb1K8RREyEzHbnHio0JLP6V68utRr78KCxaFh8CqCVM=\"\r\n        }\r\n      ]\r\n    },\r\n    \"AdditionalInformation\": [],\r\n    \"OFFUSPay\": \"NO\",\r\n    \"IsBillValidated\": \"False\",\r\n    \"MNPCheckCount\": 0,\r\n    \"Hash\": \"6F7F3BFC07FD7E3EBB94064DC54BC45E9A5C526C25FC447730C7456DCB49D08B\"\r\n  }\r\n}\r\n  ";

		  
		  LinkedHashMap<String,Object> mainBodyPayload=new LinkedHashMap<String,Object>();  
		  
		  mainBodyPayload.put("RequestType", "Service");
		  mainBodyPayload.put("MerchantServiceRequestDetails", MerchantServiceRequestDetails());

		
		  // Perform POST request
	        res = 
	        given()
	            .spec(requestSpecification)
	            .body(mainBodyPayload)
	         .when()
	            .post("/openapi/PostBiller_OTOE00005XXZ43");

	        // Assert and log response
	     /*   res.then()
	           .spec(responseSpecification);*/

	        // Optional: Log response status and body for debugging
	        System.out.println("Response Status Code: " + res.getStatusCode());
	        System.out.println("Response Body: " + res.getBody().asString());
	    }
	  
	  public HashMap<String, Object> ChannelDetails()
	  {
		  
		  HashMap<String,Object> ChannelParams1=new HashMap<String,Object>();
		  ChannelParams1.put("name", "MAC");
		  ChannelParams1.put("value", "01-23-45-67-89-ab");
		  
		  HashMap<String,Object> ChannelParams2=new HashMap<String,Object>();
		  ChannelParams2.put("name", "INITIATING_CHANNEL");
		  ChannelParams2.put("value", "INT");

		  
		  HashMap<String,Object> ChannelParams3=new HashMap<String,Object>();
		  ChannelParams3.put("name", "IP");
		  ChannelParams3.put("value", "10.13.139.44");
		  
		  List<HashMap<String,Object>> ChannelParamsArrayList=new ArrayList<HashMap<String,Object>>();
		  ChannelParamsArrayList.add(ChannelParams1);
		  ChannelParamsArrayList.add(ChannelParams2);
		  ChannelParamsArrayList.add(ChannelParams3);
		  
		  
		  HashMap<String,Object> ChannelDetails=new HashMap<String,Object>();  
		  ChannelDetails.put("ChannelCode", "INT");
		  ChannelDetails.put("ChannelParams", ChannelParamsArrayList);
		  
		return ChannelDetails;
		  
	  }
	
	  public List<HashMap<String, Object>> CustomerProfile()
	  {
		  HashMap<String, Object> customerProfile1=new HashMap<String,Object>();
		  customerProfile1.put("name", "MOBILE");
		  customerProfile1.put("value", "mb8nXbM70khgqAMspxXOhQ==");
		  
		  HashMap<String, Object> customerProfile2=new HashMap<String,Object>();
		  customerProfile2.put("name", "EMAIL");
		  customerProfile2.put("value", "raU9Zf4EpM8FTWU50ugpnA==");
		  
		  List<HashMap<String, Object>> CustomerProfile=new ArrayList<HashMap<String, Object>>();
		  
		  CustomerProfile.add(customerProfile1);
		  CustomerProfile.add(customerProfile2);
		  
		  return CustomerProfile;
		  
	  }

	  public List<HashMap<String, Object>> SubscriptionDetails()
	  {
		HashMap<String,Object> SubscriptionDetails1=new HashMap<String,Object>();
		SubscriptionDetails1.put("Name", "Loan Number");
		SubscriptionDetails1.put("Value", "111320");
		
		List<HashMap<String, Object>> SubscriptionArrList=new ArrayList<HashMap<String,Object>>();
		SubscriptionArrList.add(SubscriptionDetails1);
		return SubscriptionArrList;
		  
	  }
	  
	  public HashMap<String,Object> PaymentInformation()
	  {
		 HashMap<String, Object> PaymentParams1=new HashMap<String, Object>();
		  PaymentParams1.put("name","IFSC|AccountNo");
		  PaymentParams1.put("value","eb1K8RREyEzHbnHio0JLP6V68utRr78KCxaFh8CqCVM=");
		  
		  List<HashMap<String,Object>> PaymentParamArrayList=new ArrayList<HashMap<String,Object>>();
		  PaymentParamArrayList.add(PaymentParams1);
		  
		 
		  HashMap<String, Object> PaymentInformation=new HashMap<String,Object>();
		  PaymentInformation.put("PaymentMode","Internet Banking");
		  PaymentInformation.put("PaymentParams",PaymentParamArrayList);
		  return PaymentInformation;
	  }
	  
	  public List<HashMap<String,Object>> AdditionalInformation()
	  {
		
		  List<HashMap<String,Object>> AdditionalInformationArrayList=new ArrayList<HashMap<String,Object>>();
		 // AdditionalInformationArrayList.add(0);
		  
		  return AdditionalInformationArrayList;
	  }

	  public LinkedHashMap<String, Object> MerchantServiceRequestDetails()
	  {
		  LinkedHashMap<String,Object> MerchantServiceRequestDetValues=new LinkedHashMap<String,Object>();
		  MerchantServiceRequestDetValues.put("RequestType","Service");
		  MerchantServiceRequestDetValues.put("MerchantCode","IDF");
		  MerchantServiceRequestDetValues.put("MerchantRefNo", "SUBHPAYMENT00020002001");
		  MerchantServiceRequestDetValues.put("UserName", "IDF_01");
		  MerchantServiceRequestDetValues.put("UserPass", "IDF_01");
		  MerchantServiceRequestDetValues.put("AgentId", "IF01IF01519515584138");
		  MerchantServiceRequestDetValues.put("RequesterIP", "10.10.10.10");
		  MerchantServiceRequestDetValues.put("EuronetRefNo", "100000000829");
		  MerchantServiceRequestDetValues.put("EntransID", 0);
		  MerchantServiceRequestDetValues.put("StoreCode", "IDF_01");
		  MerchantServiceRequestDetValues.put("Amount", "5000000");
		  MerchantServiceRequestDetValues.put("Txnamount", 0);
		  MerchantServiceRequestDetValues.put("BillerId", "SUBH00000NAT5O");
		  MerchantServiceRequestDetValues.put("BillPaymentToken", "UFETIF01100000000829718238741651621");
		  MerchantServiceRequestDetValues.put("SplitPay", "NO");
		  MerchantServiceRequestDetValues.put("SplitPayAmount", "");
		  MerchantServiceRequestDetValues.put("ChannelDetails", ChannelDetails());
		  MerchantServiceRequestDetValues.put("CustomerProfile", CustomerProfile());
		  MerchantServiceRequestDetValues.put("SubscriptionDetails", SubscriptionDetails());
		  MerchantServiceRequestDetValues.put("PaymentInformation", PaymentInformation());
		  MerchantServiceRequestDetValues.put("AdditionalInformation", AdditionalInformation());
		  MerchantServiceRequestDetValues.put("OFFUSPay", "NO");
		  MerchantServiceRequestDetValues.put("IsBillValidated", "False");
		  MerchantServiceRequestDetValues.put("MNPCheckCount", "0");
		  MerchantServiceRequestDetValues.put("Hash", "6F7F3BFC07FD7E3EBB94064DC54BC45E9A5C526C25FC447730C7456DCB49D08B");
		  
		 
		  return MerchantServiceRequestDetValues ;
	  }
	  
}
