package CrudOperationWithBDD;

import javax.sound.sampled.Port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.mysql.cj.conf.DatabaseUrlContainer;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectTest 
{
	@Test
	public void createproject()
	{
		
		//Step 1: Create pre requisite
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "abhi");
		jObj.put("projectName", "rajeev");
		jObj.put("status", "Completed");
		jObj.put( "teamSize", 10);
		
		baseURI = "http://localhost";
		port = 8084;
		
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		
		.when()			//Step 2: perform action
		.post("/addProject")
		
		
		.then()          //Step 3: validation
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
		
	
				
	}
}
