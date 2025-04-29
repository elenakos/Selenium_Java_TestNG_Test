import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static java.lang.Thread.sleep;

public class PagePOM {
    private WebDriver driver;
    private Utilities utilities;

    // Locators and elements
    public By formText = By.id("demo");
    public By idField = By.id("my-id");
    public By passwordField = By.id("my-password");
    public By submitButton = By.id("submit");
    public By checkbox1 = By.id("my-check-1");
    public By checkbox2 = By.id("my-check-2");
    public By radioButton1 = By.id("my-radio-1");
    public By radioButton2 = By.id("my-radio-2");
    public By dropDownList = By.name("my-select");
    public By datalistInput = By.name("my-datalist");
    public By datalistDropDown = By.id("my-options");

    public By dateInput = By.name("dateInput");

    public PagePOM(WebDriver driver) {
        this.driver = driver;
        this.utilities = new Utilities(driver);
    }

    public void enterText(By element, String text) {
        WebElement field = driver.findElement(element);
        if (field.isDisplayed()) {
            field.clear();
            field.sendKeys(text);
        }
    }
    public void fillForm(String userID, String password) {
        enterText(idField, userID);
        enterText(passwordField, password);
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }

    public String verifyFormSubmitStatus() {
        String actualText = driver.findElement(formText).getText();
        System.out.println("Text: " + actualText);
        return actualText;
    }

    public Boolean isCheckboxRadiobuttonChecked(By element) {
        if (driver.findElement(element).isDisplayed()) {
            driver.findElement(element).isSelected();
            return true;
        } else {
            return false;
        }
    }

    public void clickOnCheckboxRadioButton(By element) {
        if (driver.findElement(element).isDisplayed()) {
            driver.findElement(element).click();
        }
    }

    public void selectOptionFromDropDownList(By element, String option) {
        Select dropdown = new Select(driver.findElement(element));
        if (driver.findElement(element).isDisplayed()) {
            dropdown.selectByVisibleText(option);
        }
    }

    public String verifySelectedOptionInDropdownList(By element) {
        Select dropdown = new Select(driver.findElement(element));
        WebElement selectedOption = dropdown.getFirstSelectedOption();
        return selectedOption.getText();
    }

    public void typeAndSelectOptionInDataList(By textInputElement, String optionToType) throws InterruptedException {
        WebElement dataInput = driver.findElement(textInputElement);
        dataInput.sendKeys(optionToType);
        sleep(1000);
        dataInput.sendKeys(Keys.ARROW_DOWN);
        dataInput.sendKeys(Keys.DOWN);
    }

    public String returnFieldValue(By textInputElement) {
        String actualText = driver.findElement(textInputElement).getAttribute("value");
        System.out.println("Text from a field: " + actualText);
        return actualText;
    }

    public String returnFieldPlaceholderValue(By textInputElement) {
        String actualText = driver.findElement(textInputElement).getAttribute("placeholder");
        System.out.println("Placeholder in a field: " + actualText);
        return actualText;
    }

    public void fillDate(By dateInputElement, String date) {
        enterText(dateInputElement, date);
    }

    public void fillDate(By dateInputElement) {
        String formattedDate = utilities.returnTodayDate();
        enterText(dateInputElement, formattedDate);
    }
}