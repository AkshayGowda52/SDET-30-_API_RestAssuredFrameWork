package CrudOperationWithOutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest 
{
	@Test
	public void CreateProjectTest()
	{
		//Step 1: Create the pre requisite -request body
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "akshay");
		jObj.put("projectName", "sony");
		jObj.put("status", "Completed");
		jObj.put( "teamSize", 10);
		
		RequestSpecification req = RestAssured.given();
		req.body(jObj);
		req.contentType(ContentType.JSON);
		
		//Step 2: perform action
		Response response = req.post("http://localhost:8084/addProject");
		System.out.println(response.getContentType());
		System.out.println(response.asString());
		System.out.println(response.prettyPrint());
		System.out.println(response.prettyPeek());
		
	}
}
