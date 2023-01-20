package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.elements.BasicPage;

import java.util.List;

public class ProductDetailsPage extends BasicPage {

    @FindBy(xpath = "//div[@class='sizes']/a")
    private List<WebElement> sizes;

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


}
