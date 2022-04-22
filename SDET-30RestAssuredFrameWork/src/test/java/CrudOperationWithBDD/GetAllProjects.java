package CrudOperationWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetAllProjects 
{
	@Test
	public void getallprojects()
	{
		baseURI = "http://localhost";
		port = 8084;
				
		when()  //Step 2: perform action
		.get("/projects")
		
		.then() //Step 3: validation
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();
	}
}
