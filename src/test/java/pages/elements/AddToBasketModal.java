package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasketPage;
import pages.ProductDetailsPage;

public class AddToBasketModal {

    private WebDriver driver;

    //modal associated with clicking addToBasketButton
    @FindBy(xpath = "//a[@class = 'btn left']")
    private WebElement continueButton;

    @FindBy(xpath = "//a[@class = 'btn btn-red right']")
    private WebElement checkoutButton;

    public AddToBasketModal(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public ProductDetailsPage continueShopping(){
        driver.switchTo().activeElement();
        continueButton.click();
        return new ProductDetailsPage(driver);
    }

    public BasketPage proceedToCheckout(){
        checkoutButton.click();
        return new BasketPage(driver);
    }
}
