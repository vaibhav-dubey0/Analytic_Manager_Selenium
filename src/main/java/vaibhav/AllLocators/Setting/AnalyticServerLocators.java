package vaibhav.AllLocators.Setting;

import org.openqa.selenium.By;

public class AnalyticServerLocators {

    public static final By SETTING = By.xpath("//span[normalize-space(text())='Setting']");
    public static final By ANALYTIC_SERVER = By.xpath("//div[text()='Analytic server']");
    public static final By ADD_ICON = By.xpath("(//button[@class='i2v-btn-icon primary-outline medium flex-row-center-center ng-star-inserted'])[1]");
    public static final By SERVER_TYPE = By.xpath("//span[normalize-space(text())='CPU']");
    public static final By NAME_INPUT = By.xpath("//input[@formcontrolname='name']");
    public static final By IP_INPUT = By.xpath("//input[@formcontrolname='ip']");
    public static final By REST_PORT_INPUT = By.xpath("//input[@formcontrolname='restPort']");
    public static final By ALERT_PORT_INPUT = By.xpath("//input[@formcontrolname='alertListeningPort']");
    public static final By STREAMING_PORT_INPUT = By.xpath("//input[@formcontrolname='streamingPort']");
    public static final By UPDATE_BUTTON = By.xpath("//button[normalize-space(text())='Update']");
    public static final By SERVER_NAME = By.xpath("//span[text()='ServerGPU']");
    
}