package com.RestAssured;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.specification.SpecificationQuerier;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.apache.http.client.methods.RequestBuilder;
import org.hamcrest.Matcher;

import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers;

public class Req_Res_Specification {

	RequestSpecification requestSpecification;
	
	@Test
	public void RequestSpec_Type_1()
	{
		requestSpecification=given()
				.baseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io/")
				.headers("Token", "49020100029000011")
				.headers("x-Mock-Request-Headers", "Token")
				.headers("x-mock-response-code", 200)
				.accept(ContentType.JSON)  // Request JSON response from the server
				.contentType(ContentType.JSON) ;
		// Send JSON formatted request if applicable
				
		Response response=requestSpecification.get("/openapi/subscriptions/v2/get/").then().log().all().extract().response();  // Log the response b
		assertThat(response.statusCode(),is(equalTo(200)));
		assertThat(response.path("payment-status.deliveryType").toString(),is(equalTo("WEBHOOKDELIVERY")));
		
		
	}
	
	@Test
	public void RequestSpec_Type_2()
	{
		RequestSpecBuilder requestBuilder=new RequestSpecBuilder();
		
		
		requestBuilder.setBaseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io/")
		.addHeader("Token", "49020100029000011")
		.addHeader("x-Mock-Request-Headers", "Token")
		.addHeader("x-mock-response-code", "200")
		.setAccept(ContentType.JSON).log(LogDetail.ALL);
		
		requestSpecification=requestBuilder.build();
				
		Response response=given().spec(requestSpecification).get("/openapi/subscriptions/v2/get/").then().log().all().extract().response();  // Log the response b
		assertThat(response.statusCode(),is(equalTo(200)));
		assertThat(response.path("payment-status.deliveryType").toString(),is(equalTo("WEBHOOKDELIVERY")));
		
		
	}
	@Test
	public void RequestSpec_Type_3()
	{
		RequestSpecBuilder requestBuilder=new RequestSpecBuilder();
		
		
		requestBuilder.setBaseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io/")
		.addHeader("Token", "49020100029000011")
		.addHeader("x-Mock-Request-Headers", "Token")
		.addHeader("x-mock-response-code", "200")
		.setAccept(ContentType.JSON).log(LogDetail.ALL);
		
		RestAssured.requestSpecification=requestBuilder.build();
				
		Response response=get("/openapi/subscriptions/v2/get/").then().log().all().extract().response();  // Log the response b
		assertThat(response.statusCode(),is(equalTo(200)));
		assertThat(response.path("payment-status.deliveryType").toString(),is(equalTo("WEBHOOKDELIVERY")));
		
		
	}

	@Test
	public void RequestSpec_Type_4()
	{
		RequestSpecBuilder requestBuilder=new RequestSpecBuilder();
		
		
		requestBuilder.setBaseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io/")
		.addHeader("Token", "49020100029000011")
		.addHeader("x-Mock-Request-Headers", "Token")
		.addHeader("x-mock-response-code", "200")
		.setAccept(ContentType.JSON).log(LogDetail.ALL);
		
		RestAssured.requestSpecification=requestBuilder.build();
		queryTest();
				
		Response response=get("/openapi/subscriptions/v2/get/").then().log().all().extract().response();  // Log the response b
		assertThat(response.statusCode(),is(equalTo(200)));
		assertThat(response.path("payment-status.deliveryType").toString(),is(equalTo("WEBHOOKDELIVERY")));
		
		
		
	}

	public void queryTest()
	{
		QueryableRequestSpecification queryableRequestSpecification=SpecificationQuerier.query(RestAssured.requestSpecification);
		System.out.println("\n Print Headers--------: "+queryableRequestSpecification.getHeaders());
		System.out.println("\n Print URL--------: "+queryableRequestSpecification.getBaseUri());
	}
	
	@Test
	public void ResponseSpec_Type_5()
	{
		RequestSpecBuilder requestBuilder=new RequestSpecBuilder();
		ResponseSpecBuilder responseBuilder=new ResponseSpecBuilder();
		
		
		requestBuilder.setBaseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io/")
		.addHeader("Token", "49020100029000011")
		.addHeader("x-Mock-Request-Headers", "Token")
		.addHeader("x-mock-response-code", "200")
		.setAccept(ContentType.JSON).log(LogDetail.ALL);
		
		
		RestAssured.requestSpecification=requestBuilder.build();
		RestAssured.responseSpecification=expect().statusCode(200).contentType(ContentType.JSON);
		RestAssured.responseSpecification=responseBuilder.build();
		Response response=get("/openapi/subscriptions/v2/get/").then().log().all().extract().response();  // Log the response b

		
		
		
	}
	
	@Test
	public void ResponseSpec_Type_6()
	{
		RequestSpecBuilder requestBuilder=new RequestSpecBuilder();
		ResponseSpecBuilder responseBuilder=new ResponseSpecBuilder();
		
		
		requestBuilder.setBaseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io/")
		.addHeader("Token", "49020100029000011")
		.addHeader("x-Mock-Request-Headers", "Token")
		.addHeader("x-mock-response-code", "200")
		.setAccept(ContentType.JSON).log(LogDetail.ALL);

		RestAssured.requestSpecification=requestBuilder.build();
		
		responseBuilder.expectStatusCode(200).expectContentType(ContentType.JSON).log(LogDetail.BODY);
		
		RestAssured.responseSpecification=responseBuilder.build();
		

		Response response=get("/openapi/subscriptions/v2/get/").then().log().all().extract().response();  // Log the response b

		
		
		
	}


}
