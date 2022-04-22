package RequestChaining;

import org.testng.annotations.Test;

import CommonLibraries.JavaLibrary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateProjectAndGetProjectTest 
{
	@Test
	public void requestChaining1()
	{
		//Step 1: create project using Pojo
		JavaLibrary jlib = new JavaLibrary();
		ProjectLibrary plib = new ProjectLibrary("punith", "gandadagudi"+jlib.getRandomNumber(), "Completed", 30);
		baseURI ="http://localhost";
		port = 8084;
		
		//create a project
		Response resp = given()
						.body(plib)
						.contentType(ContentType.JSON)
		
						.when()
						.post("/addProject");

		//capture the projectID
		String proId = resp.jsonPath().get("projectId");
		System.out.println(proId);
		resp.then().log().all();
		
		//Create a get request and pass the proId as path parameter
		given()
		.pathParam("pid", proId)
		
		.when()
		.get("/projects/{pid}")
		 
		.then().assertThat().statusCode(200).log().all();
		
	}
}
