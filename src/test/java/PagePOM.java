import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class PagePOM {
    private WebDriver driver;
    private Utilities utilities;

    // Locators and elements
    private By formText = By.id("demo");
    private By idField = By.id("my-id");
    private By passwordField = By.id("my-password");
    private By submitButton = By.id("submit");

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
        return actualText;
    }

}