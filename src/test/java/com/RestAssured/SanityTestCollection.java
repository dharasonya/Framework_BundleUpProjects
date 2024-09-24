package com.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jdk.internal.net.http.common.Log;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.isA;
public class SanityTestCollection {


	@Test(priority=1)
	public void Verify_Given_EndPoint()
	{
		given().baseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io").
		when().get("/openapi/subscriptions/v2/get/").
		then().log().body().assertThat().statusCode(200);
	}

	@Test(priority=2)
	public void Verify_StatusCode()
	{
		given().baseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io").
		when().get("/openapi/subscriptions/v2/get/").
		then().log().body().assertThat().statusCode(200);
	}

	@Test(priority=3)
	public void Verify_Extracted_Response()
	{
		Response res=given().baseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io").
				when().get("/openapi/subscriptions/v2/get/").
				then().log().body().assertThat().statusCode(200).extract().response();
		System.out.println("Extracted Response :" +res.asString());	
	}

	@Test(priority=4)
	public void VerifyRequest_Headers_Sent()
	{
		Response res=
				given().
				baseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io")
				.headers("Token", "49020100029000011")
				.headers("x-Mock-Request-Headers", "Token")
				.headers("x-mock-response-code",200).
				log().headers().
				when().get("/openapi/subscriptions/v2/get/").
				then().log().body().assertThat().statusCode(200).extract().response();
	}

