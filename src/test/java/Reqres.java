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

    @Test
    public void requestUsers() {
        //Create a users with the given details
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
}
