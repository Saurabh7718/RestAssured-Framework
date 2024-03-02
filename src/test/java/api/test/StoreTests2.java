package api.test;

import org.testng.annotations.*;
import api.endpoints.UserEndPoints2;
import api.payload.Pet;
import io.restassured.response.Response;

public class StoreTests2 {

    Pet userPayload;

    @BeforeClass
    public void setupData() {
        userPayload = new Pet();
        userPayload.setId(1);
        userPayload.setPetId(35);
        userPayload.setQuantity(6);
        userPayload.setShipDate("2024-02-24T11:45:49.605Z");
    }

    @Test(priority = 1, enabled = true)
    public void testPostUser() {
        Response response = UserEndPoints2.createUser(userPayload);
        response.then().log().all();
    }

    @Test(priority = 2, enabled = true)
    public void testGetUserByName() {
        int id = userPayload.getId();
        System.out.println(id);
        Response response = UserEndPoints2.readUser(id);
        response.then().log().all();
    }

    @Test(priority = 3, enabled = false)
    public void testUpdateUserByquantity() {
        int id = userPayload.getId();
        userPayload.setId(5);
        userPayload.setPetId(35);
        userPayload.setQuantity(100);
        userPayload.setShipDate("2024-02-24T11:45:49.605Z");

        Response response = UserEndPoints2.updateUser(userPayload, "username");
        response.then().log().all();
    }

    @Test(priority = 4)
    public void testDeleteUserById() {
        int id = userPayload.getId();
        Response response = UserEndPoints2.deleteUser(id);
        response.then().log().all();
    }
}
