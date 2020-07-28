package TestCases;


import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reqresPojo.Users;

import static io.restassured.RestAssured.given;

public class ReqresPojo {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in/";
    }

    @Test
    public void getUsers() {
        String endpoint = "api/users";
        //add the default parser to get it as a json file.
        Users users = given().expect().defaultParser(Parser.JSON)
                .when()
                .get(endpoint)
                .as(Users.class);

    }
}
