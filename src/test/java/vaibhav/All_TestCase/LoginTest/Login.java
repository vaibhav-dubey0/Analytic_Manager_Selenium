package vaibhav.All_TestCase.LoginTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

     public Login(WebDriver driver) {

           PageFactory.initElements(driver, this);
        }

    @FindBy(xpath = "//input[@formcontrolname=\"userName\"]")
     WebElement usernameField;

    @FindBy(xpath = "//input[@formcontrolname=\"password\"]")
    WebElement passwordField;

    @FindBy(xpath = "(//footer/div/button)[1]")
    WebElement loginButton;

       

    public void loginMethod(String username, String password) {

        this.usernameField.click();
        this.usernameField.clear();
        this.usernameField.sendKeys(username);
        this.passwordField.clear();
        this.passwordField.sendKeys(password);
        this.loginButton.click();

    }

}
