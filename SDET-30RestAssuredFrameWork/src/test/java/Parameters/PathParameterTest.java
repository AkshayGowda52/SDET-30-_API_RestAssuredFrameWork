package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameterTest 
{
	@Test
	public void getsingleProject()
	{
		//prerequisites
		baseURI = "http://localhost";
		port = 8084;
		
		given()
		.pathParam("pid", "TY_PROJ_002")
		
		//action
		.when()
		.get("/projects/{pid}")
		
		//validation
		.then().log().all();
	}
}
