package Rest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class GetUsersTestExtended {

    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void setup() {
        extent = ExtentManager.getReport();
    }

    @Test
    public void getUsers() {

        test = extent.createTest("Get Users API Test");

        given()

        .when()
        .get("https://dummyjson.com/users/1")

        .then()
        .statusCode(200)
        .log().all();

        test.pass("GET Users API executed successfully");
    }

    @AfterTest
    public void tearDown() {
        extent.flush();
    }
}