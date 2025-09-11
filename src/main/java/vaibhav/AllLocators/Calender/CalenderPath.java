package vaibhav.AllLocators.Calender;

import org.openqa.selenium.By;

public class CalenderPath {

    public static final By CROSS_ICON = By.xpath("//span[@data-cy='closeModal']");
    public static final By ONE_WAY = By.xpath("//li[@data-cy='oneWayTrip']");
    public static final By ONE_WAY_RADIO=By.xpath("//li[@data-cy='oneWayTrip']/span");
    public static final By ONE_WAY_FROM=By.xpath("//label[@for='fromCity']");
    public static final By ONE_WAY_FROM_SEARCH_IP=By.xpath("//div[@role='combobox']/input");
    public static final By ONE_WAY_FROM_CITY=By.xpath("//p[contains(@class,'searchedResult')]");
    public static final By ONE_WAY_TO=By.xpath("//label[@for='toCity']");
    public static final By ONE_WAY_TO_SEARCH_IP=By.xpath("//div[@role='combobox']/input");
    //div[@role='listbox']/div/ul/li
    public static final By ONE_WAY_TO_CITY=By.xpath("//p[contains(@class,'searchedResult')]");

    
}
