package Assertions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Create_Incident_With_File {

	@Test
	public void get_incident() {
		
		Map<String,String> queryparameters = new HashMap<String,String>();
		queryparameters.put("sysparm_fields", "number,sys_id,short_description");
		queryparameters.put("sysparm_limit", "3");
		
		//add end point
				RestAssured.baseURI= "https://dev249137.service-now.com//now/table/";
				
				//add authentication
				RestAssured.authentication = RestAssured.basic("admin","3SGvy^yVL2l^");
				
				//Form the request
				File inputfile = new File("src/test/resources");
				
			
				//form the request
				RequestSpecification inputrequest = RestAssured.given().queryParams(queryparameters);
				
				//send request
				Response response = RestAssured.get("incident");
				
				//print the response
				response.prettyPrint();
				
				//extract the sys_id
//				String sys_id = response.jsonPath().getString("result.sys_id");
//				
//				System.out.println("the value of sys id is.. "+sys_id);
//				
			//	response.then().assertThat().statusCode(201);
//				response.then().assertThat().statusCode(Matchers.equalTo(200));
//				response.then().assertThat().body("result.number", Matchers.containsString("INC0010016"));
				
				
				
		
	}
}
