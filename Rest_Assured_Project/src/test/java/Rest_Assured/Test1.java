package Rest_Assured;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class Test1 {
	
	@Test
	public void create() {
	
		//add end point
	RestAssured.baseURI= "https://dev249137.service-now.com//now/table/";
	
	//add authentication
	RestAssured.authentication = RestAssured.basic("admin","3SGvy^yVL2l^");
	
	//form the request
	RequestSpecification inputrequest = RestAssured.given().contentType("application/json")
	.when().body("{\n"
			+ "    \"short_description\": \"Created using postman-2\"\n"
			+ "}");
	
	//send the request
	Response response = RestAssured.post("incident");
	
	//extract the sys_id
	String sys_id = response.jsonPath().getString("result.sys_id");
	
	System.out.println("the value of sys id is.. "+sys_id);
	
	//print the response
	response.prettyPrint();
	

	
	
	

}
}
