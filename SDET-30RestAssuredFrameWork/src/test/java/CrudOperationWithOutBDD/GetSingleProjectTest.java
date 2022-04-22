package CrudOperationWithOutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProjectTest {
	@Test
	public void getsingleproject()
	{
		//Step 1: Create pre requisites
		
		//Step 2: perform action
		Response response = RestAssured.get("http://localhost:8084/projects/TY_PROJ_413");
		
		//Step 3: validation
		response.then().log().all();
		int actualstatus = response.getStatusCode();
		Assert.assertEquals(200, actualstatus);
		
		
	}
}
