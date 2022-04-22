package DiffrentWaysToPost;

import org.testng.annotations.Test;

import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingPojo
{
	@Test
	public void createproject()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		ProjectLibrary data = new ProjectLibrary("akshai", "tyssdfg", "Completed", 20);
		
		given()
		.body(data)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}
}
