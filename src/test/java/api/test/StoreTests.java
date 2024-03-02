package api.test;

import static io.restassured.RestAssured.given;

import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import api.payload.Pet;
import api.payload.User;

public class StoreTests {
    
	public org.apache.logging.log4j.Logger logger;
	
    Pet userPayload;
    Faker faker;
    @BeforeClass
    public void setupData() {
       //userPayload = new User();
       /* userPayload.setUserName("abc123");
        userPayload.setFirstName("a");
        userPayload.setLastName("c");
        userPayload.setPhone("1234554321");
        
    	*/
    	userPayload=new Pet();
    	userPayload.setId(1);
    	userPayload.setPetId(35);
    	userPayload.setQuantity(6);
    	userPayload.setShipDate("2024-02-24T11:45:49.605Z");
    	logger=LogManager.getLogger(this.getClass());
    	
    }
    
    @Test(priority=1, enabled=true)
    public void testPostUser() {
        Response response = given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(userPayload)
        .when()
            .post("https://petstore.swagger.io/v2/store/order");
    	
    	Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("User created successfully.");
        ResponseBody resBody=response.getBody();
        
        logger.info("***********user is created*************");
    }
 
    @Test(priority=2, enabled=true)
    public void testGetUserByName() {
    	int id=userPayload.getId();
        Response response = given()
        .pathParam("id", id)
             
        .when()
            .get("https://petstore.swagger.io/v2/store/order/{id}");

        response.then().log().all();
 System.out.println(response.getStatusCode());
 
 logger.info("***********reading user info*************");
    }    
    
    @Test(priority=3, enabled=true)
    public void testUpdateUserByquantity() {
    	int id=userPayload.getId();
    	userPayload.setId(5);
    	userPayload.setPetId(35);
    	userPayload.setQuantity(100);
    	userPayload.setShipDate("2024-02-24T11:45:49.605Z");

        Response response = given()
        		//.pathParam("id", id)
        		.accept(ContentType.JSON)
        		.contentType(ContentType.JSON)
        		.body(userPayload)
             
        .when()
            .post("https://petstore.swagger.io/v2/store/order");//here i haev used post request because put request is not available for store

        response.then().log().all();
        System.out.println(response.getStatusCode());
 
        logger.info("***********updating user*************");
    }  
    
    @Test(priority=4)
    public void testDeleteUserById() {
    	int id=userPayload.getId();
    	Response repsonse=given()
    					.pathParam("id", id)
    				.when()
    					.delete("https://petstore.swagger.io/v2/store/order/{id}");
    	repsonse.then().log().all().statusCode(200);
    	
        logger.info("***********deleting user*************");
    }
}
