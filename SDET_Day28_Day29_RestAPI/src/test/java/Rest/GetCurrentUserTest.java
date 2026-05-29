package Rest;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetCurrentUserTest {

    ExtentReports extent;
    ExtentTest test;

    String token;

    @BeforeTest
    public void setup() {

        extent = ExtentManager.getReport();

        baseURI = "https://dummyjson.com";
    }

    @Test(priority = 1)
    public void loginUser() {

        test = extent.createTest("User Login API Test");

        String requestBody = "{\n" +
                "\"username\":\"emilys\",\n" +
                "\"password\":\"emilyspass\",\n" +
                "\"expiresInMins\":30\n" +
                "}";

        Response response = given()

                .contentType(ContentType.JSON)

                .body(requestBody)

                .when()
                .post("/user/login")

                .then()
                .statusCode(200)
                .log().all()
                .extract().response();

        
        token = response.jsonPath().getString("accessToken");

        System.out.println("Generated Token : " + token);

        Assert.assertNotNull(token);

        test.pass("Login API executed successfully");
    }

    @Test(priority = 2)
    public void getCurrentUser() {

        test = extent.createTest("Get Current User API Test");

        Response response = given()

                .header("Authorization", "Bearer " + token)

                .when()
                .get("/user/me")

                .then()
                .statusCode(200)
                .log().all()
                .extract().response();

        String firstName = response.jsonPath().getString("firstName");

        System.out.println("Current User : " + firstName);

        Assert.assertEquals(firstName, "Emily");

        test.pass("Get Current User API executed successfully");
    }

    @AfterTest
    public void tearDown() {

        extent.flush();
    }
}