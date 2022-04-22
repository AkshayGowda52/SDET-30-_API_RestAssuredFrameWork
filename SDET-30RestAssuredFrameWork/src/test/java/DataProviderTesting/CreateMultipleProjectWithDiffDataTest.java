package DataProviderTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonLibraries.JavaLibrary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateMultipleProjectWithDiffDataTest 
{
	@Test(dataProvider = "getdata")
	public void createprojectwithdiffdata(String createdBy,String projectName,String status,int teamSize)
	{
		 JavaLibrary jlib = new JavaLibrary();
		 ProjectLibrary plb = new ProjectLibrary(createdBy,projectName,status,teamSize);
		 baseURI = "http://localhost";
		 port = 8084;
		 
		 given()
		 .body(plb)
		 .contentType(ContentType.JSON)
		 
		 .when()
		 .post("/addProject")
		 
		 .then()
		 .log().all();
		 
		 
		
	}
	
	@DataProvider(name = "getdata")
	public Object[][] data()
	{
		Object[][] data = new Object[3][4];
		
		data[0][0] = "akshay";
		data[0][1] = "dell";
		data[0][2] = "Completed";
		data[0][3] = 10;
		
		data[1][0] = "abhi";
		data[1][1] = "sony";
		data[1][2] = "Completed";
		data[1][3] = 10;
		
		data[2][0] = "rajeev";
		data[2][1] = "mari";
		data[2][2] = "Completed";
		data[2][3] = 10;
		
		return data;
		
	}
	
}
