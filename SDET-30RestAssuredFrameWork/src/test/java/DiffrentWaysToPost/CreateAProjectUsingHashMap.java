package DiffrentWaysToPost;

import org.testng.annotations.Test;

import CommonLibraries.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateAProjectUsingHashMap 
{
	@Test
	public void createproject()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		//Step 1: create pre requisite
		HashMap map = new HashMap();
		map.put("createdBy", "ravi");
		map.put("projectName", "building"+new JavaLibrary().getRandomNumber());
		map.put("status", "Completed");
		map.put("teamSize", 15);
		
		given()
		.body(map)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.log().all();
		
				
	}
}
