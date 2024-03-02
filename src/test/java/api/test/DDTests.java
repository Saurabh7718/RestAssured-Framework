package api.test;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.payload.Pet;
import api.utilities.DataProviders;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

//read data from userendpoints endpoints  and take data from dataproviders 

public class DDTests {

	// dataprovider class in present in same class then we dont need to use of
	// dataProviderClass annotation

	 

	    // dataprovider class in present in same class then we don't need to use of
	    // dataProviderClass annotation

	    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	    public void testPostUser(String userID, String petid, String quantity, String shipDate, String status, String complete1) {
	        Pet userPayload = new Pet();
	        userPayload.setId(Integer.parseInt(userID));
	        userPayload.setPetId(Integer.parseInt(petid));
	        userPayload.setQuantity(Integer.parseInt(quantity));
	        userPayload.setShipDate(shipDate);
	        userPayload.setComplete(complete1);
	        userPayload.setStatus(status);

	        Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(userPayload).when()
	                .post("https://petstore.swagger.io/v2/store/order");

	        Assert.assertEquals(response.getStatusCode(), 200);
	        System.out.println("User created successfully.");
	        ResponseBody resBody = response.getBody();
	    }
	

	@Test(priority = 2, dataProvider = "id", dataProviderClass = DataProviders.class, enabled=false)
	public void testDeleteUserbyId(int userID) {
		Pet userPayload = new Pet();
		//userPayload.setId(userID);
		int id=userPayload.getPetId();
		Response repsonse = given()
						.pathParam("id", userID)
					.when()
						.delete("https://petstore.swagger.io/v2/store/order/{id}");
		repsonse.then().log().all().statusCode(200);
	}

}
