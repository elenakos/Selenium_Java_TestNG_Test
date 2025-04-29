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
    public By datalistDropDown = By.id("my-options");
    public By datalistInput = By.name("my-datalist");


    public PagePOM(WebDriver driver) {
        this.driver = driver;
        this.utilities = new Utilities(driver);
    }

    public void fillForm(String userID, String password) {
        driver.findElement(idField).sendKeys(userID);
        driver.findElement(passwordField).sendKeys(password);
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

    public void typeAndSelectOptionInDropdownList(By textInputElement, String optionToType) throws InterruptedException {
        driver.findElement(textInputElement).sendKeys(optionToType);
        sleep(500);
        driver.findElement(textInputElement).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(textInputElement).sendKeys(Keys.DOWN);
    }

    public String returnFieldValue(By textInputElement) {
        String actualText = driver.findElement(textInputElement).getAttribute("value");
        System.out.println("Text: " + actualText);
        return actualText;
    }
}