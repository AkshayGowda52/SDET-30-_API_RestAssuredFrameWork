package StaticAndDynamicResponseValidation;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import CommonLibraries.JavaLibrary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponsevalidation 
{
	@Test
	public void staticresponsevalidation()
	{
		String expecteddata = "TY_PROJ_1607";
		baseURI = "http://localhost";
		port = 8084;
		//Step 1 : pre requisites
		ProjectLibrary pObj = new ProjectLibrary("house", "rama"+new JavaLibrary().getRandomNumber(), "Completed", 30);
		
		Response resp = given()
		.body(pObj)
		.contentType(ContentType.JSON)
		
		//Step 2: perform action
		. when()
		.post("/addProject");
		
		//validation
		String acatualdata = resp.jsonPath().get("projectId");
	    Assert.assertEquals(acatualdata, expecteddata);
	    System.out.println("data is verified");
	    
	    resp.then().log().all();
	    
	    
	}
	
}
