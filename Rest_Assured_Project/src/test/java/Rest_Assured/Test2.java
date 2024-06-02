package Rest_Assured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test2 {

	@Test

	public void get() {
		

		//add end point
		RestAssured.baseURI= "https://dev249137.service-now.com//now/table/";
		
		//add authentication
		RestAssured.authentication = RestAssured.basic("admin","3SGvy^yVL2l^");
		
		//send request
		Response response = RestAssured.get("incident");
		
		//print
		response.prettyPrint();
		
		
	}
}
