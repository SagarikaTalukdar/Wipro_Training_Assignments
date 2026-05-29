package Rest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.restassured.http.ContentType;

public class LoginDDTExcelTest {

    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void setup() {

        extent = ExtentManager.getReport();

        baseURI = "https://dummyjson.com";
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() throws Exception {

        String path = "src/test/resources/LoginData.xlsx";

        return ExcelUtils.getExcelData(path, "Sheet1");
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {

        test = extent.createTest("Login Test : " + username);

        String requestBody = "{\n" +
                "\"username\":\"" + username + "\",\n" +
                "\"password\":\"" + password + "\"\n" +
                "}";

        given()

                .contentType(ContentType.JSON)

                .body(requestBody)

                .when()
                .post("/user/login")

                .then()
                .log().all();

        test.info("Username : " + username);
        test.info("Password : " + password);

        test.pass("Login API Executed Successfully");
    }

    @AfterTest
    public void tearDown() {

        extent.flush();
    }
}