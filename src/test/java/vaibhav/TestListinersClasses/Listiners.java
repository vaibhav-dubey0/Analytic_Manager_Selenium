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
        extentTest.get().log(Status.PASS, "Test Passed");
    }

  @Override
public void onTestFailure(ITestResult result) {
    extentTest.get().log(Status.FAIL, "Test Failed");
    extentTest.get().log(Status.FAIL, result.getThrowable());

    Object testInstance = result.getInstance();
    try {
        Field driverField = result.getTestClass().getRealClass().getDeclaredField("driver");
        driverField.setAccessible(true);
        WebDriver driver = (WebDriver) driverField.get(testInstance);


        String screenshotPath = saveScreenshotToFile(driver, result.getMethod().getMethodName());

        extentTest.get().addScreenCaptureFromBase64String(getBase64Screenshot(driver), "Check_Screenshot");

        extentTest.get().log(Status.INFO, "Screenshot saved at: " + screenshotPath);

    } catch (Exception e) {
        extentTest.get().log(Status.WARNING, "Could not capture screenshot: " + e.getMessage());
    }
}


    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, "Test Skipped");
    }

     @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // 🔁 Flush once after all tests finish
    }

    private String saveScreenshotToFile(WebDriver driver, String methodName) throws IOException {
    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

    // Save to test-output/ScreenShots/
    String screenshotDir = System.getProperty("user.dir") + "/test-output/ScreenShots/";
    new File(screenshotDir).mkdirs();  // Create folder if it doesn't exist

    String screenshotPath = screenshotDir + methodName + ".png";
    File dest = new File(screenshotPath);

    Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    return screenshotPath;
}


    private String getBase64Screenshot(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
   }


}