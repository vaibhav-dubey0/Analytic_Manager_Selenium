package vaibhav;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import vaibhav.DataDrivenTestCase.JsonDataReader;
import vaibhav.FlackeyTestHandle.RetryFailedTests;
import vaibhav.All_TestCase.LoginTest.Login;
import vaibhav.All_TestCase.Reports_Section.ReportFilter;

@Listeners(vaibhav.TestListinersClasses.Listiners.class)
public class Sequencrun{

 public WebDriver driver;
    public HashMap<String, Object> testData;

    // Constructor for @Factory
    public Sequencrun(HashMap<String, Object> data) {
        this.testData = data;
    }

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost:5012/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void loginTestInvalidData() {
        String userName = (String) testData.get("InvalidUser");
        String password = (String) testData.get("InvalidPassword");
        Login login = new Login(driver);
        login.loginMethod(userName, password);
    }

    @Test
    public void loginTestValidData() {
        String userName = (String) testData.get("username");
        String password = (String) testData.get("password");
        Login login = new Login(driver);
        login.loginMethod(userName, password);
    }

    @Test(alwaysRun = true, retryAnalyzer = RetryFailedTests.class)
    public void deviceFilterTest() {
        ReportFilter filter = new ReportFilter(driver);
        String filterName = "Device";
        filter.filter(filterName);
        filter.deviceFilter();
        filter.applyFilters();
    }

    @Test(alwaysRun = true, retryAnalyzer = RetryFailedTests.class)
    public void applyAgeFilter() {
        ReportFilter filter = new ReportFilter(driver);
        String filterName = "Age";
        filter.filter(filterName);
        filter.ageFilter(String.valueOf(testData.get("age")));
        filter.applyFilters();
    }

    @Test(alwaysRun = true)
    public void applyDetectionConfFilter() {
        ReportFilter filter = new ReportFilter(driver);
        String filterName = "Det conf";
        String detectionConf = (String) testData.get("detection");
        filter.filter(filterName);
        filter.detectionConfFilter(detectionConf);
        filter.applyFilters();
    }

    @Test(alwaysRun = true)
    public void applyGenderFilter() {
        ReportFilter filter = new ReportFilter(driver);
        String filterName = "Gender";
        filter.filter(filterName);
        filter.selectGender();
        filter.applyFilters();
    }

    @Test(alwaysRun = true)
    public void applyGlassesFilter() {
        ReportFilter filter = new ReportFilter(driver);
        String filterName = "Glasses";
        filter.filter(filterName);
        filter.glassesFilter();
        filter.applyFilters();
    }

    @Test(alwaysRun = true)
    public void applyMaskFilter() {
        ReportFilter filter = new ReportFilter(driver);
        String filterName = "Mask";
        filter.filter(filterName);
        filter.maskFilter();
        filter.applyFilters();
    }

    @Test(alwaysRun = true)
    public void applyEmotionFilter() {
        ReportFilter filter = new ReportFilter(driver);
        String filterName = "Emotion";
        filter.filter(filterName);
        filter.emotionFilter();
        filter.applyFilters();
    }

    @Test(alwaysRun = true)
    public void applyEventPerPageFilter() {
        ReportFilter filter = new ReportFilter(driver);
        String filterName = "Event per page";
        filter.filter(filterName);
        filter.eventPerPageFilter();
        filter.applyFilters();
    }

    @Test(alwaysRun = true)
    public void applyClearAllFilters() {
        ReportFilter filter = new ReportFilter(driver);
        filter.clearAllFilters();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Factory
    public static Object[] createInstances() {
        String jsonFilePath = System.getProperty("user.dir") + "\\src\\test\\java\\vaibhav\\JsonData\\data.json";
        JsonDataReader jsonReader = new JsonDataReader();
        List<HashMap<String, Object>> jsonData = jsonReader.readData(jsonFilePath);

        Object[] instances = new Object[jsonData.size()];
        for (int i = 0; i < jsonData.size(); i++) {
            instances[i] = jsonData.get(i);
        }
        return instances;
    }

}
