package TestCases;

import io.restassured.RestAssured;
import mapsPojo.Location;
import mapsPojo.MapAddPlace;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class GoogleMaps {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI ="https://rahulshettyacademy.com/";

    }

    @Test
    public void addPlaceToMaps() {

        String endpoint = "maps/api/place/add/json";
        //Create a Map object with the required field.
        MapAddPlace addPlace = new MapAddPlace();

        Location location = new Location();
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

        given().queryParam("key","qaclick123")
                .body(addPlace)
                .post(endpoint)
                .then().extract().response().prettyPrint();

    }
}
