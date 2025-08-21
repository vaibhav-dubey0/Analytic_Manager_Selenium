package vaibhav.ApplyMultiple;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import vaibhav.All_TestCase.LoginTest.Login;

public class demo {
    public static void main(String[] args) {
       

        WebDriver driver =new ChromeDriver(); 
        driver.get("http://localhost:5012/login");
        driver.manage().window().maximize();    
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        Login login=new Login(driver);
        login.loginMethod("admin","Admin@12345");

        ApplyMultipleOnFRS apm=new ApplyMultipleOnFRS(driver);
        apm.applyMultipleFilters();

    }
}
