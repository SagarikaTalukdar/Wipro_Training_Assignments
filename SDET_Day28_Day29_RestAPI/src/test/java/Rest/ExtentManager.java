package Rest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports getReport() {

        ExtentSparkReporter spark =
                new ExtentSparkReporter("test-output/APIReport.html");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(spark);

        extent.setSystemInfo("Tester", "Sagarika");
        extent.setSystemInfo("Project", "DummyJSON API Testing");

        return extent;
    }
}