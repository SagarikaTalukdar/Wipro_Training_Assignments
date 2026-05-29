package Rest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllUsersTest {

    ExtentReports extent;
    ExtentTest test;

    
    @BeforeTest
    public void setup() {

        extent = ExtentManager.getReport();

        baseURI = "https://dummyjson.com";
    }

    
    @Test
    public void getAllUsers() {

        test = extent.createTest("Get All Users API Test");

        Response response = given()

                .contentType(ContentType.JSON)

                .when()
                .get("/users")

                .then()
                .statusCode(200)
                .log().all()
                .extract().response();

        
        int totalUsers = response.jsonPath().getInt("total");

        System.out.println("Total Users : " + totalUsers);

        
        test.pass("GET All Users API executed successfully");
        test.info("Total Users Found : " + totalUsers);
    }

    
    @AfterTest
    public void tearDown() {

        extent.flush();
    }
}