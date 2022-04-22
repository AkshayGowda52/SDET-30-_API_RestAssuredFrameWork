package StaticAndDynamicResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidationForGet 
{
    @Test
    public void dynamicvalidationforget()
    {
    	//pre requisites
    	baseURI = "http://localhost";
    	port = 8084;
    	String expecteddata = "TY_PROJ_1008";
    	
    	
    	//action
    	Response resp = when()
    	.get("/projects");
    	
    	//validation
    	boolean flag = false;
    	List<String> actualdata = resp.jsonPath().get("projectId");
    	for (String act : actualdata) 
    	{
			if(act.equalsIgnoreCase(expecteddata))
			{
				flag=true;
			}
		}
    	
    	Assert.assertEquals(flag, true);
    	System.out.println("data is verified");
    	
    	resp.then().log().all();
    	
    }
}
