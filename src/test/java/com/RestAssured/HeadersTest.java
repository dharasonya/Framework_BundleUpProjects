package com.RestAssured;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers;

import org.hamcrest.Matcher;
public class HeadersTest {

	@Test
	public void multiple_Headers_UsingMap()
	{
		HashMap<String,String> heads=new HashMap<String,String>();
		heads.put("x-mock-response-code","200");
		heads.put("header", "headerValue1");
		heads.put("x-mock-match-request-headers", "header");
		
		
		Response res=
				given().
					baseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io/openapi/").
					headers(heads).
					log().headers().
				when().
					get("subscriptions/v2/get/").
				then().
					log().body().
					assertThat().statusCode(200).  
					extract().
					response();
		
		//System.out.println("Response Value :"+res.asString());
	}
}
