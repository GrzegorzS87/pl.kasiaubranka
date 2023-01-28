package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.elements.BasicPage;

import java.util.List;

public class Step2Page extends BasicPage {

    private WebDriver driver;
    public static String url = "https://www.kasiaubranka.pl/pl/basket/step2";

    @FindBy(xpath = "//button")
    private List<WebElement> buttons;

    public Step2Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public Step3Page clickNoRegisterPurchase(){
        buttons.get(1).click();
        return new Step3Page(driver);
    }
}
