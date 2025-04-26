package com.RestAssured;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers;

import org.hamcrest.Matcher;
//"$" refers to the root of the JSON object, so body("$", hasKey("id")) means 
//"check if the root of the JSON object has a key called id."

public class Validate_Get_Request {
	Response response ;
	@BeforeMethod
	public void get_Request()
	{
		// Make the GET request and store the response
		response = 
			given().
			baseUri("https://dummyapi.online/api/").
			header("Content-Type", "application/json").
			when(). 
			get("/movies/10").
			then().
			log().all().
			assertThat().statusCode(200).  // Validate the status code
			body("$",hasKey("id"),// Json Object must have Key-Id
				"$",hasKey("movie"),// Json Object must have Key-Movie
				"$",hasKey("rating"),// Json Object must have Key-rating
				"$",hasKey("image"),// Json Object must have Key-image
				"$",hasKey("imdb_url")).// Json Object must have Key-imdb_url // Validate the body before extracting the response
				extract().response();  // Extract the response after validations

			// Print the response values for debugging
			System.out.println("Response Values : " + response.asString());
	}
	
	@Test(priority=1)
	public void Extract_Single_Field()
	{
		System.out.println("\n Get Field-Movie Name Values : "+response.path("movie"));
		System.out.println("\n Get Field-image Name Values : "+response.path("image"));
		System.out.println("\n Get Field-rating Name Values : "+response.path("rating"));
		System.out.println("\n Get Field-image Values : "+response.path("image"));
		System.out.println("\n Get Field-imdb_url Values : "+response.path("imdb_url"));
	}

	@Test(priority=2)
	public void Verify_DataStructure()
	{
		assertThat(response.jsonPath().getInt("id"), Matchers.instanceOf(int.class)); // Assert that 'id' is an integer
		assertThat(response.jsonPath().get("movie"), Matchers.instanceOf(String.class)); // Assert that 'moview name' is an String
		assertThat(response.jsonPath().getFloat("rating"), Matchers.instanceOf(float.class));// Assert that 'rating name' is a float value
		assertThat(response.jsonPath().get("image"), Matchers.instanceOf(String.class));// Assert that 'image url' is a String value
		assertThat(response.jsonPath().get("imdb_url"), Matchers.instanceOf(String.class));// Assert that 'imdb_url' is a String value    
	}

	@Test(priority=3)
	public void FieldLength_ValueCheck()
	{
		//System.out.println("\n Get Field-Movie Name Length : "+response.path("movie").toString().length());
		assertThat(response.path("id").toString().length(),lessThanOrEqualTo(3));
		assertThat(response.path("movie").toString().length(),lessThanOrEqualTo(15));
		assertThat(response.path("rating").toString().length(),lessThanOrEqualTo(5));
		assertThat(response.path("rating").toString(),matchesPattern("^\\d{1,3}\\.\\d{1}$"));
		assertThat(response.path("image").toString(),matchesPattern("^.+\\.(jpg|jpeg|png)$"));
		assertThat(response.path("image").toString(),matchesPattern("^.+\\.(jpg|jpeg|png)$"));
		assertThat(response.path("imdb_url").toString(),matchesPattern("^https://www\\.imdb\\.com/title/tt\\d{7,8}/$"));		
		
	}

	
}

