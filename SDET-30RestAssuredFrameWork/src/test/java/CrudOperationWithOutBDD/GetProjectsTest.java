package CrudOperationWithOutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetProjectsTest 
{
	@Test
	public void getprojects()
	{
		Response res = RestAssured.get("http://localhost:8084/projects");
		//System.out.println(res.asString());
		//res.prettyPrint();
		res.then().log().all();
		
		
		
		
		
		
		
		
	}
}
