package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.elements.BasicPage;

import java.util.List;

public class ProductDetailsPage extends BasicPage {

    @FindBy(xpath = "//div[@class='sizes']/a")
    private List<WebElement> sizes;

    @FindBy(xpath = "//h1")
    private List<WebElement> h1Headers;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
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

}
