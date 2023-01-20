package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.Browser;
import utils.MyDriverFactory;
import utils.MyExtentReports;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    protected static MyExtentReports logHtml;

    @BeforeSuite
    public void beforeSuite(){
        logHtml = new MyExtentReports();
    }

    @BeforeMethod
    public void setup(){
        driver = MyDriverFactory.getDriver(Browser.CHROME);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); // fast enought for some smoke tests
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        driver.manage().deleteAllCookies(); //want it clean each time
        driver.quit();
    }

    @AfterSuite
    public void afterSuite(){
        logHtml.flush();
    }

}


