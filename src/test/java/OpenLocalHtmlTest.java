import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.time.Duration;
import java.io.File;

public class OpenLocalHtmlTest {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir"); // Gets the current project directory

    @BeforeTest
    public void setUp() {
        // Set the path to the ChromeDriver executable
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    @Test
    public void openLocalHtmlFile() {
        String relativePath = "src/test/HTML/Page.html";
        File file = new File(projectPath, relativePath);
        String absolutePath = file.getAbsolutePath();
        String fileUrl = "file://" + absolutePath;

        // Navigate to the local HTML file
        driver.get(fileUrl);

        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);
        String expectedTitle = "Web form";
        Assert.assertEquals(pageTitle, expectedTitle);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}