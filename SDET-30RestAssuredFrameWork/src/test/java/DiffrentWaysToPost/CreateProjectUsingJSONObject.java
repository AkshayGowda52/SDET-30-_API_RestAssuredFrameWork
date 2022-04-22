package DiffrentWaysToPost;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import CommonLibraries.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingJSONObject 
{
	@Test
	public void createproject()
	{
		//Step 1: create pre requisites
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "ravi");
		jObj.put("projectName", "building"+new JavaLibrary().getRandomNumber());
		jObj.put("status", "Completed");
		jObj.put("teamSize", 15);
		
		baseURI = "http://localhost";
		port =8084;
		
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}
}
