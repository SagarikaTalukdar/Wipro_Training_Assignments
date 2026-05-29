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

public class GetSingleUserTest {

    ExtentReports extent;
    ExtentTest test;

    
    @BeforeTest
    public void setup() {

        extent = ExtentManager.getReport();

        baseURI = "https://dummyjson.com";
    }

    
    @Test
    public void getSingleUser() {

        test = extent.createTest("Get Single User API Test");

        
        Response response = given()

                .contentType(ContentType.JSON)

                .when()
                .get("/users/1")

                .then()
                .statusCode(200)
                .log().all()
                .extract().response();

        
        String firstName = response.jsonPath().getString("firstName");
        String email = response.jsonPath().getString("email");
        int age = response.jsonPath().getInt("age");

        
        System.out.println("First Name : " + firstName);
        System.out.println("Email : " + email);
        System.out.println("Age : " + age);

        
        Assert.assertEquals(firstName, "Emily");
        Assert.assertTrue(email.contains("@"));

        
        test.pass("Get Single User API executed successfully");
        test.info("User Name : " + firstName);
        test.info("User Email : " + email);
    }

    
    @AfterTest
    public void tearDown() {

        extent.flush();
    }
}