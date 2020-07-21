package TestCases;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.JsonData;

public class JsonParser {

    JsonPath js;

    /*1. Print No of courses returned by API
    2.Print Purchase Amount
    3. Print Title of the first course
    4. Print All course titles and their respective Prices
    5. Print no of copies sold by RPA Course
    6. Verify if Sum of all Course prices matches with Purchase Amount*/

    @BeforeClass
    public void setup() {
        js = new JsonPath(JsonData.getJson());
    }

    //Get the number of courses
    @Test(priority = 1)
    public void getCourseCount() {
        int count = js.getInt("courses.size()");
        System.out.print("Number of courses : "+count);
    }

    //Get the purchase amount
    @Test(priority = 2)
    public void getPurchaseAmount() {
        System.out.print("Purchase amount : "+js.getInt("dashboard.purchaseAmount"));
    }

    //Print Title of the first course
    @Test(priority = 3)
    public void getFirstCourse() {
        String courseTitle = js.get("courses[-1].title");
        System.out.print("First course title : "+courseTitle);
    }

    //Print All course titles and their respective Prices
    @Test(priority = 4)
    public void getAllCourseTitles() {
        int numberOfCourses = js.getInt("courses.size()");
        for(int i=0; i<numberOfCourses; i++) {
            System.out.print(js.getString("courses["+i+"].title"));
            System.out.print(" : ");
            System.out.println(js.getString("courses["+i+"].price"));
        }
    }

    //Print no of copies sold by RPA Course
    @Test(priority = 5)
    public void getNumberOfCopiesOfRPA() {
        int numberOfCourses = js.getInt("courses.size()");
        for(int i=0; i<numberOfCourses; i++) {
            String title = js.getString("courses["+i+"].title");
            if(title.equalsIgnoreCase("RPA")) {
                System.out.print("Number of copies of RPA : "+js.getString("courses["+i+"].copies"));
                break;
            }
        }
    }

    //Verify if Sum of all Course prices matches with Purchase Amount
    @Test(priority = 6)
    public void getTheSumOfCourses() {
        int numberOfCourses = js.getInt("courses.size()");
        int totalPurchaseAmount = js.getInt("dashboard.purchaseAmount");
        int coursePurchaseAmount = 0;
        for(int i=0; i<numberOfCourses; i++) {
            int numberOfCopies = js.getInt("courses["+i+"].copies");
            int pricePerCopy = js.getInt("courses["+i+"].price");
            coursePurchaseAmount += numberOfCopies*pricePerCopy;
        }
        System.out.println("Total amount from purchased books : "+coursePurchaseAmount);
        Assert.assertEquals(coursePurchaseAmount,totalPurchaseAmount);
    }

}
