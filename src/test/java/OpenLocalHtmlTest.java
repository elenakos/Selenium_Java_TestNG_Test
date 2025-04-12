import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
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

    @AfterTest
    public void tearDown() {
        System.out.println("*** Test suite - end");
        driver.quit();
    }
}