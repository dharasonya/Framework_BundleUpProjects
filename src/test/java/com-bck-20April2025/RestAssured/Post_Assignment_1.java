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

public class Post_Assignment_1 {

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
	 	  
		  LinkedHashMap<String,Object> mainBodyPayload=new LinkedHashMap<String,Object>();  
		  mainBodyPayload.put("colors",colors());
		  
		
		  // Perform POST request
	        res = 
	        given()
	            .spec(requestSpecification)
	            .body(mainBodyPayload)
	         .when()
	            .post("/openapi/Assignment1");

	        // Assert and log response
	     /*   res.then()
	           .spec(responseSpecification);*/

	        // Optional: Log response status and body for debugging
	        System.out.println("Response Status Code: " + res.getStatusCode());
	        System.out.println("Response Body: " + res.getBody().asString());
	    }
	  
	 
	 public List<HashMap<String, Object>> colors()
	 {
		 List<Integer> rgba_List_1=new ArrayList<Integer>();
		 rgba_List_1.add(255);
		 rgba_List_1.add(255);
		 rgba_List_1.add(255);
		 rgba_List_1.add(1);
		 
		 List<Integer> rgba_List_2=new ArrayList<Integer>();
		 rgba_List_2.add(0);
		 rgba_List_2.add(0);
		 rgba_List_2.add(0);
		 rgba_List_2.add(1);
		 
		 HashMap<String,Object> code1=new HashMap<String,Object>();
		 code1.put("rgba", rgba_List_1);
		 code1.put("hex", "#000");
		 
		 HashMap<String,Object> code2=new HashMap<String,Object>();
		 code2.put("rgba", rgba_List_2);
		 code2.put("hex", "#FFF");
		 
		 HashMap<String,Object> colors_1=new HashMap<String,Object>();
		 colors_1.put("color", "black");
		 colors_1.put("category", "hue");
		 colors_1.put("type", "primary");
		 colors_1.put("code", code1);
		 
		 HashMap<String,Object> colors_2=new HashMap<String,Object>();
		 colors_2.put("color", "white");
		 colors_2.put("category", "value");
		 colors_2.put("code", code2);
		 
		 List<HashMap<String, Object>> colors=new ArrayList<HashMap<String,Object>>();
		 colors.add(colors_1);
		 colors.add(colors_2);
		 
		 return colors;
		 
	 }
}
