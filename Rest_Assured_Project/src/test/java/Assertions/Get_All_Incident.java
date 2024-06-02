package Assertions;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_All_Incident {

	@Test
	public void get_incident() {
		
		//add end point
				RestAssured.baseURI= "https://dev249137.service-now.com//now/table/";
				
				//add authentication
				RestAssured.authentication = RestAssured.basic("admin","3SGvy^yVL2l^");
				
			
				//form the request
				RequestSpecification inputrequest = RestAssured.given().contentType("application/json")
				.when().body("{\n"
						+ "    \"short_description\": \"Created using postman-2\"\n"
						+ "}");
				
				//send request
				Response response = RestAssured.get("incident");
				
				
				//send the request
			//	Response response = RestAssured.post("incident");
				
				//extract the sys_id
				String sys_id = response.jsonPath().getString("result.sys_id");
				
				System.out.println("the value of sys id is.. "+sys_id);
				
				response.then().assertThat().statusCode(201);
				response.then().assertThat().body("result.sys_id", Matchers.containsString("inc"));
				
				//print the response
				response.prettyPrint();
				
		
	}
}
