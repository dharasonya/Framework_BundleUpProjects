package com.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Final_GetRequest_Sanity {

	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;

	@BeforeTest
	public void HitEndPoint_Setup()
	{
		RequestSpecBuilder builder=new RequestSpecBuilder();
		ResponseSpecBuilder respBuilder=new ResponseSpecBuilder();
		
		requestSpecification=builder.
			setBaseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io")
			.addHeader("x-mock-Response", "200")
			.setAccept(ContentType.JSON)
			.log(LogDetail.ALL).build();
				
		responseSpecification = respBuilder
		            .expectStatusCode(200)
		            .expectContentType(ContentType.JSON)
		            .log(LogDetail.ALL) // Log details of the response
		            .build();
	}
	
	@Test
	public void ValidateStatusCode()
	{
        given()
            .spec(requestSpecification)
        .when()
            .get("/openapi/Biller_OTOE00005XXZ43") // Add a leading slash here
        .then()
        	.spec(responseSpecification); 
      
	}
	
}
