package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.elements.AddToBasketModal;
import pages.elements.BasicPage;

import java.util.List;
import java.util.Random;

public class ProductDetailsPage extends BasicPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='sizes']/a")
    private List<WebElement> sizes;

    @FindBy(xpath = "//h1")
    private List<WebElement> h1Headers;

    @FindBy(xpath = "//div[@class = 'button_wrap']/button")
    private WebElement addToBasketButton;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean sizeIdIsActive(int sizeId){
        if (sizes.size() < sizeId) return false;
        if (sizeId < 0)            return false;

        return sizes.get(sizeId)
                .getAttribute("class")
                .equals("size active");
    }

    public int h1HeadersNumber(){
        return h1Headers.size();
    }

    public String h1Text(){
        return h1Headers.get(0).getText();
    }

    public ProductDetailsPage pickSize(int id){
        if( id < 0 ) id = 0;
        if( id > (sizes.size()-1) ) id = sizes.size()-1;
        sizes.get(id).click();
        return this;
    }

    public ProductDetailsPage pickRandomSize(){
        return pickSize( new Random().nextInt(sizes.size()));
    }

    public AddToBasketModal addToBasket(){
        addToBasketButton.click();
        return new AddToBasketModal(driver);
    }

}
