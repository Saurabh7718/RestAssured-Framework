package api.endpoints;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.ResourceBundle;

import api.payload.Pet;

// this method will read data from routes.properties file

public class UserEndPoints2 {

	

    public static Response createUser(Pet userPayload) {
        String post_url = getURL().getString("post_url");
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(userPayload)
            .when()
                .post(post_url);
        	
        return response;
    }

    public static Response readUser(int id) {
        String get_url = getURL().getString("get_url");
        Response response = given()
                .pathParam("id", id)
                     
                .when()
                    .get(get_url);

        return response;
    }

    public static Response updateUser(Pet payload, String userName) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .pathParam("username", userName)
                .when()
                .put(getURL().getString("update_url"));
        return response;
    }

    public static Response deleteUser(int id) {
        String delete_url = getURL().getString("delete_url");
        Response response = given()
                .pathParam("id", id)
                .when()
                .delete(delete_url);
        return response;
    }

    public static ResourceBundle getURL() {
        ResourceBundle routes = ResourceBundle.getBundle("routes");
        return routes;
    }
}
