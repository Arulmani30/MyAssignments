package Rest_Assured;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class update_test3 {

	@Test
	public void update() {
		
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
				Response response = RestAssured.put("incident/518e8455c3d14210b1d338bc0501318c");
				
				int statusCode = response.statusCode();
				System.out.println("status code is" + statusCode);
				
				response.prettyPrint();
				
				response.then().assertThat().statusCode(200);
				response.then().assertThat().body("result.statusCode", Matchers.containsString("inc"));
				
	}
}
