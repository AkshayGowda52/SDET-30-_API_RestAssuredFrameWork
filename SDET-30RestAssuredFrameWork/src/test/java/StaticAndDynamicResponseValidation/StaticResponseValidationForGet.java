package StaticAndDynamicResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class StaticResponseValidationForGet 
{
	@Test
	public void staticresponsevalidationget()
	{
		baseURI = "http://localhost";
		port = 8084;
		String expecteddata = "TY_PROJ_002";
		
		Response resp = when()
		.get("/projects");
		String actualdata = resp.jsonPath().get("[0].projectId");
		
	    Assert.assertEquals(actualdata, expecteddata);
	    System.out.println("data is verified");
	    
	    resp.then().log().all();
		
	}
}
