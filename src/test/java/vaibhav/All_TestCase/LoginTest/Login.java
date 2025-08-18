package vaibhav.All_TestCase.LoginTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class Login {

     public Login(WebDriver driver) {

           PageFactory.initElements(driver, this);
        }

    @FindBy(name="userName")
     WebElement usernameField;

    @FindBy(name="password")
    WebElement passwordField;

    @FindBy(xpath = "//button[text()=' login ']")
    WebElement loginButton;

       

    public void testInvalidLogin(WebDriver driver) {
     
        this.usernameField.click();
        this.usernameField.sendKeys("admin");
        this.passwordField.sendKeys("Admin@123456");
        this.loginButton.click();

        // driver.findElement(By.xpath("//input[@formcontrolname=\"userName\"]")).sendKeys("admin");
        // driver.findElement(By.xpath("//input[@formcontrolname=\"password\"]")).sendKeys("Admin@12345");
        // driver.findElement(By.xpath("(//footer/div/button)[1]")).click();

        try {
            Thread.sleep(2000); // Wait for 2 seconds to allow the page to load
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify the login failure
        String currentUrl1 = driver.getCurrentUrl();
        if (currentUrl1.contains("login")) {
            System.out.println("Login failed as expected.");
        } else {
            System.out.println("Login did not fail as expected.");
        }

        String loginUrl = "http://localhost:5012/Account/login";

        try {
            URI uri = new URI(loginUrl);
            URL url = uri.toURL();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.connect();

            int responseCode = connection.getResponseCode();
            System.out.println("URL: " + loginUrl);
            System.out.println("Response Code: " + responseCode);

            Assert.assertTrue(responseCode >= 400, "URL is not valid or the server is down");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void testValidLogin(WebDriver driver) {

        usernameField.clear();
        usernameField.sendKeys("admin");
        passwordField.clear();
        passwordField.sendKeys("Admin@12345");
        loginButton.click();

        String url="http://localhost:5012/Account/login";
        try {
            
            URI uri=new URI(url);
            URL loginUrl=uri.toURL();
            HttpURLConnection connection=(HttpURLConnection) loginUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.connect();

            int statusCode = connection.getResponseCode();
            System.out.println("Response Code: " + statusCode);
    
            // Assert.assertTrue(statusCode == 200);

        } catch (Exception e) {
            e.printStackTrace();
        }

       
    }
}