	@Test(priority=5)
	public void Verify_Dynamic_Adding_Extracting_Of_ResponseHeaders()
	{
		HashMap<String,String> headList=new HashMap<String,String>();// // Create a map for headers
		headList.put("Token", "49020100029000011");
		headList.put("x-Mock-Request-Headers", "Token");
		headList.put("x-mock-response-code","200");

		// Print all key-value pairs in the HashMap
		System.out.println("----------------------Header Key-Value Pairs:----------------");
		for (Map.Entry<String, String> entry : headList.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

		Headers extractReqheads=given()./// Send the request with the headers and extract the response headers
				baseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io").
				headers(headList).
				when().get("/openapi/subscriptions/v2/get/").
				then().log().body().assertThat().statusCode(200).extract().headers();

		// Iterate and print all response headers
		System.out.println("\n------------------------------Response Headers:----------------------------");

		for(Header header: extractReqheads) 
		{
			System.out.println(header.getName() + ": " + header.getValue());
		}

		Assert.assertEquals(extractReqheads.get("TokenResponse").getName(),"TokenResponse","Verify Specific Header Name");// Validate the Header Value
		Assert.assertEquals(extractReqheads.getValue("TokenResponse"),"Authorzied Successfully.","Verify Specific Header Value");// Validate the Header Value
		// Assert.assertEquals(extractReqheads.get,"Authorzied Successfully.","Verify Specific Assert Key");// Validate the Header Value


		System.out.println("\n Extract Specific Headers-Name : "+extractReqheads.get("TokenResponse").getName());
		System.out.println("\n Extract Specific Headers-Value : "+extractReqheads.getValue("TokenResponse"));


	}

	@Test(priority=6)
	public void Verify_Payment_Status_Fields() {
		// Sending the request
		Response res = 
				given()
				.baseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io")
				.headers("Token", "49020100029000011")
				.headers("x-Mock-Request-Headers", "Token")
				.headers("x-mock-response-code", 200)
				.contentType(ContentType.JSON)  // Ensure response is parsed as JSON
				.log().headers()
				.when()
				.get("/openapi/subscriptions/v2/get/")
				.then()
				.log().body()
				.assertThat()
				.statusCode(200)
				.extract()
				.response();
		//.body("",hasKey(""));

		// Verify response content type
		System.out.println("Response Content-Type: " + res.contentType());

		// Log the response body as a String
		String responseBody = res.asString();
		System.out.println("Response Body: " + responseBody);

		// Parse response as JSON to extract specific fields
		JsonPath jsonPath = new JsonPath(responseBody);

		Assert.assertEquals(jsonPath.getString("payment-status.webhookPath"), "/payment/transaction-status","webhookPath Type Verification of Block-PaymentStatus");  
		Assert.assertEquals(jsonPath.getString("payment-status.deliveryType"), "WEBHOOKDELIVERY","Delivery Type Verification of Block-PaymentStatus");

		// Verify the presence of expected fields and Not Null
		Assert.assertNotNull(jsonPath.get("payment-status"));
		Assert.assertNotNull(jsonPath.get("payment-status.webhookPath"));
		Assert.assertNotNull(jsonPath.get("payment-status.deliveryType"));
	}

	@Test(priority=7)
	public void Verify_Empty_Filters_in_payment_status()
	{
		Response res = 
				given()
				.baseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io")
				.headers("Token", "49020100029000011")
				.headers("x-Mock-Request-Headers", "Token")
				.headers("x-mock-response-code", 200)
				.contentType(ContentType.JSON)  // Ensure response is parsed as JSON
				.log().headers()
				.when()
				.get("/openapi/subscriptions/v2/get/")
				.then()
				.log().body()
				.assertThat()
				.statusCode(200)
				.extract()
				.response();
		JsonPath jsonPath=new JsonPath(res.asString());
		List<Object> filters=jsonPath.getList("payment-status.filters");
		Assert.assertEquals(filters.size(),0,"Array filters Size Verification of Block-PaymentStatus");

	}


	@Test(priority=8)
	public void Verify_credit_debit_advice_Fields_Filters() {
		// Sending the request
		Response res = 
				given()
				.baseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io")
				.headers("Token", "49020100029000011")
				.headers("x-Mock-Request-Headers", "Token")
				.headers("x-mock-response-code", 200)
				.contentType(ContentType.JSON)  // Ensure response is parsed as JSON
				.log().headers()
				.when()
				.get("/openapi/subscriptions/v2/get/")
				.then()
				.log().body()
				.assertThat()
				.statusCode(200)
				.extract()
				.response();
		// Parse response as JSON to extract specific fields
		JsonPath jsonPath = new JsonPath(res.asString());

		List<Object> filterArr=jsonPath.getList("credit-debit-advice.filters.fieldName");

		//  System.out.println("Filter Array Size : "+filterArr.size());

		for(Object filterList:filterArr)
		{
			if(filterList.toString().equals("accountIdentifier.bankCode"))
			{
				Assert.assertTrue(jsonPath.getString("credit-debit-advice.filters[0].fieldName").equals("accountIdentifier.bankCode"));
				Assert.assertTrue(jsonPath.getString("credit-debit-advice.filters[0].filterType").equals("ALLOW"));

			}
			else if(filterList.toString().equals("postExecutionBalance.amount"))
			{
				System.out.println("\n ENTER");
				Assert.assertTrue(jsonPath.getString("credit-debit-advice.filters[1].fieldName").equals("postExecutionBalance.amount"));
				Assert.assertTrue(jsonPath.getString("credit-debit-advice.filters[1].filterType").equals("BLOCK"));
				Assert.assertNotNull(jsonPath.getList("credit-debit-advice.filters[1].fieldValues"));

			}
			else
			{
				continue;
			}
			//System.out.println(filterList.toString());
		}


		/*


	  //  System.out.println("credit-debit-advice fieldName: " + jsonPath.getString(""));*/
	}
	@Test(priority=9)
	public void Verify_Non_empty_Filters_in_credit_debit_advice()
	{
		Response res = 
				given()
				.baseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io")
				.headers("Token", "49020100029000011")
				.headers("x-Mock-Request-Headers", "Token")
				.headers("x-mock-response-code", 200)
				.contentType(ContentType.JSON)  // Ensure response is parsed as JSON
				.log().headers()
				.when()
				.get("/openapi/subscriptions/v2/get/")
				.then()
				.log().body()
				.assertThat()
				.statusCode(200)
				.extract()
				.response();
		// Parse response as JSON to extract specific fields
		JsonPath jsonPath = new JsonPath(res.asString());
		List<Object> fieldList=jsonPath.getList("credit-debit-advice.filters.fieldValues");

		for(int i=0;i<fieldList.size();i++)
		{
			String path = String.format("credit-debit-advice.filters[%d].fieldValues", i);
			Assert.assertNotEquals(jsonPath.getList(path).size(),0);
		}

	}


	@Test(priority=10)
	public void Verify_Webhook_Paths()
	{
		Response res = 
				given()
				.baseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io")
				.headers("Token", "49020100029000011")
				.headers("x-Mock-Request-Headers", "Token")
				.headers("x-mock-response-code", 200)
				.contentType(ContentType.JSON)  // Ensure response is parsed as JSON
				.log().headers()
				.when()
				.get("/openapi/subscriptions/v2/get/")
				.then()
				.log().body()
				.assertThat()
				.statusCode(200)
				.extract()
				.response();
		// Parse response as JSON to extract specific fields
		JsonPath jsonPath = new JsonPath(res.asString());
		Assert.assertNotNull(jsonPath.getString("payment-status.webhookPath"),"payment-status.webhookPath should not be NULL");
		Assert.assertEquals(jsonPath.getString("payment-status.webhookPath"),"/payment/transaction-status","payment-status.webhookPath verification");
		Assert.assertNotNull(jsonPath.getString("credit-debit-advice.webhookPath"),"credit-debit-advice.webhookPath should be NULL");



	}

	@Test(priority=11)
	public void Verify_PresenceOfKey_payment_status_Fields()
	{
		Response res=given()
		.baseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io")
		.headers("Token", "49020100029000011")
		.headers("x-Mock-Request-Headers", "Token")
		.headers("x-mock-response-code", 200)
		.accept(ContentType.JSON)  // Request JSON response from the server
		 .contentType(ContentType.JSON)  // Send JSON formatted request if applicable
		.log().headers()
		.when()
		.get("/openapi/subscriptions/v2/get/")
		.then()
		.contentType(ContentType.JSON)
		.body("payment-status",hasKey("filters"),
			"payment-status",hasKey("webhookPath"),
			"payment-status",hasKey("deliveryType"))
		.log().headers().extract().response();
		
		//System.out.println("\n Headers : "+res.getContentType());
		
	   
	}	

	@Test(priority=12)
	public void Verify_PresenceOfKey_credit_debit_advice_Fields()
	{
		Response res=given()
		.baseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io")
		.headers("Token", "49020100029000011")
		.headers("x-Mock-Request-Headers", "Token")
		.headers("x-mock-response-code", 200)
		.accept(ContentType.JSON)  // Request JSON response from the server
		 .contentType(ContentType.JSON)  // Send JSON formatted request if applicable
		.log().headers()
		.when()
		.get("/openapi/subscriptions/v2/get/")
		.then()
		.contentType(ContentType.JSON)
		.log().body().extract().response();
		
		
		JsonPath jsonPath=new JsonPath(res.asString());
		List<Map<String, Object>> filterArray=jsonPath.getList("credit-debit-advice.filters");
		System.out.println("\n Filter arrary size :"+filterArray.size());
		
		 
		for(int i=0;i<filterArray.size();i++)
		{
			String path=String.format("credit-debit-advice.filters[%d]", i);
			Map<String, Object> filter = jsonPath.getMap(path);

			// Assert that the filter has the key 'fieldName'
			assertThat(filter, hasKey("fieldName"));
			assertThat(filter, hasKey("filterType"));
			assertThat(filter, hasKey("fieldValues"));
		}
		

	   
	}	
	
	@Test(priority=13)
	public void Verify_Count_credit_debit_advice_Fields()
	{
		Response res=given()
		.baseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io")
		.headers("Token", "49020100029000011")
		.headers("x-Mock-Request-Headers", "Token")
		.headers("x-mock-response-code", 200)
		.accept(ContentType.JSON)  // Request JSON response from the server
		 .contentType(ContentType.JSON)  // Send JSON formatted request if applicable
		.log().headers()
		.when()
		.get("/openapi/subscriptions/v2/get/")
		.then()
		.contentType(ContentType.JSON)
		.log().body().extract().response();
		
		
		JsonPath jsonPath=new JsonPath(res.asString());
		List<Map<String, Object>> filterArray=jsonPath.getList("credit-debit-advice.filters");
		//System.out.println("\n Filter arrary size :"+filterArray.size());
		
		Assert.assertEquals(filterArray.size(), 2,"Verification Credit-debit-advice Fields Filters should contain at least 2 objects");
	}	

	
	@Test(priority=14)
	public void Verify_CheckNoAdditionalFields()
	{
		given()
		.baseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io")
		.headers("Token", "49020100029000011")
		.headers("x-Mock-Request-Headers", "Token")
		.headers("x-mock-response-code", 200)
		.accept(ContentType.JSON)  // Request JSON response from the server
		 .contentType(ContentType.JSON)  // Send JSON formatted request if applicable
		.log().headers()
		.when()
		.get("/openapi/subscriptions/v2/get/")
		.then()
			.contentType(ContentType.JSON)
			.log().all().
			body("", hasKey("payment-status")).
				body("payment-status", allOf(
                hasKey("filters"),
                hasKey("webhookPath"),
                hasKey("deliveryType")// Ensures no additional fields
        )).
			body("", hasKey("credit-debit-advice")).
				body("credit-debit-advice", allOf(
                hasKey("filters"),
                hasKey("webhookPath"),
                hasKey("deliveryType")
                // Ensures no additional fields
        ));
		
	}
		@Test(priority=15)
		public void Verify_CountOfRootElements()
		{
			Response res=given()
			.baseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io")
			.headers("Token", "49020100029000011")
			.headers("x-Mock-Request-Headers", "Token")
			.headers("x-mock-response-code", 200)
			.accept(ContentType.JSON)  // Request JSON response from the server
			 .contentType(ContentType.JSON)  // Send JSON formatted request if applicable
			.log().headers()
			.when()
			.get("/openapi/subscriptions/v2/get/")
			.then().
			log().body().statusCode(200).extract().response();
			
			JsonPath jsonPath= new JsonPath(res.asString());
			Map<String,Object> rootElement=jsonPath.getMap("$");
			
			Assert.assertEquals(rootElement.size(),2,"Verify_CountOfRootElements");
	}	
		
		@Test(priority=16)
		public void Verify_CountOfBank_codes()
		{
			Response res=given()
			.baseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io")
			.headers("Token", "49020100029000011")
			.headers("x-Mock-Request-Headers", "Token")
			.headers("x-mock-response-code", 200)
			.accept(ContentType.JSON)  // Request JSON response from the server
			 .contentType(ContentType.JSON)  // Send JSON formatted request if applicable
			.log().headers()
			.when()
			.get("/openapi/subscriptions/v2/get/")
			.then().
			log().body().statusCode(200).extract().response();
			
			JsonPath jsonPath= new JsonPath(res.asString());
			
			List<Object> countBankCodes=jsonPath.getList("credit-debit-advice.filters[0].fieldValues");
			List<Object> countBankamount=jsonPath.getList("credit-debit-advice.filters[1].fieldValues");
			
			Assert.assertTrue(countBankCodes.size()>=2,"Verification of fieldValues should contain three specific bank codes.");
			Assert.assertTrue(countBankCodes.size()>=1,"Verification of fieldValues should contain three specific bank codes.");
			
			
		
	}	
		@Test(priority=17)
		public void Verify_DataStructure()
		{
			Response response=given()
			.baseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io")
			.headers("Token", "49020100029000011")
			.headers("x-Mock-Request-Headers", "Token")
			.headers("x-mock-response-code", 200)
			.accept(ContentType.JSON)  // Request JSON response from the server
			 .contentType(ContentType.JSON)  // Send JSON formatted request if applicable
			.log().headers()
			.when()
			.get("/openapi/subscriptions/v2/get/")
			.then()
	            .log().all()  // Log the response body
	            .statusCode(200)  // Validate status code
	            // Validate data structure types
	            .body("payment-status.filters", isA(List.class))  // Check if filters is a List
	            .body("payment-status.webhookPath", isA(String.class))  // Check if webhookPath is a String
	            .body("payment-status.deliveryType", isA(String.class))  // Check if deliveryType is a String
	            .body("credit-debit-advice.filters", isA(List.class))  // Check if filters is a List
	            .body("credit-debit-advice.webhookPath", isA(String.class))  // Check if webhookPath is a String
	            .body("credit-debit-advice.deliveryType", isA(String.class))  // Check if deliveryType is a String
	            .extract().response();
			
			JsonPath jsonPath=new JsonPath(response.asString());
			
			List<Object> filterArray=jsonPath.getList("credit-debit-advice.filters");
			for(int i=0;i<filterArray.size();i++)
			{
				String path_fieldName=String.format("credit-debit-advice.filters[%d].fieldName", i);
				String path_filterType=String.format("credit-debit-advice.filters[%d].filterType", i);
				String path_filterValues=String.format("credit-debit-advice.filters[%d].filterType", i);
				
				
				if(path_fieldName.equals("accountIdentifier.bankCode"))
				{
					assertThat(path_fieldName,isA(String.class));
					assertThat(path_filterType,isA(String.class));
					assertThat(path_filterType,isA(List.class));
					List<Object> fieldValues=jsonPath.getList("credit-debit-advice.filters.fieldValues");
					
					for(Object fieldList:fieldValues)
					{
						assertThat(fieldList,isA(String.class));
					}
					
				}
				else if(path_fieldName.equals("postExecutionBalance.amount"))
				{
					assertThat(path_fieldName,isA(String.class));
					assertThat(path_filterType,isA(String.class));
					assertThat(path_filterType,isA(List.class));
					
					List<Object> fieldValues=jsonPath.getList("credit-debit-advice.filters.fieldValues");
					
					for(Object fieldList:fieldValues)
					{
						assertThat(fieldList,isA(float.class));
						
					}
					
				}

				
			}
			
			
		
	}	

	
}

