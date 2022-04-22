package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ParameterTestForGit 
{
	@Test
	public void parametersTest()
	{
		baseURI = "https://api.github.com";
		
		given()
		.pathParam("username", "AkshayGowda52")
		.queryParam("per_page", 30)
		.queryParam("page", 1)
		
		.when()
		.get("/users/{username}/repos")
		
		.then().log().all();
		
	}
	
}
