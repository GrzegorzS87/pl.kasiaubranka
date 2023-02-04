package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.elements.BasicPage;

public class BasketPage extends BasicPage {

    private WebDriver driver;
    public static String url = "https://www.kasiaubranka.pl/pl/basket/rc";

    @FindBy(name = "button2")
    private WebElement confirmOrderButton;

    @FindBy(xpath = "//label[text() = 'Kurier InPost']")
    private WebElement deliveryMethodCourierInpostInput;

    @FindBy(xpath = "//label[contains(text(),'Przelew tradycyjny na konto')]")
    private WebElement paymentTraditionalInput;

    public BasketPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BasketPage open(){
        driver.get(url);
        closePopUp(driver);
        return this;
    }

    public BasketPage pickCourierInpost(){
        deliveryMethodCourierInpostInput. click();
        return this;
    }

    public BasketPage pickPaymentTraditional(){
        paymentTraditionalInput.click();
        return this;
    }

    public Step2Page confirmOrder(){
        confirmOrderButton.click();
        return new Step2Page(driver);
    }

}
