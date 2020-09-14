package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import select_dropdown.SelectDropDownPage;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;
import selenium_core.DriverType;

import java.util.concurrent.TimeUnit;

public class SelectDropDownTest {

    String URL = "http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";

    private final By getAllButton = By.cssSelector("#printAll.btn.btn-primary");
    private final By firstSelected = By.cssSelector("#printMe.btn.btn-primary");

    WebDriver driver;
    DriverManager driverManager;
    SelectDropDownPage selectSingleDay;
    SelectDropDownPage selectMultipleStates;

    @BeforeMethod
    public void setup() {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void selectSingleListDemo() {
        selectSingleDay = new SelectDropDownPage(driver);
        selectSingleDay.clickSingleDay("Sunday");
        selectSingleDay.checkSingleDay("Sunday");
    }

    @Test
    public void selectMultiListDemo() {
        selectMultipleStates = new SelectDropDownPage(driver);
        selectMultipleStates.selectMultipleStates("Texas,California,Florida,New York");
        selectMultipleStates.clickButton(getAllButton);
        selectMultipleStates.checkAllSelectedStates("Texas,California,Florida,New York");
        selectMultipleStates.clickButton(firstSelected);
        selectMultipleStates.checkFirstSelectedState("Texas");
    }

    @AfterMethod
    public void tearDown() {
        driverManager.quitWebDriver();
    }
}
