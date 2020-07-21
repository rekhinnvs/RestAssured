package TestCases;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Reqres {

    private static String baseUrl;
    String endpoint;

    @BeforeClass
    public void setup() {
        baseUrl = "https://reqres.in/";
    }

    @Test(enabled = false,priority = 1)
    public void requestUsers() {
        //Create a users with the given details and verify the status code
        endpoint = "api/users";
        given()
                .header("Content-Type","application/json")
        .body("{\n" +
                "    \"name\": \"rekhin\",\n" +
                "    \"job\": \"boss\"\n" +
                "}")
        .when().post(baseUrl+endpoint)
        .then().log().body()
                .assertThat().statusCode(201);
    }

    @Test(priority = 2)
    public void getAndUpdateUser() {
        //Update and retrieve the values, [actually the values are not retained in the server]
        endpoint = "api/users";
        //Get the response in a string
        String response = given()
                            .header("Content-Type","application/json")
                            .when().get(baseUrl+endpoint)
                            .then().log().body().extract().response().asString();

        //System.out.println(response);
        System.out.println("************");
        //Convert the string to json and get the value from it.
        //JsonPath js = new JsonPath(response);
        //System.out.println(js.getString("data.id"));

        //Update the user using PUT
        given()
                .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .when()
                .put(baseUrl+endpoint)
                .then();

        //Get the value after updating.
        given()
                .when().get(baseUrl+"api/users")
                .then().log().body();

    }
}
