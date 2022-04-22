package CrudOperationWithOutBDD;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpDateProjectTest 
{
	@Test
	public void updateproject()
	{
		//Step 1: Create pre requisite
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "akshay");
		jObj.put("projectName", "sony");
		jObj.put("status", "Completed");
		jObj.put( "teamSize", 20);
		
		RequestSpecification req = RestAssured.given();
		req.body(jObj);
		req.contentType(ContentType.JSON);
		
		//Step 2: perform action
		Response response = req.put("http://localhost:8084/projects/TY_PROJ_413");
		System.out.println(response.asPrettyString());
		System.out.println(response.prettyPrint());
		
		//Step 3: validation 
		response.then().log().all();
		int actualresponse = response.getStatusCode();
		Assert.assertEquals(200,  actualresponse);
	
	}
}
