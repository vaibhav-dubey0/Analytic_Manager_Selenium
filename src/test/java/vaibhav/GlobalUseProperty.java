package vaibhav;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GlobalUseProperty {

    WebDriver driver;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public GlobalUseProperty(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibilityOfElement(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBePresent(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElementToBePresent(WebElement element) {
        wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
    }

}
