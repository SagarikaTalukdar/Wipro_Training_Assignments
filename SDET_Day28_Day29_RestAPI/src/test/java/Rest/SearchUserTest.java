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

public class SearchUserTest {

    ExtentReports extent;
    ExtentTest test;

    
    @BeforeTest
    public void setup() {

        extent = ExtentManager.getReport();

        baseURI = "https://dummyjson.com";
    }

    
    @Test
    public void searchUser() {

        test = extent.createTest("Search User API Test");

        
        Response response = given()

                .contentType(ContentType.JSON)

                .queryParam("q", "John")

                .when()
                .get("/users/search")

                .then()
                .statusCode(200)
                .log().all()
                .extract().response();

        
        int totalUsers = response.jsonPath().getInt("total");

        System.out.println("Total Users Found : " + totalUsers);

        
        Assert.assertTrue(totalUsers > 0);

        
        test.pass("Search User API executed successfully");
        test.info("Users Found : " + totalUsers);
    }

    
    @AfterTest
    public void tearDown() {

        extent.flush();
    }
}