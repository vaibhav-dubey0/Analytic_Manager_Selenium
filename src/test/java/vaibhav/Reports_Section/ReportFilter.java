package vaibhav.Reports_Section;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vaibhav.GlobalUseProperty;

public class ReportFilter extends GlobalUseProperty{

    public WebDriver driver;
    public ReportFilter(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Report']")
    private WebElement reportTab;

    @FindBy(xpath = "//div[@class='right']/button[1]")
    private WebElement filterImage;

    @FindBy(xpath="//div[contains(@class,\"checkbox-label\")]/label/span")
    List<WebElement> checkboxes;

    @FindBy(xpath = "//div[contains(@class,'filter-input-name')]")
    private List<WebElement> filterElements;

    @FindBy(xpath = "(//div[@formarrayname=\"formFilters\"]/div[2]/div/div[2]/div)")
    private List<WebElement> filterDropdowns;

    public void filter(String filterName){

        
        waitForElementToBeClickable(reportTab);
        reportTab.click();

        // try {
        //     Thread.sleep(2000);
        // } catch (InterruptedException e) {
            
        //     e.printStackTrace();
        // }
    
        waitForVisibilityOfElement(filterImage);
        waitForElementToBeClickable(filterImage);
        filterImage.click();

        waitUntilVisibilityOfAllElements(filterElements);

        for (int i = 0; i < filterElements.size(); i++) {
            
            String actualText = filterElements.get(i).getText().trim();
           
            if (actualText.equals(filterName)) {

                waitForElementToBeClickable(checkboxes.get(i));
                checkboxes.get(i).click();
                waitForVisibilityOfElement(filterDropdowns.get(i));
                filterDropdowns.get(i).click();
                break;

            }
        }

    } 
    
}
