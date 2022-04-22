package CrudOperationWithOutBDD;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllTheProjectsTest {
	@Test
	public void getalltheprojects()
	{
		//Step 1: Create pre requisites
		//Step 2: perform action
		Response response = RestAssured.get("http://localhost:8084/projects");
		
		
		//Step 3: validation
		response.then().log().all();
		int actualresponse = response.getStatusCode();
		Assert.assertEquals(200, actualresponse);
	}
}
