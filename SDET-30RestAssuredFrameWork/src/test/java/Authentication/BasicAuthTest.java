package Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuthTest 
{
	@Test
	public void basicAuth()
	{
		baseURI ="http://localhost";
		port = 8084;
		
		given()
		.auth().basic("rmgyantra", "rmgy@9999")
		
		.when()
		.get("/login")
		
		.then()
		.assertThat().log().all();
	}
	
	@Test
	public void basicPreEmtiveAuth() 
	{
		baseURI = "http://localhost";
		port = 8084;
		
		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		
		.when()
		.get("/login")
		
		.then()
		.assertThat().statusCode(202).log().all();
	}
	
	@Test
	public void basicDigestiveAuth()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		given()
		.auth().digest("rmgyantra", "rmgy@9999")
		
		.when()
		.get("/login")
		
		.then().statusCode(202).log().all();
		
	}
}
