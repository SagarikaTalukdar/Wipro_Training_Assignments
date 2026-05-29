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

public class UserLoginTest {

    ExtentReports extent;
    ExtentTest test;

    
    @BeforeTest
    public void setup() {

        extent = ExtentManager.getReport();

        baseURI = "https://dummyjson.com";
    }

    
    @Test
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

        
        String firstName = response.jsonPath().getString("firstName");
        String token = response.jsonPath().getString("token");

        
        System.out.println("Logged In User : " + firstName);
        System.out.println("Token : " + token);

        
        Assert.assertEquals(firstName, "Emily");
        Assert.assertNotNull(token);

        
        test.pass("User Login API executed successfully");
        test.info("Logged In User : " + firstName);
    }

    
    @AfterTest
    public void tearDown() {

        extent.flush();
    }
}