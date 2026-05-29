package Rest;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
 
public class GetUsersTest
{
	@Test
	public void getUsers()
	{
		given()
		
		.when().get("https://dummyjson.com/users/1")
		
		.then().statusCode(200)
		.log().all();
	}
	
}