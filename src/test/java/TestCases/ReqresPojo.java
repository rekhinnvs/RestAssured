package TestCases;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reqresPojo.Data;
import reqresPojo.Users;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ReqresPojo {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in/";
    }

    @Test
    public void getUsers() {
        String endpoint = "api/users";
        //add the default parser to parse the output json file.
        //Get the response as a users class object.
        Users users = given().expect().defaultParser(Parser.JSON)
                .when()
                .get(endpoint)
                .as(Users.class);

        System.out.println(users.getPage());
        //Number of items in Data object.
        System.out.println(users.getData().size());
        System.out.println("*****************");
        //Get all the first and last name from the Data object
        for (int i=0; i<users.getData().size(); i++) {
            System.out.print(users.getData().get(i).getFirst_name()+ " ");
            System.out.println(users.getData().get(i).getLast_name());
        }
        System.out.println("****************");
        //Get the data under ad field
        System.out.println(users.getAd().getCompany());
        System.out.println(users.getAd().getUrl());

    }

}
