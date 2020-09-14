package select_dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class SelectDropDownPage {
    WebDriver driver;

    public SelectDropDownPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By selectedDay = By.cssSelector("p.selected-value");
    private final By selectMultiStates = By.cssSelector("select#multi-select");
    private final By selectedStates = By.cssSelector("p.getall-selected");

    public void clickSingleDay(String day) {
        String i;
        By selectSingleDay;
        switch (day) {
        case "Sunday":
            i = "2";
            selectSingleDay = By.cssSelector("#select-demo.form-control>option:nth-child(" + i + ")");
            break;
        case "Monday":
            i = "3";
            selectSingleDay = By.cssSelector("#select-demo.form-control>option:nth-child(" + i + ")");
            break;
        case "Tuesday":
            i = "4";
            selectSingleDay = By.cssSelector("#select-demo.form-control>option:nth-child(" + i + ")");
            break;
        case "Wednesday":
            i = "5";
            selectSingleDay = By.cssSelector("#select-demo.form-control>option:nth-child(" + i + ")");
            break;
        case "Thursday":
            i = "6";
            selectSingleDay = By.cssSelector("#select-demo.form-control>option:nth-child(" + i + ")");
            break;
        case "Friday":
            i = "7";
            selectSingleDay = By.cssSelector("#select-demo.form-control>option:nth-child(" + i + ")");
            break;
        case "Saturday":
            i = "8";
            selectSingleDay = By.cssSelector("#select-demo.form-control>option:nth-child(" + i + ")");
            break;
        default:
            selectSingleDay = By.cssSelector("#select-demo.form-control>option:nth-child(1)");
            break;
        }
        driver.findElement(selectSingleDay).click();
    }

    public void selectMultipleStates(String commaSeparatedStates) {
        String[] states = commaSeparatedStates.split(",");
        Select selectStates = new Select(driver.findElement(selectMultiStates));
        List<WebElement> options = selectStates.getOptions();
        Actions builder = new Actions(driver);
        boolean isMultiple = selectStates.isMultiple();
        if (isMultiple) {
            selectStates.deselectAll();
        }
        builder.keyDown(Keys.CONTROL);
        for (String state : states) {
            for (WebElement option : options) {
                String optionText = option.getText();
                if (optionText.equals(state)) {
                    if (isMultiple) {
                        if (!option.isSelected()) {
                            builder.moveToElement(option);
                            builder.clickAndHold(option);
                            builder.pause(1000);
                            builder.release(option);
                        }
                    } else {
                        option.click();
                    }
                    break;
                }
            }
        }
        builder.keyUp(Keys.CONTROL).build().perform();
    }

    public void clickButton(By button) {
        driver.findElement(button).click();
    }

    public void checkFirstSelectedState(String states) {
        String actualResult = driver.findElement(selectedStates).getText();
        String expectedResult = "First selected option is : " + states + "";
        Assert.assertEquals(actualResult, expectedResult);
    }

    public void checkAllSelectedStates(String states) {
        String actualResult = driver.findElement(selectedStates).getText();
        String expectedResult = "Options selected are : " + states + "";
        Assert.assertEquals(actualResult, expectedResult);
    }

    public void checkSingleDay(String day) {
        String actualResult = driver.findElement(selectedDay).getText();
        String expectedResult = "Day selected :- " + day + "";
        Assert.assertEquals(actualResult, expectedResult);
    }
}
