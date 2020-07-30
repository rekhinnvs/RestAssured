package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import testData.MapsData;
import utils.Base;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class AddPlacesToMaps extends Base {

    Response response;
    JsonPath js;


    @Given("Add place payload")
    public void add_place_payload() throws IOException {
        //Get the base url from the global.properties file
        RestAssured.baseURI = getBaseURL("rahulShetty");

    }

    @When("I call add place API with {string} http request")
    public void i_call_add_place_api_with_http_request(String httpRequest) {
        String endpoint = "maps/api/place/add/json";
        //Get the address data from Mapsdata class
        MapsData mapsData = new MapsData();
        response = given().queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body(mapsData.addAddress())
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
