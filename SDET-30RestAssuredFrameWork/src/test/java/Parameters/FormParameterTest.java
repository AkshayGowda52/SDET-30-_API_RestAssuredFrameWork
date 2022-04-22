package Parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FormParameterTest 
{
	@Test
	public void createprojectusingformparameter()
	{
		//pre requisites
		baseURI = "http://localhost";
		port = 8084;
		given()
		.formParam("createdBy", "muthu")
		.formParam( "projectName", "r13")
		.formParam("status", "Completed")
		.formParam("teamSize", 16)
		.contentType(ContentType.JSON)
		
		//action
		.when()
		.post("/addProject")
		
		//validation
		.then().log().all();
	}
}
