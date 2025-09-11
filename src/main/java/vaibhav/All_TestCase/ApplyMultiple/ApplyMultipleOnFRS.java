package vaibhav.All_TestCase.ApplyMultiple;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vaibhav.Utils.GlobalWaits;


public class ApplyMultipleOnFRS extends GlobalWaits{

WebDriver driver;
public ApplyMultipleOnFRS(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "//span[normalize-space(text())='Setting']")
  private WebElement setting;

  @FindBy(xpath = "//div[normalize-space(text())='Video source']")
  private WebElement videosource;

  @FindBy(xpath = "//span[normalize-space(text())='Vaibhav_Dubey']")
  private WebElement camName;

  @FindBy(xpath = "//button[normalize-space(text())='Modify Configuration']")
  private WebElement modifyConf;

  @FindBy(xpath = "//div[@class='footer-container-right']/button[3]")
  private WebElement applyMultiple;

  @FindBy(xpath = "(//label[contains(@class,'i2v-toggle')])[2]")
  private WebElement rtspButton;

  @FindBy(xpath = "")
  private WebElement frsCheck;

  @FindBy(xpath = "")
  private WebElement save;


  public void applyMultipleFilters() {

     waitForVisibilityOfElement(setting);
     setting.click();

     waitForVisibilityOfElement(videosource);
     videosource.click();

     waitForVisibilityOfElement(camName);
     waitForElementToBeClickable(camName);
     camName.click();
 
     waitForVisibilityOfElement(modifyConf);
     waitForElementToBeClickable(modifyConf);
     modifyConf.click();


     waitForVisibilityOfElement(applyMultiple);
     applyMultiple.click();


     waitForElementToBeClickable(rtspButton);
     rtspButton.click();
  }
}
