package TestCases;

import io.restassured.RestAssured;
import io.restassured.internal.http.HTTPBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Payload;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.preemptive;

public class Jira {

    String endpoint;
    String issueID;
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://automateweb.atlassian.net/";
    }

    @Test(enabled = false,priority = 1)
    public void createIssue() {
        endpoint = "rest/api/3/issue";

        given().auth().preemptive().basic("dracksagain@gmail.com","0BnHftVpB11ca6xMik0D5FA4")
                .header("Content-Type","application/json")
                .body(Payload.createJiraIssue())
                .when()
                .post(endpoint)
                .then().log().body().log().status();
    }

    @Test(enabled = false,priority = 2)
    public void getIssueDetails() {
        issueID = "CLAS-2";
        endpoint = "rest/api/2/issue/"+issueID;
        given().auth().preemptive().basic("dracksagain@gmail.com","0BnHftVpB11ca6xMik0D5FA4")
                .when().get(endpoint)
                .then().log().body();

    }

    @Test(enabled = false,priority = 3)
    public void addComment() {
        issueID = "CLAS-4";
        endpoint = "rest/api/2/issue/"+issueID+"/comment";
        int responseCode = given().auth().preemptive().basic("dracksagain@gmail.com","0BnHftVpB11ca6xMik0D5FA4")
                .header("Content-Type","application/json")
                .body(Payload.getnewComment())
                .when()
                .post(endpoint)
                .then().log().body().log().status().extract().response().getStatusCode();
        System.out.println("Response code : " +responseCode);
    }

    @Test(enabled = false,priority = 4)
    public void addAttachment() {
        issueID = "CLAS-4";
        endpoint = "rest/api/2/issue/"+issueID+"/attachments";
        given().auth().preemptive().basic("dracksagain@gmail.com","0BnHftVpB11ca6xMik0D5FA4")
                .header("X-Atlassian-Token","no-check")
                .multiPart("file",new File("./src/test/resources/bug_clas4"))
                .when()
                .post(endpoint)
                .then().log().status().log().body();
    }

    @Test(enabled = true,priority = 2)
    public void getIssueFields() {
        issueID = "CLAS-4"; //Jira issue id
        endpoint = "rest/api/2/issue/"+issueID;
        //Add the authentication globally so that we can avoid authenticating every time.
        RestAssured.authentication = RestAssured.preemptive().basic("dracksagain@gmail.com","0BnHftVpB11ca6xMik0D5FA4");

        Response response = given()
                .when().get(endpoint)
                .then().extract().response();
        JsonPath js = response.jsonPath();
        int numberOfComments = js.getInt("fields.comment.comments.size()");
        //Get all the comments for the issue.
        for(int i=0; i<numberOfComments; i++) {
            System.out.println(js.getString("fields.comment.comments["+i+"].body"));
        }
    }
}
