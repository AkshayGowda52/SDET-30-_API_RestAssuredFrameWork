package CrudOperationWithOutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProjectTest 
{
	@Test
	public void deleteproject()
	{
		//Step 1: create pre requisite
		//Step 2: perform action
		Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_413");
		
		//Step 3 : validation 
		response.then().log().all();
		int actualresponse = response.getStatusCode();
		Assert.assertEquals(204, actualresponse);
	}
}
