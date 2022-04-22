package CommonLibraries;

import io.restassured.response.Response;

/**
 * this class consists of generic method related to restassured
 * @author aksha
 *
 */
public class RestAssuredLibrary 
{
	/**
	 * This method will return the json path
	 * @param resp
	 * @param jsonPath
	 */
	public String getJasonPath(Response resp, String jsonPath )
	{
		String value = resp.jsonPath().get(jsonPath);
		return value;
	}
}
