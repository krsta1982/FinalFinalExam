package selenium_core;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver;

    protected abstract void createWebDriver();

    public WebDriver getWebDriver(){
        if (driver == null) {
            createWebDriver();
        }
        return driver;
    }

    public void quitWebDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
