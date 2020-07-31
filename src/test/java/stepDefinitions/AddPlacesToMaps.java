package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.protobuf.Api;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.Assert;
import mapsPojo.MapAddPlace;
import testData.MapsData;
import utils.ApiResources;
import utils.Base;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class AddPlacesToMaps extends Base {

    Response response;
    JsonPath js;
    MapsData mapsData;
    MapAddPlace addPlace;

    @Given("Add place with {string} {string} and {string}")
    public void add_place_with_and(String accuracy, String name, String address) throws IOException {
        System.out.println("accuracy " +accuracy);
        RestAssured.baseURI = getBaseURL("rahulShetty");
        mapsData = new MapsData();
        addPlace = mapsData.addAddress(accuracy,name,address);

    }

    @When("I call add place API with {string} http request")
    public void i_call_add_place_api_with_http_request(String httpRequest) {
        //Get the endpoint from the enum class.
        ApiResources apiResources = ApiResources.valueOf("ADDPLACE");
        String endpoint = apiResources.getResource();
        //String endpoint = "maps/api/place/add/json";
        //Get the address data from Mapsdata class
        MapsData mapsData = new MapsData();
        response = given().queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body(addPlace)
                .post(endpoint);
    }

    @Then("response {string} is {string}")
    public void response_is(String status, String statusCode) {
        js = response.jsonPath();
        Assert.assertEquals(js.getString(status),statusCode);
        System.out.println(js.getString(status));
    }

    @Then("get the added address details")
    public void get_the_added_address_details() {
        System.out.println(response.getBody().prettyPrint());

    }
}
