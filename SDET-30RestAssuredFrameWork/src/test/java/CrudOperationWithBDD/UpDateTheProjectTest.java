package CrudOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpDateTheProjectTest 
{
	@Test
	public void updatetheproject() 
	{
		
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "ak");
		jObj.put("projectName", "super");
		jObj.put("status", "Completed");
		jObj.put( "teamSize", 50);
		
		baseURI = "http://localhost";
		port = 8084;
		 
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		
		.when()
		.put("/projects/TY_PROJ_1404")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		
	}
}
