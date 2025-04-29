import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.lang.reflect.Method;
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

    @AfterTest
    public void tearDown() {
        System.out.println("*** Test suite - end");
        driver.quit();
    }

    @BeforeMethod
    public void startTest(Method method) {
        System.out.println("**** Test case - start of: " + method.getName() + "()");
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
    public void verifyFormCanBeSubmitted() {
        pagePOM.fillForm("Hello", "Password");
        pagePOM.submitForm();
        String actualText = pagePOM.verifyFormSubmitStatus();
        System.out.println("Text: " + actualText);
        String expectedText ="Submitted!";
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void verifyCheckboxIsChecked() {
        Assert.assertTrue(pagePOM.isCheckboxRadiobuttonChecked(pagePOM.checkbox1));
    }

    @Test
    public void verifyCheckboxCanBeChecked() {
        pagePOM.clickOnCheckboxRadioButton(pagePOM.checkbox2);
        Assert.assertTrue(pagePOM.isCheckboxRadiobuttonChecked(pagePOM.checkbox2));
    }

    @Test
    public void verifyRadioButtonCanBeSelected() {
        pagePOM.clickOnCheckboxRadioButton(pagePOM.radioButton2);
        Assert.assertTrue(pagePOM.isCheckboxRadiobuttonChecked(pagePOM.radioButton2));
    }

    @Test
    public void verifyDropdownListOptionCanBeSelected() {
        String optionToSelect = "Two";
        pagePOM.selectOptionFromDropDownList(pagePOM.dropDownList, optionToSelect);
        String selectedOption = pagePOM.verifySelectedOptionInDropdownList(pagePOM.dropDownList);
        Assert.assertEquals(selectedOption, optionToSelect);
    }

    @Test
    public void verifyDataListOptionCanBeSelected() throws InterruptedException {
        String optionToType = "San Francisco";
        String expectedOption = "San Francisco";
        pagePOM.typeAndSelectOptionInDropdownList(pagePOM.datalistInput, optionToType);
        String selectedOption = pagePOM.returnFieldValue(pagePOM.datalistInput);
        Assert.assertEquals(selectedOption, expectedOption);
    }

}