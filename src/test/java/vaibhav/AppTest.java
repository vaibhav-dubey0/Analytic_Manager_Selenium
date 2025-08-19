package vaibhav;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vaibhav.All_TestCase.LoginTest.Login;
import vaibhav.JsonData.JsonDataReader;
import vaibhav.Reports_Section.ReportFilter;


@Listeners(vaibhav.TestListinersClasses.Listiners.class)
public class AppTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp()
    {
        
        driver=new ChromeDriver();
        driver.get("http://localhost:5012/login");
        driver.manage().window().maximize();    
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
        System.out.println("Test executed successfully!");
    }

    @Test
    public void loginTestInvalidData() {
        Login login=new Login(driver);
        login.loginMethod("admin","Admin@123");
    }

    @Test()
    public void loginTestValidData() {

        Login login=new Login(driver);
        login.loginMethod("admin","Admin@12345");
    }

    @Test
    public void deviceFilterTest() {
        ReportFilter filter = new ReportFilter(driver);
        filter.filter("Device");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DataProvider(name = "jsonDataProvider")
    public Object[][] jsonDataProvider() {

        String jsonFilePath = System.getProperty("user.dir") + "\\src\\test\\java\\vaibhav\\JsonData\\data.json";

        JsonDataReader jsonReader = new JsonDataReader();
        HashMap<String, Object> jsonData = jsonReader.readData(jsonFilePath);

        Object[][] data = new Object[jsonData.size()][1];
        int i = 0;
        for (String key : jsonData.keySet()) {
            data[i][0] = jsonData.get(key);
            i++;
        }
        return data;
    }

}
