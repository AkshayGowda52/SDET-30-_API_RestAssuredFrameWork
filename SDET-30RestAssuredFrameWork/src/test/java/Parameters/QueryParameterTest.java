package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameterTest 
{
	@Test
	public void QueryParameter()
	{
		//prerequisites
		baseURI = "https://reqres.in/";
		given()
		.queryParam("page", 3)
		
		//action
		.when()
		.get("api/users")
		
		//validation
		.then().log().all();
	}
}
