package api.endpoints;

import api.payload.User;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//UserEndPoints.java
//created for perform create , read,update,delete requests the user API


public class UserEndPoints {
	
	
	public static Response createUser(User payload) 
	{
		
		Response response= given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(routes.post_url);
		return response;
		
	}
	
	public static Response readUser(String userName) {
	    Response response = given()
	        .pathParam("username", userName) // Set username as a path parameter
	    .when()
	        .get(routes.get_url);
	    return response;
	}

	
	public static Response updateUser(User payload, String userName) 
	{
		
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			.pathParam("username", userName)
		.when()
			.put(routes.update_url);
		return response;
		
	}
	
	public static Response deleteUser(String userName) 
	{
		
		Response response= given()
			 .pathParam("username", userName)
		.when()
			.delete(routes.delete_url);
		return response;
		
	}
	
	
}
