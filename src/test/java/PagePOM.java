import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

    public String verifyFormSubmit() {
        String actualText = driver.findElement(formText).getText();
        System.out.println("Text: " + actualText);
        return actualText;
    }

    public Boolean isCheckboxChecked(By element) {
        if (driver.findElement(element).isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    public void clickOnCheckbox(By element) {
        if (driver.findElement(element).isDisplayed()) {
            driver.findElement(element).click();
        }
    }

}