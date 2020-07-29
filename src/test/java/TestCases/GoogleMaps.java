package TestCases;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import mapsPojo.Location;
import mapsPojo.MapAddPlace;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class GoogleMaps {
    MapAddPlace addPlace;
    Location location;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI ="https://rahulshettyacademy.com/";
        addPlace = new MapAddPlace();
        location = new Location();

        //Create a Map object with the required field.
        location.setLat("-38.383434");
        location.setLng("33.427349");

        addPlace.setLocation(location);
        addPlace.setAccuracy(45);
        addPlace.setName("BackLine house");
        addPlace.setPhone_number("(+91) 880 261 3937");
        addPlace.setAddress("30, side layout, cohen 24");

        ArrayList<String> typesList = new ArrayList<String>();
        typesList.add("type 1");
        typesList.add("type 2");
        addPlace.setTypes(typesList);


    }

    @Test(priority = 1,enabled = false)
    public void addPlaceToMaps() {

        String endpoint = "maps/api/place/add/json";

        given().queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body(addPlace)
                .post(endpoint)
                .then().extract().response().prettyPrint();
    }

    @Test
    public void specBuilder() {
        String endpoint = "maps/api/place/add/json";
        //Create a request spec builder to avoid duplication of same parameters.
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .addQueryParam("key","qaclick123")
                .setContentType(ContentType.JSON)
                .build();

        //Create a response spec builder to avoid duplication of code.
        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

        given().spec(requestSpec)
                .body(addPlace)
                .when()
                .post(endpoint)
                .then()
                .spec(responseSpec).log().body();


    }
}
