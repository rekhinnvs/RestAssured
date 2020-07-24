package TestCases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Payload;

import java.io.File;

import static io.restassured.RestAssured.given;

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

    @Test(enabled = false)
    public void addComment() {
        issueID = "CLAS-4";
        endpoint = "rest/api/2/issue/"+issueID+"/comment";

        int responseCode = given().auth().preemptive().basic("dracksagain@gmail.com","0BnHftVpB11ca6xMik0D5FA4")
                .header("Content-Type","application/json")
                .body(Payload.getnewComment())
                .post(endpoint)
                .then().log().body().log().status().extract().response().getStatusCode();
        System.out.println("Response code : " +responseCode);
    }

    @Test
    public void addAttachment() {
        issueID = "CLAS-4";
        endpoint = "rest/api/2/issue/"+issueID+"/attachments";
        given().auth().preemptive().basic("dracksagain@gmail.com","0BnHftVpB11ca6xMik0D5FA4")
                .header("X-Atlassian-Token","no-check")
                .multiPart("file",new File("./src/test/resources/bug_clas4"))
                .post(endpoint)
                .then().log().status();
    }


}
