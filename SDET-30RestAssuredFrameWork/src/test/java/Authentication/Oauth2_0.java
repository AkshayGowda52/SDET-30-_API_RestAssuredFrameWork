package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2_0 
{
	@Test
	public void oauthAuthentication()
	{
		//create a request to generate access token
	     Response resp = given()
		.formParam("client_id", "akshaycoops")
		.formParam("client_secret", "290925257c5106283630ef0436f1a012")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://example.com")
		.formParam("code", "authorization_code")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		//.then().log().all();
	
		//Capture the access token from the response of the above request
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		
		//create another request and use the token to access the APIs
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 3114)
		
		.when()
		//.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
		
		.then().log().all();
	}
}
