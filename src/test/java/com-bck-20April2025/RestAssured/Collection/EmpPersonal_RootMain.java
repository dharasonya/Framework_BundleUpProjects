package com.RestAssured.Collection;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;



import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ePay_CRM.Reusable_Utils.TestReader_ExcelData;
import ePay_CRM.Test_DataDriven.TestData_ePayPropertyConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class EmpPersonal_RootMain extends JSONReader {
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
            .setBaseUri("https://3af23ad0-0933-4db1-b3b8-7ddb08339e5e.mock.pstmn.io")
            .addHeader("x-mock-Response", "201")
            .setContentType(ContentType.JSON)  // Ensure you specify the Content-Type
            .setAccept(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();
				
        // Setup response specification
        responseSpecification = respBuilder
            .expectStatusCode(201)
            .expectContentType(ContentType.JSON)
            .log(LogDetail.ALL) // Log details of the response
            .build();
	}
	
	//  @Test(dataProvider="JsonTestData")
	@Test(priority=1,dataProvider="ExcelDataProvider",groups= {"SanityTest"} ,dataProviderClass=TestReader_ExcelData.class,enabled=true)
    public void PostCreate_User(String name, String username,String email,String street,String suite,String city,String zipcode,String lat,String lng) {
	      
		  EmpAddress_GeoCode geo=new EmpAddress_GeoCode(lat,lng);
		  EmpAddress address=new EmpAddress(street,suite,city,zipcode,geo);
		  EmpPresonal_Details root=new EmpPresonal_Details(name,username,email,address);
	        res=given()
	            .spec(requestSpecification)
	            .body(root)
	         .when()
	            .post("/openapi/CreateUser")
	            .then().spec(responseSpecification).extract().response();
	        
	        System.out.println("\n Id Value :"+res.path("id"));
	        Assert.assertNotNull(res.path("id"));
		
	        System.out.println("Response Status Code: " + res.getStatusCode());   
	    }
	 	  
	  @DataProvider(name="TestData")
	  public Object[][] getData1()
	  {
		return new Object[][] 
		{
			{"Leanne Graham","Bret","Sincere@april.biz","Kulas Light","Apt. 556","Gwenborough","92998-3874","-37.3159","81.1496"},
			{"Sonyarani Dhara","sdhara","sdhara@gmail.com","Samta Nagar","RivewView CHSL-2","ThaneWest","400604","-57.3159","51.1496"},
			{"Payal Dhara","pdhara","pdhara@gmail.com","Samta Nagar","Apt. 956","Nagpur","499392","-37.3159","81.1496"}
		}; 
	  }
	  
	  @DataProvider(name ="JsonTestData")
	    public Object[][] getData2() {
	        String filePath = "./src/main/resources/FetchData/JsonTestData.json";
	        List<Map<String, String>> testDataList = JSONReader.getTestData(filePath);
	        Object[][] data = new Object[testDataList.size()][1];

	        for (int i = 0; i < testDataList.size(); i++) {
	            data[i][0] = testDataList.get(i);
	        }
	        return data;
	    }
}




