package vaibhav.TestListinersClasses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import vaibhav.ExtentReport.ExtentReport;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Listiners implements ITestListener {

    private static ExtentReports extent = ExtentReport.getInstance();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = extentTest.get();
        if (test != null) {
            test.log(Status.PASS, "Test Passed");
        }
    }

   @Override
public void onTestFailure(ITestResult result) {
    ExtentTest test = extentTest.get();

    if (test == null) {
        
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    test.log(Status.FAIL, "Test Failed");
    test.log(Status.FAIL, result.getThrowable());

    Object testInstance = result.getInstance();
    WebDriver driver = null;

    try {
        Field driverField = result.getTestClass().getRealClass().getDeclaredField("driver");
        driverField.setAccessible(true);
        driver = (WebDriver) driverField.get(testInstance);

        String screenshotPath = saveScreenshotToFile(driver, result.getMethod().getMethodName());

        test.addScreenCaptureFromBase64String(getBase64Screenshot(driver), "Check_Screenshot");
        test.log(Status.INFO, "Screenshot saved at: " + screenshotPath);

    } catch (Exception e) {
        test.log(Status.WARNING, "Could not capture screenshot: " + e.getMessage());
    } finally {
        try {
            if (driver != null) {
                driver.navigate().refresh();
                Thread.sleep(2000);
                test.log(Status.INFO, "Browser refreshed after failure.");
            }
        } catch (Exception e) {
            test.log(Status.WARNING, "Could not refresh browser: " + e.getMessage());
        }
    }
}


   @Override
public void onTestSkipped(ITestResult result) {
    ExtentTest test = extentTest.get();
    if (test != null) {
        test.log(Status.SKIP, "Test Skipped");
    }
}

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // 🔁 Flush once after all tests finish
    }

    private String saveScreenshotToFile(WebDriver driver, String methodName) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Save to test-output/ScreenShots/
        String screenshotDir = System.getProperty("user.dir") + "//test-output//ScreenShots//";
        new File(screenshotDir).mkdirs(); // Create folder if it doesn't exist

        String screenshotPath = screenshotDir + methodName + ".png";
        File dest = new File(screenshotPath);

        Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        return screenshotPath;
    }

    private String getBase64Screenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }

}