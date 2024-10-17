package com.RestAssured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Final_PostRequest_Sanity {
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
	        // Payload as a simple JSON string
	      //  String payload = "{ \"RequestType\": \"Service\", \"MerchantCode\": \"AMZ\", \"Amount\": 100 }";

		  String payload="{\n  \"RequestType\": \"Service\",\n  \"MerchantCode\": \"AMZ\",\n  \"Amount\": \"100\"\n}";
	        // Perform POST request
	        res = 
	        given()
	            .spec(requestSpecification)
	            .body(payload)
	         .when()
	            .post("/openapi/PostBiller_OTOE00005XXZ43");

	        // Assert and log response
	     /*   res.then()
	           .spec(responseSpecification);*/

	        // Optional: Log response status and body for debugging
	        System.out.println("Response Status Code: " + res.getStatusCode());
	        System.out.println("Response Body: " + res.getBody().asString());
	    }
}
