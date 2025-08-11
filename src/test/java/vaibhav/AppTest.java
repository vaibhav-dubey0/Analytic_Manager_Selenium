package vaibhav;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


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
    public void anotherTest(){
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
