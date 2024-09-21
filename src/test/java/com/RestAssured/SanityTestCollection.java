package com.RestAssured;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
public class SanityTestCollection {

	
	@Test(priority=1)
	public void VerifyGivenEndPoint()
	{
		given().baseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io").
		when().get("/openapi/subscriptions/v2/get/").
		then().log().body().assertThat().statusCode(200);
	}
	
	@Test(priority=2)
	public void VerifyStatusCode()
	{
		given().baseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io").
		when().get("/openapi/subscriptions/v2/get/").
		then().log().body().assertThat().statusCode(200);
	}
	
	@Test(priority=3)
	public void VerifyExtractResponse()
	{
		Response res=given().baseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io").
		when().get("/openapi/subscriptions/v2/get/").
		then().log().body().assertThat().statusCode(200).extract().response();
		System.out.println("Extracted Response :" +res.asString());	
	}
	
	@Test(priority=4)
	public void VerifyRequestHeadersSent()
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
	public void VerifyDynamicAddingExtractingOfResponseHeaders()
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
	
	
	
	
	
}

