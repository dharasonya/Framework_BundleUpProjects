package com.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Final_GetRequest_Sanity {

	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	Response res;

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
	
	@Test(priority=1)
	public void ValidateStatusCode()
	{
        given()
            .spec(requestSpecification)
        .when()
            .get("/openapi/Biller_OTOE00005XXZ43") // Add a leading slash here
        .then()
        	.spec(responseSpecification); 
      
	}
	
	@Test(priority=2)
	public void Verify_PrimaryKeys()
	{
	given()
        .spec(requestSpecification)
    .when()
        .get("/openapi/Biller_OTOE00005XXZ43") // Add a leading slash here
    .then()
    	.spec(responseSpecification)
    	.body("$", hasKey("EuronetRefNo"),
    		"$", hasKey("MerchantRefNo"),
    		"$", hasKey("PaymentRefNo"),
    		"$", hasKey("ApprovalRefNo"),
    		"$", hasKey("ResponseCode"),
    		"$", hasKey("ResponseMessage"),
    		"$", hasKey("ResponseDescription"),
    		"$", hasKey("AdditionalInformation"),
    		"$", hasKey("BillerID"),
    		"$", hasKey("StateCode"),
    		"$", hasKey("BBPSRefId"),
    		"$", hasKey("OperatorRefId"),
    		"$", hasKey("BBPSONUSRefId"),
    		"$", hasKey("NetworkMode"));
	}
	
	@Test(priority=3)
	public void Verify_EuronetRefNo()
	{
		res=given()
        .spec(requestSpecification)
    .when()
        .get("/openapi/Biller_OTOE00005XXZ43") // Add a leading slash here
    .then().extract().response();
		
		JsonPath jsonPath=new JsonPath(res.asString());
		
		Assert.assertNotNull(jsonPath.getString("EuronetRefNo"),"Verification of Euronet RefNo.");
		Assert.assertEquals(jsonPath.getString("EuronetRefNo").length(), 10,"Length Verification of Euronet Ref No.");
		assertThat(res.jsonPath().getInt("EuronetRefNo"), Matchers.instanceOf(Integer.class));
	}
	
	@Test(priority=4)
	public void Verify_MerchantRefNoRefNo()
	{
		res=given()
        .spec(requestSpecification)
    .when()
        .get("/openapi/Biller_OTOE00005XXZ43") // Add a leading slash here
    .then().extract().response();
		
		JsonPath jsonPath=new JsonPath(res.asString());
		
		Assert.assertNotNull(jsonPath.getString("MerchantRefNo"),"Verification of MerchantRefNo.");
		Assert.assertEquals(jsonPath.getString("MerchantRefNo").length(), 12,"Length Verification of MerchantRefNo Ref No.");
		assertThat(res.jsonPath().getString("MerchantRefNo"), Matchers.instanceOf(String.class));
	}
	
	@Test(priority=5)
	public void Verify_PaymentRefNo()
	{
		res=given()
        .spec(requestSpecification)
    .when()
        .get("/openapi/Biller_OTOE00005XXZ43") // Add a leading slash here
    .then().spec(responseSpecification).extract().response();
		
		JsonPath jsonPath=new JsonPath(res.asString());
		
		Assert.assertNotNull(jsonPath.getString("PaymentRefNo"),"Verification of PaymentRefNo.");
		Assert.assertEquals(jsonPath.getString("PaymentRefNo").length(), 20,"Length Verification of PaymentRefNo Ref No.");
		assertThat(res.jsonPath().getString("PaymentRefNo"), Matchers.instanceOf(String.class));
	}
	
	@Test(priority=6)
	public void Verify_ApprovalRefNo()
	{
		res=given()
        .spec(requestSpecification)
    .when()
        .get("/openapi/Biller_OTOE00005XXZ43") // Add a leading slash here
    .then().extract().response();
		
		JsonPath jsonPath=new JsonPath(res.asString());
		
		Assert.assertNotNull(jsonPath.getString("ApprovalRefNo"),"Verification of ApprovalRefNo.");
		Assert.assertEquals(jsonPath.getString("ApprovalRefNo").length(), 8,"Length Verification of ApprovalRefNo.");
		assertThat(res.jsonPath().getInt("ApprovalRefNo"), Matchers.instanceOf(Integer.class));
	}
	
	@Test(priority=7)
	public void Verify_ResponseCode()
	{
		res=given()
        .spec(requestSpecification)
    .when()
        .get("/openapi/Biller_OTOE00005XXZ43") // Add a leading slash here
    .then().extract().response();
		
		JsonPath jsonPath=new JsonPath(res.asString());
		
		Assert.assertNotNull(jsonPath.getString("ResponseCode"),"Verification of ResponseCode.");
		Assert.assertEquals(jsonPath.getString("ResponseCode").length(), 2,"Length Verification of ResponseCode.");
		assertThat(res.jsonPath().getString("ResponseCode"), Matchers.instanceOf(String.class));
			
		switch(jsonPath.getString("ResponseCode"))
		{
		case "00":
		{
			Assert.assertTrue(jsonPath.getString("ResponseCode").equals("00"), "Success-Verification of Response Code Mapping");
			break;
		}
		case  "EI":
		{
			Assert.assertTrue(jsonPath.getString("ResponseCode").equals("EI"), "Failed-Verification of Response Code Mapping");
			
			break;
		}
		}
	}
	
	@Test(priority=8)
	public void Verify_ResponseMessage()
	{
		res=given()
        .spec(requestSpecification)
    .when()
        .get("/openapi/Biller_OTOE00005XXZ43") // Add a leading slash here
    .then().extract().response();
		
		JsonPath jsonPath=new JsonPath(res.asString());
		
		Assert.assertNotNull(jsonPath.getString("ResponseMessage"),"Verification of ResponseMessage.");
		Assert.assertEquals(jsonPath.getString("ResponseMessage").length(), 10,"Length Verification of ResponseMessage.");
		assertThat(res.jsonPath().getString("ResponseMessage"), Matchers.instanceOf(String.class));
		
		switch(res.jsonPath().getString("ResponseMessage"))
		{
		case "Successful":
		{
			Assert.assertTrue(jsonPath.getString("ResponseCode").equals("00"), "Success-Verification of Response Code Mapping");
			Assert.assertTrue(jsonPath.getString("ResponseMessage").equals("Successful"), "Verification of ResponseMessage");
			break;
		}
		}
		
	}
	
	@Test(priority=9)
	public void Verify_ResponseDescription()
	{
		res=given()
        .spec(requestSpecification)
    .when()
        .get("/openapi/Biller_OTOE00005XXZ43") // Add a leading slash here
    .then().extract().response();
		
		JsonPath jsonPath=new JsonPath(res.asString());
		
		Assert.assertNotNull(jsonPath.getString("ResponseDescription"),"Verification of ResponseDescription.");
		Assert.assertEquals(jsonPath.getString("ResponseDescription").length(), 10,"Length Verification of ResponseDescription.");
		assertThat(res.jsonPath().getString("ResponseDescription"), Matchers.instanceOf(String.class));
		Assert.assertTrue(jsonPath.getString("ResponseDescription").equals("Successful"), "Verification of ResponseDescription");
		switch(res.jsonPath().getString("ResponseMessage"))
		{
		case "Successful":
		{
			Assert.assertTrue(jsonPath.getString("ResponseCode").equals("00"), "Success-Verification of Response Code Mapping");
			Assert.assertTrue(jsonPath.getString("ResponseMessage").equals("Successful"), "Verification of ResponseMessage");
			break;
		}
		}

	}
	
	@Test(priority=10)
	public void Verify_BillerID()
	{
		res=given()
        .spec(requestSpecification)
    .when()
        .get("/openapi/Biller_OTOE00005XXZ43") // Add a leading slash here
    .then().extract().response();
		
		JsonPath jsonPath=new JsonPath(res.asString());
		
		Assert.assertNotNull(jsonPath.getString("BillerID"),"Verification of BillerID.");
		Assert.assertEquals(jsonPath.getString("BillerID").length(), 14,"Length Verification of BillerID.");
		assertThat(res.jsonPath().getString("BillerID"), Matchers.instanceOf(String.class));
		Assert.assertTrue(jsonPath.getString("BillerID").equals("OTOE00005XXZ43"), "Verification of BillerID");
	}
	
	
	@Test(priority=10)
	public void Verify_StateCode()
	{
		res=given()
        .spec(requestSpecification)
    .when()
        .get("/openapi/Biller_OTOE00005XXZ43") // Add a leading slash here
    .then().extract().response();
		
		JsonPath jsonPath=new JsonPath(res.asString());
		
		Assert.assertNull(jsonPath.getString("BillerID"),"Verification of StateCode.");
		assertThat(res.jsonPath().getString("StateCode"), Matchers.instanceOf(String.class));
	}
	
	
	@Test(priority=11)
	public void Verify_BBPSRefId()
	{
		res=given()
        .spec(requestSpecification)
    .when()
        .get("/openapi/Biller_OTOE00005XXZ43") // Add a leading slash here
    .then().extract().response();
		
		JsonPath jsonPath=new JsonPath(res.asString());
		
		Assert.assertNotNull(jsonPath.getString("BBPSRefId"),"Verification of BBPSRefId.");
		Assert.assertEquals(jsonPath.getString("BBPSRefId").length(), 20,"Length Verification of BBPSRefId.");
		assertThat(res.jsonPath().getString("BBPSRefId"), Matchers.instanceOf(String.class));
		Assert.assertEquals(jsonPath.getString("BBPSRefId"),jsonPath.get("PaymentRefNo"),"Verification of Payment and BBPSRefId are Same");
	}
	
	@Test(priority=12)
	public void Verify_BBPSONUSRefId()
	{
		res=given()
        .spec(requestSpecification)
    .when()
        .get("/openapi/Biller_OTOE00005XXZ43") // Add a leading slash here
    .then().extract().response();
		
		JsonPath jsonPath=new JsonPath(res.asString());
		
		Assert.assertNull(jsonPath.getString("BBPSONUSRefId"),"Verification of BBPSONUSRefId.");
		assertThat(res.jsonPath().getString("BBPSONUSRefId"), Matchers.instanceOf(String.class));
	}
	
	@Test(priority=13)
	public void Verify_NetworkMode()
	{
		res=given()
        .spec(requestSpecification)
    .when()
        .get("/openapi/Biller_OTOE00005XXZ43") // Add a leading slash here
    .then().extract().response();
		
		JsonPath jsonPath=new JsonPath(res.asString());
		Assert.assertNotNull(jsonPath.getString("NetworkMode"),"Verification of NetworkMode.");
		Assert.assertEquals(jsonPath.getString("NetworkMode").length(), 9,"Length Verification of NetworkMode.");
		assertThat(res.jsonPath().getString("NetworkMode"), Matchers.instanceOf(String.class));
	
	}
	
	
	

	
}
