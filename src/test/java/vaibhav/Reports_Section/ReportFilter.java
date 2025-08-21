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

    @FindBy(xpath = "//input[@placeholder=\"Enter age\"]")
    private WebElement ageInput;

    @FindBy(xpath = "(//div[@class='p-checkbox-box'])[2]")
    private WebElement selectDevice;

    @FindBy(xpath = "//input[@placeholder='Enter detConf']")
    private WebElement detectionConf;

    @FindBy(xpath = "(//p-dropdownitem/li)[4]")
    private WebElement selectEmotion;

    @FindBy(xpath = "(//p-dropdownitem/li)[4]")
    private WebElement eventPerPage;

    @FindBy(xpath = "(//p-dropdownitem/li)[1]")
    private WebElement genderSelect;

    @FindBy(xpath = "(//p-dropdownitem/li)[1]")
    private WebElement glassesSelect;

    @FindBy(xpath = "(//p-dropdownitem/li)[1]")
    private WebElement selectMask;

    @FindBy(xpath = "//div[contains(@class,\"footer-container\")]/div/button[1]")
    private WebElement applyFilterButton;

    @FindBy(xpath = "//div[contains(@class,\"footer-container\")]/button")
    private WebElement clearAll;



    public void filter(String filterName){

        waitForElementToBeClickable(reportTab);
        reportTab.click();

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

    public void deviceFilter(){
        waitForVisibilityOfElement(selectDevice);
        selectDevice.click();
    }

    public void ageFilter(String age){

         waitForVisibilityOfElement(ageInput);
         waitForElementToBeClickable(ageInput);
        ageInput.sendKeys(age);
    }

    public void glassesFilter(){
        waitForVisibilityOfElement(glassesSelect);
        glassesSelect.click();
    }

    public void maskFilter(){
        waitForVisibilityOfElement(selectMask);
        selectMask.click();
    }

    public void emotionFilter(){

        waitForVisibilityOfElement(selectEmotion);
        selectEmotion.click();
    }

    public void eventPerPageFilter(){
        waitForVisibilityOfElement(eventPerPage);
        eventPerPage.click();
    }

    public void detectionConfFilter(String conf){
        waitForVisibilityOfElement(detectionConf);
        detectionConf.sendKeys(conf);
    }

    public void selectGender(){
        waitForVisibilityOfElement(genderSelect);
        genderSelect.click();
    }

    public void applyFilters(){
        waitForElementToBeClickable(applyFilterButton);
        applyFilterButton.click();
    }

    public void clearAllFilters(){

        waitForVisibilityOfElement(filterImage);
        filterImage.click();
        waitForElementToBeClickable(clearAll);
        clearAll.click();
        waitForElementToBeClickable(applyFilterButton);
        applyFilterButton.click();

        
    }

}
