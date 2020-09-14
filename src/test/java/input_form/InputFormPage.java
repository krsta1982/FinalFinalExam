package input_form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class InputFormPage {
    WebDriver driver;

    public InputFormPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstName = By.name("first_name");
    private final By lastName = By.name("last_name");
    private final By email = By.name("email");
    private final By phone = By.name("phone");
    private final By address = By.name("address");
    private final By city = By.name("city");
    private final By state = By.name("state");
    private final By zipCode = By.name("zip");
    private final By website = By.name("website");
    private final By comment = By.name("comment");
    private final By sendButton = By.cssSelector(".btn.btn-default");

    public void enterText(String text, By toElement) {
        driver.findElement(toElement).sendKeys(text);
    }

    public void clickElement(By clickElement) {
        driver.findElement(clickElement).click();
    }

    public void selectElementByValue(String value, By selectElement) {
        Select select = new Select(driver.findElement(selectElement));
        select.selectByVisibleText(value);
    }

    public void selectRadioButtonOption(String option) throws Exception {
        if ("Yes".equals(option)) {
            driver.findElement(By.cssSelector(".radio>label>input[value=\"yes\"]")).click();
        }
        else if ("No".equals(option)) {
            driver.findElement(By.cssSelector(".radio>label>input[value=\"no\"]")).click();
        }
        else {
            throw new Exception("Given option does not exist");
        }
    }

    public void registerUser(String firstNameText, String lastNameText, String emailText, String phoneText, String addressText, String cityText,
            String stateText, String zipCodeText, String websiteText, String hostingText, String commentText) throws Exception {

        enterText(firstNameText, firstName);
        enterText(lastNameText, lastName);
        enterText(emailText, email);
        enterText(phoneText, phone);
        enterText(addressText, address);
        enterText(cityText, city);
        selectElementByValue(stateText, state);
        enterText(zipCodeText, zipCode);
        enterText(websiteText, website);
        selectRadioButtonOption(hostingText);
        enterText(commentText, comment);
        clickElement(sendButton);
    }
}
