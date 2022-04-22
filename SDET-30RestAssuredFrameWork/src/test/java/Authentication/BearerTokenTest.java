package Authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerTokenTest 
{
	@Test
	public void bearerToken()
	{
		baseURI = "https://api.github.com";
		JSONObject jObj = new JSONObject();
		jObj.put("name", "SDET-30restassured");
		
		given()
		.auth()
		.oauth2("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")
		.body(jObj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/user/repos")
		
		.then().log().all();
	}
}
