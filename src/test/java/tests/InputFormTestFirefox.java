package tests;

import input_form.InputFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;
import selenium_core.DriverType;

import java.util.concurrent.TimeUnit;

public class InputFormTestFirefox {

    String URL = "http://www.seleniumeasy.com/test/input-form-demo.html";

    private final By sendButton = By.cssSelector(".btn.btn-default");

    WebDriver driver;
    DriverManager driverManager;
    InputFormPage form;

    @BeforeMethod
    public void setup() {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.FIREFOX);
        driver = driverManager.getWebDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void inputFormDemo() throws Exception {
        form = new InputFormPage(driver);
        form.registerUser("Pera", "Kojot", "pera.kojot@email.com", "0001234567", "address 1", "Los Angeles", "California", "11000", "www.google.com", "Yes",
                "Final Exam");
        form.clickElement(sendButton);
    }

    @AfterMethod
    public void tearDown() {
        driverManager.quitWebDriver();
    }
}
