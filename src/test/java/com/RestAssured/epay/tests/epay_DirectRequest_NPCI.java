package com.RestAssured.epay.tests;


import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.bidi.network.ResponseData;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RestAssured.Collection.Service.Service_MerchantServReqDet;
import com.RestAssured.Collection.pojo.MerchantServiceRequestDetails;
import com.RestAssured.Collection.response.AdditionalInformation;

import ePay_CRM.Reusable_Utils.TestReader_ExcelData;
import ePay_CRM.Test_DataDriven.TestData_ePayPropertyConfig;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import io.restassured.response.Response;
import com.RestAssured.Collection.response.epay_ResponseData;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class epay_DirectRequest_NPCI {

	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	Response res;

	@BeforeTest(alwaysRun=true)
	public void HitEndPoint_Setup()
	{
		RequestSpecBuilder builder=new RequestSpecBuilder();
		ResponseSpecBuilder respBuilder=new ResponseSpecBuilder();

		// Setup request specification
		requestSpecification = builder
				.setBaseUri("https://epaysit.eftapme.com/")
				// .addHeader("x-mock-Response", "200")
				.setContentType(ContentType.JSON)  // Ensure you specify the Content-Type
				.setAccept(ContentType.JSON)
				.log(LogDetail.ALL)
				.build();

		// Setup response specification
		responseSpecification = respBuilder
				.expectStatusCode(200)
				.expectContentType(ContentType.TEXT)
				.log(LogDetail.ALL) // Log details of the response
				.build();
	}

	//  @Test(dataProvider="JsonTestData")
	@Test(priority=1,dataProvider="ExcelDataProvider",groups= {"SanityTest"} ,dataProviderClass=TestReader_ExcelData.class,enabled=true)
	public void PostCreate_User(String RequestType,String RequesterIP,String MerchantCode,String UserName,String UserPass,String StoreCode,String AgentId,String BillerId,String Amount,String CCF1,String ChannelCode,String ChannelParams_Name1,String ChannelParams_Value1,String ChannelParams_Name2,String ChannelParams_Value2,String ChannelParams_Name3,String ChannelParams_Value3,String ChannelParams_Name4,String ChannelParams_Value4,String ChannelParams_Name5,String ChannelParams_Value5,String SplitPay,String CustomerProfile_Name1,String CustomerProfile_Value1,String CustomerProfile_Name2,String CustomerProfile_Value2,
			String SubscriptionDetails_Name1,String SubscriptionDetails_Value1,String SubscriptionDetails_Name2,String SubscriptionDetails_Value2,
			String SubscriptionDetails_Name3,String SubscriptionDetails_Value3,String SubscriptionDetails_Name4,String SubscriptionDetails_Value4,
			String SubscriptionDetails_Name5,String SubscriptionDetails_Value5,String PaymentMode,String PaymentParams_Name1,String PaymentParams_Value1,
			String AdditionalInformation
			) throws Exception
	//String name, String username,String email,String street,String suite,String city,String zipcode,String lat,String lng) {
	{
		Service_MerchantServReqDet profile_merchantServiceRequestDetails=new Service_MerchantServReqDet();
		LinkedHashMap<String,Object> mainBodyPayload=new LinkedHashMap<String,Object>();

		mainBodyPayload.put("RequestType", RequestType);
		mainBodyPayload.put("MerchantServiceRequestDetails", profile_merchantServiceRequestDetails.getMerchantServiceRequestDetails(RequestType,RequesterIP,
				MerchantCode,UserName,UserPass,StoreCode,AgentId,BillerId,Amount,CCF1,ChannelCode,ChannelParams_Name1,ChannelParams_Value1,ChannelParams_Name2,
				ChannelParams_Value2,ChannelParams_Name3,ChannelParams_Value3,ChannelParams_Name4,ChannelParams_Value4,ChannelParams_Name5,
				ChannelParams_Value5,SplitPay,CustomerProfile_Name1,CustomerProfile_Value1,CustomerProfile_Name2,CustomerProfile_Value2,
				SubscriptionDetails_Name1,SubscriptionDetails_Value1,SubscriptionDetails_Name2,SubscriptionDetails_Value2,
				SubscriptionDetails_Name3,SubscriptionDetails_Value3,SubscriptionDetails_Name4,SubscriptionDetails_Value4,
				SubscriptionDetails_Name5,SubscriptionDetails_Value5,PaymentMode,PaymentParams_Name1,PaymentParams_Value1,
				AdditionalInformation));

		Response response = RestAssured
				.given()
	            .spec(requestSpecification)
	            .body(mainBodyPayload)
	         .when()
	            .post("enserviceAES256DR/API/EnService")
	            .then().contentType("text/plain").spec(responseSpecification).extract().response();
		
		// Get response as a string
		String responseBody = response.getBody().asPrettyString();
		
		// Create an ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);


		 if (response.getStatusCode() == 200) { // Check for successful response
		        try {
		        	 //System.out.println("\n Response Data :-"+response);
		            // Deserialize response to POJO
		        	  epay_ResponseData responseData = objectMapper.readValue(responseBody, epay_ResponseData.class);
		        	    
		            // Access fields
		            System.out.println("EuronetRefNo: " + responseData.getEuronetRefNo());
		            System.out.println("MerchantRefNo: " + responseData.getMerchantRefNo());

		            // Access nested AdditionalInformation
		            for (AdditionalInformation info : responseData.getAdditionalInformation()) {
		                System.out.println("Name: " + info.getName() + ", Value: " + info.getValue());
		            }
		        } catch (Exception e) {
		            System.out.println("Error deserializing response: " + e.getMessage());
		        }
		    } else {
		        // Log error details for non-200 responses
		        System.out.println("Error: Received HTTP " + response.getStatusCode());
		        System.out.println("Response Body: " + response.getBody().asString());
		    }

	}

}  
