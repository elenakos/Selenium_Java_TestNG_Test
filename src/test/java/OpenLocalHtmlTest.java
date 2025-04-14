import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;

public class OpenLocalHtmlTest {

    private WebDriver driver;
    private PagePOM pagePOM;
    String projectPath = System.getProperty("user.dir"); // Gets the current project directory

    @BeforeTest
    public void setUp() {
        System.out.println("*** Test suite - start");
        driver = new ChromeDriver();
        pagePOM = new PagePOM(driver);
        driver.manage().window().maximize();
        String relativePath = "src/test/HTML/Page.html";
        File file = new File(projectPath, relativePath);
        String absolutePath = file.getAbsolutePath();
        String fileUrl = "file://" + absolutePath;

        // Navigate to the local HTML file
        driver.get(fileUrl);
    }
    @BeforeMethod
    public void startTest() {
        System.out.println("**** Test case - start");
    }

    @AfterMethod
    public void endTest() {
        System.out.println("**** Test case - end");
    }

    @Test
    public void verifyPageTitle() {
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);
        String expectedTitle = "Web form";
        Assert.assertEquals(pageTitle, expectedTitle);
    }

    @Test
    public void verifyFormSubmit() {
        pagePOM.fillForm("Hello", "Password");
        pagePOM.submitForm();
        String actualText = pagePOM.verifyFormSubmit();
        System.out.println("Text: " + actualText);
        String expectedText ="Submitted!";
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void verifyCheckboxIsChecked() {
        Assert.assertTrue(pagePOM.isCheckboxChecked(pagePOM.checkbox1));
    }

    @Test
    public void verifyCheckboxCanBeChecked() {
        pagePOM.clickOnCheckbox(pagePOM.checkbox2);
        Assert.assertTrue(pagePOM.isCheckboxChecked(pagePOM.checkbox2));
    }

    @AfterTest
    public void tearDown() {
        System.out.println("*** Test suite - end");
        driver.quit();
    }
}