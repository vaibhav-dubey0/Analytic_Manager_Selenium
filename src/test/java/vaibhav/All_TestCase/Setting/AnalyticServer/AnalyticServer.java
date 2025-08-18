package vaibhav.All_TestCase.Setting.AnalyticServer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnalyticServer {

    public AnalyticServer(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space(text())='Setting']")
    WebElement setting;

    @FindBy(xpath="//div[text()='Analytic server']")
    WebElement analyticServer;

    @FindBy(xpath = "(//button[@class='i2v-btn-icon primary-outline medium flex-row-center-center ng-star-inserted'])[1]")
    WebElement addIcon;

    @FindBy(xpath = "//span[normalize-space(text())='CPU']")
    WebElement serverType;

    @FindBy(xpath = "//input[@formcontrolname='name']")
    WebElement nameInput;

    @FindBy(xpath = "//input[@formcontrolname='ip']")
    WebElement ipInput;

    @FindBy(xpath = "//input[@formcontrolname='restPort']")
    WebElement restPortInput;

    @FindBy(xpath = "//input[@formcontrolname='alertListeningPort']")
    WebElement alertPortInput;

    @FindBy(xpath = "//input[@formcontrolname='streamingPort']")
    WebElement streamingPortInput;

    @FindBy(xpath = "//button[normalize-space(text())='Update']")
    WebElement updateButton;

    @FindBy(xpath = "//span[text()='ServerGPU']")
    WebElement serverName;

    public void addServer(WebDriver driver) {
        
        setting.click();
        analyticServer.click();
        addIcon.click();
        serverType.click();
        nameInput.sendKeys("ABC");
        ipInput.sendKeys("192.168.7.9");
        restPortInput.sendKeys("5019");
        alertPortInput.sendKeys("5020");
        streamingPortInput.sendKeys("8083");
        updateButton.click();

        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void editServer(WebDriver driver) {



        driver.findElement(By.xpath("//span[text()=' Setting ']")).click();

        driver.findElement(By.xpath("//span[text()='ServerGPU']")).click();

        driver.findElement(By.xpath("//div[@class=\"headingsDiv\"]/button")).click();

        driver.findElement(By.xpath("//input[@formcontrolname=\"name\"]")).clear();

        driver.findElement(By.xpath("//input[@formcontrolname=\"name\"]")).sendKeys("Edir_GPU_Server");

        driver.findElement(By.xpath("//button[text()='Update ']")).click();
    }

    public void deleteServer(WebDriver driver) {
        
    }

}
