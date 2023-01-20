package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriverFactory {

    private MyDriverFactory(){

    }

    public static WebDriver getDriver(){
        return getDriver(Browser.CHROME);
    }

    public static WebDriver getDriver(Browser name){
        switch (name){
            case FIREFOX:{
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
            default:{ //Browser.CHROME, it's the one I use for practice
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
        }
    }

}
