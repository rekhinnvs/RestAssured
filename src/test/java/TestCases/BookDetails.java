package TestCases;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Payload;

import static io.restassured.RestAssured.given;

public class BookDetails {

    private static String baseUrl;
    String endPoint;


    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://216.10.245.166/";
        //baseUrl = "http://216.10.245.166/";
    }

    @Test(priority = 1,enabled = false)
    public void addBooks() {
        endPoint = "Library/Addbook.php";
        given().header("Content-Type","application/json")
                .body(Payload.addBook("milan","276","John perera"))
                .when().post(endPoint)
                .then().assertThat().statusCode(HttpStatus.SC_OK).log().body();
    }
    @Test
    public void getBooks() {
        endPoint = "/Library/GetBook.php";
        Response response = given().header("Content-Type","application/json")
                .param("AuthorName","John perera")
                .get(endPoint)
                .then().extract().response();
        //System.out.println(response.getStatusCode());
        //Get the response body
        System.out.println(response.getBody().prettyPrint());
        //System.out.println(response.prettyPeek());
        //System.out.println(response.print());

    }
}
